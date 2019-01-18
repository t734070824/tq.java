package _old.factory.step3;

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
