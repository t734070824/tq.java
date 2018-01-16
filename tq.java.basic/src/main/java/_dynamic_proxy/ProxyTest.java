package _dynamic_proxy;

public class ProxyTest {

	public static void main(String[] args) {

		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

		UserService service = new UserServiceImpl();
		MyInvocationHandler hanler = new MyInvocationHandler(service);
		Object proxy = hanler.getProxy();
        ((UserService)proxy).add();


        ((UserService)proxy).delete();

	}
}
