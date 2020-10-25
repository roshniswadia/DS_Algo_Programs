package com;

import java.io.Serializable;

public class Employee implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 123222222L;
	private String name;
	private int age;
	private String test;
	
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
