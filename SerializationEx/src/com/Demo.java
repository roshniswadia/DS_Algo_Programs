package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		/*Employee emp = new Employee("Roshni", 21, "Wakad");
		FileOutputStream fos = new FileOutputStream("test.txt");
		ObjectOutputStream ous = new ObjectOutputStream(fos);
		
		ous.writeObject(emp);*/
		
		FileInputStream fis = new FileInputStream("test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee emp2 = (Employee) ois.readObject();
		
		System.out.println(emp2.getName());
		System.out.println(emp2.getAge());

	}

}
