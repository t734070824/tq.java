package _old.state.step1;

public class GumballMechineTestDrive {
	public static void main(String[] args) {
		GumballMachine machine = new GumballMachine(5);
		
//		System.err.println(machine);
//		
//		machine.insertQuarter();
//		machine.turnCrank();
//		
//		System.err.println(machine);
		
//		machine.insertQuarter();
//		machine.ejectQuarter();
//		machine.turnCrank();
//		System.err.println(machine);
		
		machine.insertQuarter();
		machine.turnCrank();
		machine.insertQuarter();
		machine.turnCrank();
		machine.ejectQuarter();
		System.err.println(machine);
	}

}
