package _abstract;

import org.junit.Test;

import static org.junit.Assert.*;


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
