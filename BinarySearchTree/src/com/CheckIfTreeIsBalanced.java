package com;

public class CheckIfTreeIsBalanced {
	
	Node root;
	
	static class Node{
		int data;
		Node left,right;
		
		public Node(int data) {
			this.data = data;
			right = left =null;
		}
	}

	public static void main(String[] args) {
		CheckIfTreeIsBalanced bst = new CheckIfTreeIsBalanced();
		bst.root = new Node(50);
		bst.root.left = new Node(45);
		bst.root.left.left = new Node(40);
		bst.root.left.right = new Node(46);
		bst.root.right = new Node(55);
		bst.root.right.left = new Node(51);
		bst.root.right.right = new Node(58);
		bst.root.right.left.right = new Node(53);
		
		int height = bst.checkIfBalanced(bst.root);
		if(height != -1)
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
		
	}

	public int  checkIfBalanced(Node root) {
		if(root == null)
			return 0;
		
		int leftSubTreeHeight = checkIfBalanced(root.left);
		if(leftSubTreeHeight == -1)
			return -1;
		
		int rightSubTreeHeight = checkIfBalanced(root.right);
		if(rightSubTreeHeight == -1)
			return -1;
		
		if(Math.abs(rightSubTreeHeight - leftSubTreeHeight) > 1)
			return -1;
		
		return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
	} 
}
