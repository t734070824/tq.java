package _old.decorater.step2;

/**
 * 1.感觉好屌
 * @author tangqing
 *
 */
public class StarbuzzCoffee {
	
	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.err.println(beverage.getDescription() + ", $" + beverage.cost());
		
		Beverage beverage2 = new DarkRoast();
		beverage2.setSize(1);
		System.err.println(beverage2);
		beverage2 = new SoyForTall(beverage2);
		System.err.println(beverage2);
		beverage2 = new Mocha(beverage2);
		System.err.println(beverage2);
		beverage2 = new Mocha(beverage2);
		System.err.println(beverage2);
		beverage2 = new Whip(beverage2);
		System.err.println(beverage2);
		System.err.println(beverage2.getDescription() + ",$" + beverage2.cost());
	}

}
