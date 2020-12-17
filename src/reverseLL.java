
public class LabAssignment3 {
	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		
		Solution sol = new Solution();
		sol.reverseList(node);
	}
}

class Node {
	int val;
	Node next;

	Node(int x) {
		val = x;
	}
}

class Solution {
	
	public void reverseList(Node head) {
		Node currentNode = head;
		Node prev = null;
		Node next = null;
		while(currentNode != null) {
			next = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = next;
		}
		currentNode = prev;
		while (currentNode != null) {
			System.out.print(currentNode.val + "->");
			currentNode = currentNode.next;
		}
		System.out.print("null\n");
	}
}
