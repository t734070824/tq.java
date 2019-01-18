package _old.factory.step4.pizzastore;

import _old.factory.step4.pizza.ChicagoStyleChessPizza;
import _old.factory.step4.pizza.ChicagoStyleClamPizza;
import _old.factory.step4.pizza.Pizza;

public class ChicagoStylePizzaStore extends PizzaStore{

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if(type.equals("Chess")){
			pizza = new ChicagoStyleChessPizza();
		}else if(type.equals("Clam")){
			pizza = new ChicagoStyleClamPizza();
		}
		return pizza;
	}

}
