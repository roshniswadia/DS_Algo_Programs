package com;

public class StackUsingLL {

	Node head;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public void push(int data) {
		if(head == null) {
			head = new Node(data);
		}else {
			Node temp = new Node(data);
			temp.next = head;
			head = temp;
		}
			
	}
	
	public int pop() {
		Node temp = head;
		head = head.next;
		return temp.data;
	}
	
	public static void main(String[] args) {

		StackUsingLL stack = new StackUsingLL();
		stack.push(10); // 10, 20, 50
		stack.push(20);
		stack.push(50);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	//TODO Iterable

}
