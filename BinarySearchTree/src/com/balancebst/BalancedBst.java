package com.balancebst;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class BalancedBst {
	
	Node root;
	static class Node  
	{ 
	    int data; 
	    Node left, right; 
	  
	    public Node(int data)  
	    { 
	        this.data = data; 
	        left = right = null; 
	    } 
	} 
	
	public void storeBstNodes(List<Node> nodeList, Node root) {
		if(root == null)
			return;
		
		storeBstNodes(nodeList, root.left);
		nodeList.add(root);
		storeBstNodes(nodeList, root.right);
	}
	
	public Node createBalancedBst(List<Node> nodeList, int start, int end) {
		
		if(start > end)
			return null;
		
		int mid = (start + end)/2;
		Node root = new Node(nodeList.get(mid).data);
		
		root.left = createBalancedBst(nodeList, start, mid - 1);
		root.right = createBalancedBst(nodeList, mid + 1, end);
		
		return root;
		
	}
	
	public Node convertToBalancedTree(Node node) {
		List<Node> listNode = new ArrayList<>();
		storeBstNodes(listNode, node);
		
		Node root = createBalancedBst(listNode, 0, listNode.size() - 1);
		return root;
	}
	
	public void preOrderTraversal(Node root) {
		if(root == null)
			return;
		
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public static void main(String[] args) {
		BalancedBst tree = new BalancedBst(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.left.left = new Node(7); 
        tree.root.left.left.left = new Node(6); 
        tree.root.left.left.left.left = new Node(5); 
  
        tree.root = tree.convertToBalancedTree(tree.root); 
        tree.preOrderTraversal(tree.root);
		
	}

}
