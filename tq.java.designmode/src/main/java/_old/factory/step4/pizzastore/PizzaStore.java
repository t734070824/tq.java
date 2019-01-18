package _old.factory.step4.pizzastore;

import _old.factory.step4.pizza.Pizza;

public abstract class PizzaStore {

	public Pizza orderPizza(String type){
		Pizza pizza;
		pizza = createPizza(type);
		pizza.perpare();
		pizza.cut();
		pizza.box();
		return pizza;
		
		
	}

	public abstract Pizza createPizza(String type);
}
