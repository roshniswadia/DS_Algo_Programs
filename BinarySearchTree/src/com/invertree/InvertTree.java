package com.invertree;

import javax.swing.plaf.basic.BasicTreeUI.TreeTraverseAction;

public class InvertTree {

	TreeNode root = null;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		
		if(root.left != null) {
			root.left = invertTree(root.left);
		}
		
		if(root.right != null) {
			root.right = invertTree(root.right);
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}
	
	public void traverseTree(TreeNode root) {
		if(root == null)
			return;
		if(root.left != null) {
			traverseTree(root.left);
		}
		System.out.println(root.val);
		if(root.right != null) {
			traverseTree(root.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(4);
		head.left = new TreeNode(2);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(3);
		head.right = new TreeNode(7);
		head.right.right = new TreeNode(9);
		head.right.left = new TreeNode(6);
		
		InvertTree invertTree = new InvertTree();
		invertTree.invertTree(head);
		
		invertTree.traverseTree(head);
	}
}
