package _old.factory.step4.factory;

import _old.factory.step4.ingredient.*;

public interface PizzaIngredientFactory {
	
	
	public Dough createDough();
	
	public Sauce createSauce();
	
	public Clams createClams();
	
	public Veggies[] createVeggies();
	
	public Pepperoni createPepperoni();
	
	public Chess createChess();


}
