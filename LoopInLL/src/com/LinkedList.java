package com;

public class LinkedList {

	Node head;

	public void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			Node oldLastNode = head;
			while (oldLastNode.next != null) {
				oldLastNode = oldLastNode.next;
			}
			oldLastNode.next = newNode;
		}
	}

	public void traverse() {
		Node nextNode = head;
		while (nextNode != null) {
			System.out.println(nextNode.value);
			nextNode = nextNode.next;
		}
	}

	public void detectAndRemoveLoop() {
		if (head == null && head.next == null)
			return;

		Node slowPointer = head;
		Node fastPointer = head;
		Node previousPointer = head;

		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			previousPointer = fastPointer.next;
			fastPointer = fastPointer.next.next;

			if (slowPointer == fastPointer) {
				slowPointer = head;

				if (slowPointer == fastPointer)
					previousPointer.next = null;
				else
					fastPointer.next = null;

			}
		}
	}

	public static void main(String[] args) {
		LinkedList g = new LinkedList();

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);

		g.head = n1;

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n6;
	}

}
