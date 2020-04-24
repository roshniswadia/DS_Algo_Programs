package com;

public class BooleanWithEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Boolean b1 = true; 
	        Boolean b2 = false; 
	        System.out.print((b1 == b2) + " "); 
	        System.out.print(b1.equals(b2) + " "); 
	        
	        Boolean b3 = new Boolean(true); 
	        Boolean b4 = new Boolean(true); 
	        System.out.print((b3 == b4) + " "); 
	        System.out.print(b3.equals(b4)); 
	}

}
