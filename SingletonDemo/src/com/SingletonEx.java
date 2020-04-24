package com;

import java.io.Serializable;

public class SingletonEx extends SuperClass implements Serializable{
	
	private int a = 10;

	private static SingletonEx singletonInstance;

	private SingletonEx() {
	}

	public static  SingletonEx createObj() {
		if (singletonInstance == null) { // t1 t2
			synchronized (SingletonEx.class) { //t1 t2
				if (singletonInstance == null) {
					singletonInstance = new SingletonEx(); //obj t1
				}
			}
		}

		return singletonInstance;
	}
	
	protected Object readResolve() {
		  return singletonInstance;
	}
	
	 @Override
	  protected Object clone() throws CloneNotSupportedException  
	  { 
	    throw new CloneNotSupportedException(); 
	  } 
	
	public int getA() {
		return a;
	}

}
