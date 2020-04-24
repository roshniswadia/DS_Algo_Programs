package com;

import java.util.Stack;

public class MyStack {
	
	Stack<Integer> stack;
	int minElement;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 // Removes the top element from MyStack 
    void pop() 
    { 
        if (s.isEmpty()) 
        { 
            System.out.println("Stack is empty"); 
            return; 	
        } 
  
        System.out.print("Top Most Element Removed: "); 
        Integer t = s.pop(); 
  
        // Minimum will change as the minimum element 
        // of the stack is being removed. 
        if (t < minEle) 
        { 
            System.out.println(minEle); 
            minEle = 2*minEle - t; 
        } 
  
        else
            System.out.println(t); 
    } 
	
	// Insert new number into MyStack 
    void push(Integer x) 
    { 
        if (stack.isEmpty()) 
        { 
            minElement = x; 
            stack.push(x); 
            System.out.println("Number Inserted: " + x); 
            return; 
        } 
  
        // If new number is less than original minEle 
        if (x < minElement) 
        { 
        	stack.push(2*x - minElement); 
            minElement = x; 
        } 
  
        else
        	stack.push(x); 
  
        System.out.println("Number Inserted: " + x); 
    } 

}
