package _old.factory.step4.factory;

import _old.factory.step4.pizza.ChessPizza;
import _old.factory.step4.pizza.ClamPizza;
import _old.factory.step4.pizza.Pizza;

public class SimplePizzaFactory {
	
	public SimplePizzaFactory() {
	}
	
	public static SimplePizzaFactory pizzaFactory;
	
	public static SimplePizzaFactory getInstence(){
		if(pizzaFactory == null){
			pizzaFactory = new SimplePizzaFactory();
		}
		return pizzaFactory;
	}
	
	public Pizza createPizza(String type){
		Pizza pizza = null;
		if(type.equals("Chess")){
			pizza = new ChessPizza();
		}else if(type.equals("Clam")){
			pizza = new ClamPizza();
		}
		return pizza;
		
	}
}
