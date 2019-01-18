package _old.factory.step3;

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
