package _singleton;

/**
 * 懒汉式变种
 * ps:效率比较低，因为需要线程同步的时候比较少。
 * @author tangqing
 *
 */
public class Singleton5 {
	
	public static Singleton5 instance = null;
	
	private Singleton5(){
	}
	
	public static synchronized Singleton5 getInstance(){
		if(instance == null)
			instance = new Singleton5();
		return instance;
	}

}
