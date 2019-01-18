package _old.singleton.me;

/**
 * 静态内部类
 * ps:线程安全；延迟加载。
 * @author tangqing
 *
 */
public class Singleton6 {

	private static class SigletonHolder {
		private static final Singleton6 instance = new Singleton6();
	}

	public static final Singleton6 getInstance() {
		return SigletonHolder.instance;
	}

}
