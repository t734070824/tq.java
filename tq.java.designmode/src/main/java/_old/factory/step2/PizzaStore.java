package _old.factory.step2;

public class PizzaStore {
	private SimplePizzaFactory factory;
	
	public PizzaStore(SimplePizzaFactory factory) {
		this.factory = factory;
	}
	
	public Pizza orderPizza(String type){
		Pizza pizza = factory.createPizza(type);
		pizza.perpare();
		pizza.cut();
		pizza.box();
		return pizza;
		
		
	}
	
	
}
