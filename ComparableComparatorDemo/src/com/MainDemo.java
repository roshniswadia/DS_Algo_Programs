package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee e1 = new Employee();
		e1.setAge(12);
		e1.setName("Roshni");
		e1.setSalary(10000);
		
		Employee e2 = new Employee();
		e2.setAge(13);
		e2.setName("Amit");
		e2.setSalary(10000);
		
		Employee e3 = new Employee();
		e3.setAge(10);
		e3.setName("Mansi");
		e3.setSalary(10000);
		
		Employee e4 = new Employee();
		e4.setAge(10);
		e4.setName("Dev");
		e4.setSalary(10000);
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		
		AgeComparator agecomp = new AgeComparator();
		
		Collections.sort(empList,agecomp);
		
		for(Employee emp : empList) {
			System.out.println(emp.getName() + " : " + emp.getAge());
		}
		
	}

}
