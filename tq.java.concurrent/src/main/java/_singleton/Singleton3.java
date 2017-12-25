package com.design.singleton.me;

/**
 * 恶汉变种
 * 
 * @author tangqing
 *
 */
public class Singleton3 {

	private static Singleton3 instance = null;
	
	static{instance = new Singleton3();}
	
	private Singleton3(){}
	
	private static Singleton3 getInstance(){
		return instance;
	}
}
