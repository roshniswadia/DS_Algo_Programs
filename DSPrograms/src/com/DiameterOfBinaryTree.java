package com;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class DiameterOfBinaryTree {
	
	static class Node{
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left=right=null;
		}
	}
	
	static class A{
		int max_dia = Integer.MIN_VALUE;
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
	
	public int height(Node node, A a) {
		
		if(node == null)
            return 0;
        
		int leftHeight = height(node.left, a);
		int rightHeight = height(node.right, a);
		
		a.max_dia = Math.max(a.max_dia, leftHeight + rightHeight);
		
		return 1 + Math.max(leftHeight, rightHeight);
		
	}
	
	public int diameter(Node node) {
		if(node == null)
			return 0;
		
		A a = new A();
		height(node, a);
		return a.max_dia;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiameterOfBinaryTree bst = new DiameterOfBinaryTree();
		//bst.add(50, null);
		/*Node head = new Node(50);
		head.left = new Node(40);
		head.right = new Node(55);
		head.left.left = new Node(30);
		head.left.right = new Node(45);
		head.left.left.right = new Node(35);
		head.left.left.right.right = new Node(36);
		head.right.right = new Node(58);
		head.right.left = new Node(52);
		head.right.right.left = new Node(56);*/
		
		Node head = new Node(50);
		head.left = new Node(40);
		head.left.left = new Node(35);
		head.left.right = new Node(45);
		head.right = new Node(55);
		int max_height = bst.diameter(head);
		
		System.out.println("Max Height : "+ max_height);

	}

}
