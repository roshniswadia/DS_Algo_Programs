package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonBreakReflection {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingletonEx instance1 = SingletonEx.createObj();
		SingletonEx insntance3 = null;
		Constructor[] arr = SingletonEx.class.getDeclaredConstructors();
		for(Constructor a : arr) {
			a.setAccessible(true);
			insntance3 = (SingletonEx) a.newInstance();
		}
		
		if(instance1 == insntance3) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	
}
