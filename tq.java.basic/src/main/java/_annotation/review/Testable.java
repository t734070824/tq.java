package _annotation.review;

public class Testable {

	
	public void execute(){
		System.err.println("Executing");
	}
	
	@Test void testExecute(){execute();}
}
