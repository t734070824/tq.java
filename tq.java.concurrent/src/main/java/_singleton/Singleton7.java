package _singleton;

/**
 * 双重校验锁 ps:线程安全；延迟加载。
 * 
 * @author tangqing
 *
 */
public class Singleton7 {

	private volatile static Singleton7 instance;

	private Singleton7() {
	}

	public static Singleton7 getInstance() {
		if (instance == null) {
			synchronized (Singleton7.class) {
				if (instance == null) {
					instance = new Singleton7();
				}
			}
		}
		return instance;
	}

}
