
public class ConvertHomogeneous {

	public static void main(String[] args) {
		// just like any problems, whatever you need here, etc. For example:
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(6);
		node.next.next.next.next.next.next = new Node(7);
		Solution sol = new Solution();
		sol.printList(node);
		sol.mixList(node); // list be homogeneous after this call
		sol.printList(node);
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

	/**
	 * PURPOSE: A Solution method for the simulation program to transform any
	 * non-homogeneous list into a homogeneous list given the above mixing pattern.
	 * PARAMETERS: head, given head of linked list formed with positive sequential
	 * integer value.
	 */
	public void mixList(Node head) {
		Node reversed;
		Node current = head;
		Node original = head;
		Node nextNode = current.next;

		// Find the middle of Linked List.
		while (nextNode != null && nextNode.next != null) {
			current = current.next;
			nextNode = nextNode.next.next;
		}

		// Reverse Linked list "..., n-2, n-1, n" to "n, n-1, n-2, ..".
		reversed = reverseList(current.next);

		// Reset head and current
		head = new Node(0);
		current.next = null;
		current = head;

		// Link the Node until reversed is null
		while (original != null || reversed != null) {
			if (original != null) {
				current.next = original;
				current = current.next;
				original = original.next;
			}
			if (reversed != null) {
				current.next = reversed;
				current = current.next;
				reversed = reversed.next;
			}
		}
		head = head.next;
	}

	/**
	 * PURPOSE: Reverse given linked list. PARAMETERS: head, given head of linked
	 * list. RETURN VALUES: reversed, head of the reversed linked list.
	 */
	public Node reverseList(Node head) {
		Node reversed = head;
		Node prev = null;
		Node next = null;
		while (reversed != null) {
			next = reversed.next;
			reversed.next = prev;
			prev = reversed;
			reversed = next;
		}
		reversed = prev;
		return reversed;
	}

	/**
	 * PURPOSE: Print out given linked list. PARAMETERS: head, given head of linked
	 * list.
	 */
	public void printList(Node head) {
		Node node = head;
		while (node.next != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(node.val + "->null");
	}
}
