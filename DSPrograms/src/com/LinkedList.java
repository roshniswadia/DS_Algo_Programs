package com;

public class LinkedList<T> {

	Node<T> head;

	static class Node<T> {
		Node<T> next;
		T data;

		public Node(T data) {
			this.data = data;
		}
	}

	public void add(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<T>(data);
		}
	}

	public void delete(T data) {
		if (head == null) {
			return;
		} else if (head.data == data) {
			head = head.next;
		} else {
			Node<T> curr = head; // 10, 20, 40, 45.65
			Node<T> prev = null;
			while (curr.data != data && curr != null) {
				curr = curr.next;
				prev = curr;
			}

			if (curr != null) {
				prev.next = curr.next;
			} else {
				return;
			}
		}
	}

	public void printList() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<String>();
		list.add("abc");
		list.add("dhdh");
		list.add("dedf");

		list.printList();

		list.delete("abc");

		list.printList();
	}

}
