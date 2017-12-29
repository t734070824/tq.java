package _classloader;

public class ClassLoaderTest {
	
	
	public static void main(String[] args) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		System.err.println(classLoader);
		System.err.println(classLoader.getParent());
		System.err.println(classLoader.getParent().getParent());
	}
}
