package _old.factory.step1;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		Pizza pizza = main.orderPizza("Chess");
		System.err.println(pizza);
		Pizza pizza2 = main.orderPizza("Chess");
		System.err.println(pizza2);
		
	}

	private Pizza orderPizza(String type) {
		SimplePizzaFactory pizzaFactory = SimplePizzaFactory.getInstence();
		return pizzaFactory.orderPizza(type);
	}
}
