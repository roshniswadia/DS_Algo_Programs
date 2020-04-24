package com.levelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	Queue<Node> queue;
	
	public BinarySearchTree(Queue<Node> queue) {
		this.queue = queue;
	}
	
	static class Node{
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
		}
	}

	public void levelOrderTraversal(Node head) {
		Node curr = head;
		queue.add(curr);
		while(!queue.isEmpty()) {
				Node temp = queue.poll();
				System.out.println(temp.data);
				
				if(temp.left != null)
					queue.add(temp.left);
				
				if(temp.right != null)
					queue.add(temp.right);
		}
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
		Queue<Node> queue = new LinkedList<Node>();
		BinarySearchTree bst = new BinarySearchTree(queue);
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
		bst.levelOrderTraversal(head);

	}

}
