package com;

public class BinarySearchTree {

	static Node root;

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	public void insert(int key) {
		root = insertRec(root, key);
	}

	public Node insertRec(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (root.key > key) {
			root.left = insertRec(root.left, key);
		} else {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	public Node search(Node root, int key) {
		// Base Cases: root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// val is greater than root's key
		if (root.key > key)
			return search(root.left, key);

		// val is less than root's key
		return search(root.right, key);
	}

	void deleteKey(int key) {
		root = deleteNode(root, key);
	}

	public Node deleteNode(Node root, int key) {

		// base case: key not found in tree
		if (root == null) {
			return root;
		}

		// if given key is less than the root node, recur for left subtree
		if (key < root.key) {
			root.left = deleteNode(root.left, key);
		}

		// if given key is more than the root node, recur for right subtree
		else if (key > root.key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.right == null && root.left == null) {
				return null;
			} else if (root.left != null && root.right != null) {
				// find its in-order predecessor node
				Node predecessor = maximumKey(root.left);

				// Copy the value of predecessor to current node
				root.key = predecessor.key;

				// recursively delete the predecessor. Note that the
				// predecessor will have at-most one child (left child)
				root.left = deleteNode(root.left, predecessor.key);
			} else {
				// find child node
				Node child = (root.left != null) ? root.left : root.right;
				root = child;
			}
		}

	}

	void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.key + " ");
	}

	/* Given a binary tree, print its nodes in inorder */
	void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.key + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	/* Given a binary tree, print its nodes in preorder */
	void printPreorder(Node node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.key + " ");

		/* then recur on left sutree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	public static Node maximumKey(Node ptr) {
		while (ptr.right != null) {
			ptr = ptr.right;
		}

		return ptr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void printPaths(Node node)  
    { 
        int path[] = new int[1000]; 
        printPathsRecur(node, path, 0); 
    } 
   
    /* Recursive helper function -- given a node, and an array 
       containing the path from the root node up to but not  
       including this node, print out all the root-leaf paths.*/
    void printPathsRecur(Node node, int path[], int pathLen)  
    { 
        if (node == null) 
            return; 
   
        /* append this node to the path array */
        path[pathLen] = node.key; 
        pathLen++; 
   
        /* it's a leaf, so print the path that led to here  */
        if (node.left == null && node.right == null) 
            printArray(path, pathLen); 
        else 
        { 
            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen); 
            printPathsRecur(node.right, path, pathLen); 
        } 
    } 
   
    /* Utility function that prints out an array on a line. */
    void printArray(int ints[], int len)  
    { 
        int i; 
        for (i = 0; i < len; i++)  
        { 
            System.out.print(ints[i] + " "); 
        } 
        System.out.println(""); 
    } 

}
