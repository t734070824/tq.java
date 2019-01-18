package _old.factory.step4.pizzastore;

import _old.factory.step4.pizza.NYStyleChessPizza;
import _old.factory.step4.pizza.NYStyleClamPizza;
import _old.factory.step4.pizza.Pizza;

public class NYStylePizzaStore extends PizzaStore{

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if(type.equals("Chess")){
			pizza = new NYStyleChessPizza();
		}else if(type.equals("Clam")){
			pizza = new NYStyleClamPizza();
		}
		return pizza;
	}

}
