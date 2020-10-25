package com.intercectionOfLL;

public class LinkedList {
	
	Node head;
	
	static class Node{
		Node next;
		int value;
		boolean isVisited;
		
		Node(int value){
			this.value = value;
			this.next = null;
			this.isVisited = false;
		}
	}
	
	public Node add(int value) {
		if(head == null) {
			Node node = new Node(value);
			head = node;
		}else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			Node node = new Node(value);
			temp.next = node;
		}
		return head;
	}
	
	public int findIntersection(Node head1, Node head2) {
		int value = 0;
		
		Node ptr1 = head1;
		while (ptr1.next != null) {
			ptr1.isVisited = true;
			ptr1 = ptr1.next;
		}
		
		Node ptr2 = head2;
		while (ptr2.next != null) {
			
			if(ptr2.isVisited) {
				value = ptr2.value;
				break;
			}
			ptr2 = ptr2.next;
		}
		
		if(ptr2.next == null)
			return -1;
		
		return value;
	}

}
