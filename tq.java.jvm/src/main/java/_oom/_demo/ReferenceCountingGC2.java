package _oom._demo;

public class ReferenceCountingGC2 {
	
	public Object instance = null;
	
	private static final int _1M = 1024 * 1024;
	
	public static void testAllocation(){
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1 = new byte[2 * _1M];
		allocation2 = new byte[2 * _1M];
		allocation3 = new byte[2 * _1M];
		System.err.println("AA");
		allocation4 = new byte[4 * _1M];// minor GC
		System.err.println("AA");
	}
	
	
	
	//-verbose:gc -Xms20M -Xmx20m -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	public static void main(String[] args) {
		
	}

}
