package com.design.singleton.me;

/**
 * 恶汉变种
 * 
 * @author tangqing
 *
 */
public class Singleton2 {

	private static Singleton2 instance = new Singleton2();
	
	public static Singleton2 getInstance(){
		return instance;
	}
}
