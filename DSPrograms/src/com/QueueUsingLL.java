package com;

public class QueueUsingLL {
	
	Node front, rear;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
		
	}
	
	public QueueUsingLL() {
		this.front = this.rear = null;
	}
	
	public void push(int data) {
		
		Node node = new Node(data);
		
		if(front == null && rear == null) {
			front = rear = node;
		}else {
			rear.next = node;
			rear = node;
		}
		
	}
	
	public int pop() {
		if(front == null && rear == null)
			return -1;
		
		int output = front.data;
		front = front.next;
		
		if(front == null)
			this.rear = null;
		return output;
		
	}

	public static void main(String[] args) {
		
		QueueUsingLL queue = new QueueUsingLL();
		queue.push(10);
		queue.push(20);
		queue.push(40);
		queue.push(15);
		System.out.println("Queue front after push : " + queue.front.data);// 10, 20, 40 ,15
		System.out.println("Queue end after push : " + queue.rear.data);
		queue.pop();
		queue.pop();
		System.out.println("Queue front after pop : " + queue.front.data);
		System.out.println("Queue end after push : " + queue.rear.data);
		
	}

}
