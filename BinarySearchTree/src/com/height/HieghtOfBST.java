package com.height;


public class HieghtOfBST {
	
	static class Node{
		int data;
		Node left, right = null;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public int getMaxHeight(Node root) {
		if(root == null)
			return 0;
		
		int leftSubTreeHeight = getMaxHeight(root.left);
		int rightSubTreeHeight = getMaxHeight(root.right);
		
		return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
	}

	public static void main(String[] args) {
		
		HieghtOfBST bst = new HieghtOfBST();
		Node head = new Node(50);
		head.left = new Node(40);
		head.right = new Node(55);
		head.left.left = new Node(30);
		head.left.right = new Node(45);
		head.left.left.right = new Node(35);
		head.right.right = new Node(58);
		head.right.left = new Node(52);
		head.right.right.left = new Node(56);
		
		int max_height = bst.getMaxHeight(head);
		System.out.println("Max Height : " + max_height);
		
	}

}
