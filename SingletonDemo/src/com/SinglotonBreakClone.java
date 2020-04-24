package com;

public class SinglotonBreakClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		SingletonEx instance1 = SingletonEx.createObj();
		SingletonEx instance2 = (SingletonEx) instance1.clone();
		
		if(instance1 == instance2) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}

	}

}
