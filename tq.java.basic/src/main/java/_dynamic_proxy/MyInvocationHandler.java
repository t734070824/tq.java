package _dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler{
	
	//目标对象
	private Object target;

	public MyInvocationHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.err.println("Before");
		Object result = method.invoke(target, args);
		System.err.println("After");
		return result;
	}
	
	/**
	 * 获取目标对象的代理对象
	 * @return
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(
				Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	
	
	

}
