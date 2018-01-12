package _demo;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import static org.junit.Assert.fail;

public class RequestCtrlCallBackTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testRequestCtrlCallBack(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Requestable.class);
		enhancer.setCallback(new RequestCtrlCallBack());
		Requestable create = (Requestable)enhancer.create();
		create.request();
		
		create.request2();
	}
}
