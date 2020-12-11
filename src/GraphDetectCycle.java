
import java.util.*;

public class GraphDetectCycle {

	public static void main(String[] args) {
		Solution sol = new Solution();

		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		// let's create a cycle with c -> b
		a.next = b;
		a.next.next = c;
		c.next = b;
		System.out.println(sol.hasCycle(a)); // true

		// Test Case 1: Node that pointing to itself 
		a.next = a;
		System.out.println(sol.hasCycle(a)); // true

		// Test Case 2: Graph with only one node.
		a = new Node("a");
		System.out.println(sol.hasCycle(a)); // false

		// Test Case #1 false
		a = new Node("a");
		System.out.println(sol.hasCycle(a));

		// Test Case #2 false
		a = new Node("a");
		b = new Node("b");
		a.next = b;
		System.out.println(sol.hasCycle(a));

		// Test Case #3 false
		a = new Node("a");
		b = new Node("b");
		c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		Node i = new Node("i");
		Node j = new Node("j");
		a.next = b;
		a.next.next = c;
		a.next.next.next = d;
		a.next.next.next.next = e;
		a.next.next.next.next.next = f;
		a.next.next.next.next.next.next = g;
		a.next.next.next.next.next.next.next = h;
		a.next.next.next.next.next.next.next.next = i;
		a.next.next.next.next.next.next.next.next.next = j;
		System.out.println(sol.hasCycle(a));
	}
}

class Node {
	String label;
	Node next;

	public Node(String label) {
		this.label = label;
	}

	public String toString() {
		return label;
	}
}

class Solution {
	/*
	 * PURPOSE:
	 *		Check if a directed graph represented by a Linked List has one to may cycles in it.
	 * PARAMETERS:
	 *		Node head, head of the directed graph.
	 * RETURN:
	 *		return true if the given graph has a looping structure. Otherwise, return false.
	 */
	public boolean hasCycle(Node head) {
		ArrayList<String> visited = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		if (head == null) 
			return false;
		q.add(head);

		while (!q.isEmpty()) {
			Node tmp = q.remove();
			if (visited.contains(tmp.label)) {
				return true;
			} else {
				visited.add(tmp.label);
			}
			if (tmp.next != null) {
				q.add(tmp.next);
			}
		}
		return false;
	}
}
