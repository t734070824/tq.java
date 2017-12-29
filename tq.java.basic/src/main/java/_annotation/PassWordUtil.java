package com.annotation;
import java.util.List;

public class PassWordUtil {
	
	@UserCase(id=47, description="password contain at least one numeric")
	public boolean validatePassword(String password) {
		return (password.matches("\\w*\\d\\w*"));
	}
	
	@UserCase(id=48)
	public String encryptPassword(String password) {
		return new StringBuffer(password).reverse().toString();
	}
	
	@UserCase(id=49, description="can't equal")
	public boolean checkForNewPassword(List<String> pass, String password){
		return !pass.contains(password);
	}
}
