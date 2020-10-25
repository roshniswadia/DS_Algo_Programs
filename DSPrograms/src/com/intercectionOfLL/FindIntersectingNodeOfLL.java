package com.intercectionOfLL;

import com.intercectionOfLL.LinkedList.Node;

/*There are two singly linked lists in a system.
By some programming error,the end node of one of the linked list got 
linked to the second list,forming an inverted Y shaped list.
Write a program to get the point where two linked list merge.*/

public class FindIntersectingNodeOfLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList.Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		
		LinkedList.Node head2 = new Node(7);
		head2.next = new Node(8);
		head2.next = head1.next.next.next.next;
		
		LinkedList ll = new LinkedList();
		System.out.println(ll.findIntersection(head1, head2));

	}
	
	
	/*Get count of the nodes in the first list, let count be c1.
	Get count of the nodes in the second list, let count be c2.
	Get the difference of counts d = abs(c1 – c2)
	Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
	Then we can traverse both the lists in parallel till we come across a common node.*/

}
