
public class LinkedList {
	static Node head;

	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	void printlist(Node node) 
    { 
        if (node == null) { 
            return; 
        } 
        while (node != null) { 
            System.out.print(node.data + " -> "); 
            node = node.next; 
        } 
    } 
	
	public Node reverseList(Node node) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr !=null && curr.next != null) { // 1-> 2 -> 3 prev = 2 curr = 3 next = null
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node = curr;
		return node;
	}
	
	public void rearrange(Node node) {
		
		// 1) Find the middle point using tortoise and hare method 
		Node slow = node, fast = slow.next; 
        while (fast != null && fast.next != null) { // 1->2-3-4-5 slo - 3 fast = null
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        
     // 2) Split the linked list in two halves 
        // node1, head of first half    1 -> 2 -> 3 
        // node2, head of second half   4 -> 5 
        Node node1 = node; 
        Node node2 = slow.next; 
        slow.next = null; 
        
     // 3) Reverse the second half, i.e., 5 -> 4 
        node2 = reverseList(node2); 
        
        // 4) Merge alternate nodes 
        node = new Node(0); // Assign dummy Node 
  
        // curr is the pointer to this dummy Node, which will // 1-2-3     5-4
        // be used to form the new list 
        Node curr = node; 
        while(node1 !=null || node2 != null) {
        	if(node1 != null) {
        		curr.next = node1;
        		curr = node1;
        		node1 = node1.next;
        	}
        	
        	if(node2 != null) {
        		curr.next = node2;
        		curr = node2;
        		node2 = node2.next;
        	}
        	
        }
        
        node = node.next;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list = new LinkedList(); 
        list.head = new Node(1); 
        list.head.next = new Node(2); 
        list.head.next.next = new Node(3); 
        list.head.next.next.next = new Node(4); 
        list.head.next.next.next.next = new Node(5); 
  
        list.printlist(head); // print original list 
        list.rearrange(head); // rearrange list as per ques 
        System.out.println(""); 
        list.printlist(head); //
	}

}
