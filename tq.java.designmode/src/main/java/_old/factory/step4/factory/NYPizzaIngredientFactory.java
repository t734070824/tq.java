package _old.factory.step4.factory;

import _old.factory.step4.ingredient.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new Dough();
	}

	@Override
	public Sauce createSauce() {
		return new Sauce();
	}

	@Override
	public Clams createClams() {
		return new Clams();
	}

	@Override
	public Veggies[] createVeggies() {
		return null;
	}

	@Override
	public Pepperoni createPepperoni() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chess createChess() {
		// TODO Auto-generated method stub
		return null;
	}

}
