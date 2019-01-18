package _old.factory.step1;

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
	
	public Pizza orderPizza(String type){
		Pizza pizza = null;
		if(type.equals("Chess")){
			pizza = new ChessPizza();
		}else if(type.equals("Clam")){
			pizza = new ClamPizza();
		}else if(type.equals("Prpperoni")){
			pizza = new PrpperoniPizza();
		}else if(type.equals("Veggie")){
			pizza = new VeggiePizza();
		}
		return pizza;
		
	}
}
