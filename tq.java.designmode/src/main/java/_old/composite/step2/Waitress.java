package _old.composite.step2;

public class Waitress {
	
	private MenuComponet allMeues;
	
	public Waitress(MenuComponet allMeues) {
		this.allMeues = allMeues;
	}
	
	public void print() {
		allMeues.print();
	}
}
