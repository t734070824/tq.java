package _example._bank_simulation;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 模拟银行
 */
public class BankTellerSimulation {
	private static final int MIAX_LINE_SIZE = 50;
	
	private static final int ADJUSTMENT_PERIOD = 1000;
	
	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
		CustomerLine line = new CustomerLine(MIAX_LINE_SIZE);
		service.execute(new CustomerGenerator(line));
		service.execute(new TellerManager(service, line, ADJUSTMENT_PERIOD));
		service.shutdown();
		
	}
}


class Customer {
	private final int serviveTime;
	public Customer(int serviceTime) {
		this.serviveTime = serviceTime;
	}
	
	public int getServiceTime() {
		return serviveTime;
	}
	
	@Override
	public String toString() {
		return "[" + serviveTime + "]";
	}
	
}

class CustomerLine extends ArrayBlockingQueue<Customer>{

	private static final long serialVersionUID = 1L;

	public CustomerLine(int maxLineSize) {
		super(maxLineSize);
	}
	
	@Override
	public String toString() {
		if(this.size() == 0){
			return "[Entry]";
		} else {
			StringBuilder sb = new StringBuilder();
			for(Customer customer : this){
				sb.append(customer).append("--");
			}
			return sb.toString();
		}
	}
	
}

class CustomerGenerator implements Runnable{

	private CustomerLine line;
	
	public static Random r = new Random(47);
	public CustomerGenerator(CustomerLine line) {
		this.line = line;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(r.nextInt(300));
				line.put(new Customer(r.nextInt(1000)));
			}
		} catch (InterruptedException e) {
			System.err.println("CustomerGenerator interrupted");
		}
		System.err.println("CustomerGenerator terminating");
	}
	
}

class Teller implements Runnable, Comparable<Teller>{

	private static int counter = 0;
	
	private final int id = counter++;
	
	private int customerServed = 0;//已服务数量
	
	private CustomerLine line;
	
	private boolean servingCustomerLine = true;
	
	public Teller(CustomerLine line) {
		this.line = line;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Customer customer = line.take();
				TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
				synchronized (this) {
					customerServed++;
					while (!servingCustomerLine) {
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			System.err.println(this + "interrupted");
		}
		System.err.println(this + "terminating");
	}

	public synchronized void doSomeThingElse() {
		customerServed = 0;
		servingCustomerLine = false;
	}
	
	public synchronized void serveCustomerLine() {
		servingCustomerLine = true;
		notifyAll();
	}
	
	@Override
	public String toString() {
		return "Teller:" + id;
	}
	
	public String shortString(){
		return "T:" + id;
	}
	@Override
	public synchronized int compareTo(Teller o) {
		return customerServed< o.customerServed ? -1 : (customerServed == o.customerServed ? 0 : 1);
	}
}

class TellerManager implements Runnable{
	
	private ExecutorService service;
	
	private CustomerLine line;
	
	private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
	
	private Queue<Teller> tellersDoingOtherThing = new LinkedList<>();
	
	private int adjustmentPeriod;
	
	private static Random r = new Random(47);
	
	public TellerManager(ExecutorService service,CustomerLine line, int adjustmentPeriod) {
		this.service = service;
		this.line = line;
		this.adjustmentPeriod = adjustmentPeriod;
		Teller teller = new Teller(line);
		service.execute(teller);
		workingTellers.add(teller);
	}
	
	public void adjustTellerNumber() {
		if(line.size() / workingTellers.size() > 2){
			if(tellersDoingOtherThing.size() > 0){
				Teller t = tellersDoingOtherThing.remove();
				t.serveCustomerLine();
				workingTellers.offer(t);
				return;
			}
			Teller t = new Teller(line);
			service.execute(t);
			workingTellers.add(t);
			return;
		}
		
		if(workingTellers.size() > 1 && line.size() / workingTellers.size() < 2){
			reassigOneTeller();
		}
		
		if(line.size() == 0){
			while (workingTellers.size() > 1) {
				reassigOneTeller();
			}
		}
	}

	private void reassigOneTeller() {
		Teller t = workingTellers.poll();
		t.doSomeThingElse();
		tellersDoingOtherThing.offer(t);
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
				adjustTellerNumber();
				System.err.print(line + "{");
				for(Teller teller : workingTellers) {
					System.err.print(teller.shortString());
				}
				System.err.println("}");
			}
		} catch (InterruptedException e) {
			System.err.println(this + "interrupted");
		}
		System.err.println(this + "terminating");
	}
	
	@Override
	public String toString() {
		return "TellerManager: ";
	}
	
}

