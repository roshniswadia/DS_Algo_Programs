package com;

public class Employee implements Comparable<Employee> {

	private String name;
	private int age;
	private int salary;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int compareTo(Employee e) {
		if(this.getAge() == e.getAge()) {
			return this.getName().compareTo(e.getName());
		}else if(this.getAge()< e.getAge()) {
			return -1;
		}else {
			return 1;
		}
	}
}
