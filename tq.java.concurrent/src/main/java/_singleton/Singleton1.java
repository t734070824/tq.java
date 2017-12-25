package com.design.singleton.me;

/**
 * 恶汉式
 * ps:可以通过反射机制攻击,线程安全(多个类加载器除外)
 * @author tangqing
 *
 */
public class Singleton1 {
	
	public static final Singleton1 instance = new Singleton1();
			
	private Singleton1() {
	}

}
