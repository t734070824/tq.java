package com.design.singleton.me;

/**
 * 懒汉式
 * ps:延时加载；线程不安全，多线程下不能正常工作；需要额外的工作(Serializable、transient、readResolve())来实现序列化。
 * @author tangqing
 *
 */
public class Singleton4 {
	
	public static Singleton4 instance = null;
	
	private Singleton4(){
	}
	
	public static Singleton4 getInstance(){
		if(instance == null)
			instance = new Singleton4();
		return instance;
	}

}
