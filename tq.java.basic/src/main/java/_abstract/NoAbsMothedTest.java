package _abstract;

import static org.junit.Assert.*;

import org.junit.Test;

public class NoAbsMothedTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void CreateAbs(){
		NoAbsMothed a = new NoAbsMothed() {
		};
		System.err.println(a);
	}

}
