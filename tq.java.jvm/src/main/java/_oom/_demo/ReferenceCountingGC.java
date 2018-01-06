package _oom._demo;

public class ReferenceCountingGC {
	
	public Object instance = null;
	
	private static final int _1M = 1024 * 1024;
	
	private byte[] bigSize = new byte[2 * _1M];
	
	public static void testGC(){
		ReferenceCountingGC obj1 = new ReferenceCountingGC();
		ReferenceCountingGC obj2 = new ReferenceCountingGC();
		
		obj1.instance = obj2;
		obj2.instance = obj1;
		
		obj1 = null;
		obj2 = null;
		
		System.gc();
		
	}
	
	
	
	
	
	//-Xms=10M -Xmx=10m -XX:+PrintDCDetails
	public static void main(String[] args) {
		testGC();
	}

}
