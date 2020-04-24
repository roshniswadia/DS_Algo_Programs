package com;

public class LinkedList {

	Node head;

	class Node {
		Node next;
		int value;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

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

	public void swapPair() {
		if (head == null || head.next == null)
			return;

		Node curr = head, prev = null;

		while (curr != null && curr.next != null) { // 1-2-3-4-5 curr = 3 temp = 4 curr.next = 4 temp.next = 1 prev = 1
			Node temp = curr.next;
			curr.next = temp.next;
			temp.next = curr;

			if (prev == null)
				head = temp;
			else
				prev.next = temp;

			prev = curr;
			curr = curr.next;
		}
	}

	public static Node rearrange(Node head, Node prev) {
		// base case: if list is empty or contains just one node
		if (head == null || head.next == null) {
			return head;
		}

		Node curr = head;
		Node temp = curr.next;
		curr.next = temp.next;
		temp.next = curr;

		if (prev == null) {
			head = temp;
		} else {
			prev.next = temp;
		}

		prev = curr;
		rearrange(curr.next, prev);

		return head;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list.traverse();
		list.swapPair();
		System.out.println("After SWAP ---------------------------------------");
		list.traverse();
	}

}
