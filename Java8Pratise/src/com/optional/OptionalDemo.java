package com.optional;

import java.util.Optional;
import java.util.OptionalDouble;

public class OptionalDemo {
	
	public static void main(String[] args) {
		
		Optional<String> test = Optional.empty();
		
		String name = "Roshni";
		
		
		//We can also create an Optional object with the static method of():
		//the argument passed to the of() method can't be null. 
		//Otherwise, we'll get a NullPointerException:
		Optional<String> test1 = Optional.of(name);
		
		System.out.println(test.isPresent());
		System.out.println(test1.isPresent());
		
		String name2 = null;
	    //Optional.of(name2); //Null Pointer
		
		//in case we expect some null values, we can use the ofNullable() method
		Optional<String> opt = Optional.ofNullable(name2);
		
		//The ifPresent() method enables us to run some code on the wrapped value 
		//if it's found to be non-null. Before Optional, we'd do
		if(name != null) {
		    System.out.println(name.length());
		}
		
		Optional<String> opt1 = Optional.of("baeldung");
	    opt1.ifPresent(name3 -> System.out.println(name3.length()));
	    
	    //To give default value
	    String nullName = "NotNull";
	    String name5 = Optional.ofNullable(nullName).orElseGet(() -> "john");
	    System.out.println(name5);
	    
	  //To give default value
	    String name6 = Optional.ofNullable(nullName).orElse(testMethod());
	    System.out.println(name6);
	    
	    String name7 = Optional.ofNullable(nullName).orElseGet(OptionalDemo::testMethod);
	    System.out.println(name7);
	}

	public static String testMethod() {
		System.out.println("Mehod is called.......");
		return "FromMEthod";
	}
			
		
	}
