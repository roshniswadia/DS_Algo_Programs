package com;

import java.util.Stack;

public class BSTAllPath {
	
	Stack<Integer> stack;
	
	public BSTAllPath() {
		this.stack = new Stack<>();
	}
	
	static class Node{
		int data;
		Node left, right;
		
		public Node(int item) {
			data = item;
			left = right = null;
		}
	}
	
	public void allPaths(Node node) {
		if(node == null)
			return;
		
		stack.push(node.data); // 50 40 30
		allPaths(node.left);
		if(node.left == null && node.right == null) {
			System.out.println(stack);
		}
		allPaths(node.right);
		stack.pop();
	}
	
	public Node add(int data, Node node) {
		if(node == null) {
			node = new Node(data);
		}else if(node.data > data) {
			add(data, node.left);
		}else {
			add(data, node.right);
		}
		return node;
	}

	public static void main(String[] args) {

		BSTAllPath bst = new BSTAllPath();
		bst.add(50, null);
		Node head = new Node(50);
		head.left = new Node(40);
		head.right = new Node(55);
		head.left.left = new Node(30);
		head.left.right = new Node(45);
		head.left.left.right = new Node(35);
		head.right.right = new Node(58);
		head.right.left = new Node(52);
		head.right.right.left = new Node(56);
		bst.allPaths(head);
	}

}
