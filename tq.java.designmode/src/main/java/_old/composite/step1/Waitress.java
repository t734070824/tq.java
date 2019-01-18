package _old.composite.step1;

public class Waitress {
	
	private MenuComponet allMeues;
	
	public Waitress(MenuComponet allMeues) {
		this.allMeues = allMeues;
	}
	
	public void print() {
		allMeues.print();
	}
}
