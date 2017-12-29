package com.annotation;
@DBTable(name="MEMBER")
public class Member {

	@SQLString(30)
	String firstName;
	
	@SQLString(50)
	String lastName;
	
	@SQLInteger
	Integer age;
	
	@SQLString(value=30, constraints=@Constraints(primaryKey=true))
	String handle;
	
	static int memberCount;

	@Override
	public String toString() {
		return handle;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public String getHandle() {
		return handle;
	}
	
	
}

