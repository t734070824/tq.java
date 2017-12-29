package com.annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserCaseTracker {

	public static void trackUseCases(List<Integer> userCases, Class<?> cl){
		for(Method m : cl.getDeclaredMethods()) {
			UserCase uc = m.getAnnotation(UserCase.class);
			if(uc != null) {
				System.err.println("found userCase" + uc.id() + " " + uc.description());
				userCases.remove(new Integer(uc.id()));
			}
		}
		for(int i : userCases) {
			System.err.println("Missing " + i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> userCases = new ArrayList<Integer>();
		Collections.addAll(userCases, 47, 48, 49, 50);
		trackUseCases(userCases, PassWordUtil.class);
		
	}
	
}
