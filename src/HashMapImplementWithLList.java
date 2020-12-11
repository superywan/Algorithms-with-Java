
public class HashMapImplementWithLList {

	public static void main(String[] args) {
		// TEST CASE #1
		Solution sol = new Solution();
		sol.put(1, 1);
		sol.put(2, 3);
		System.out.println(sol.get(1)); // returns 1 
		System.out.println(sol.get(30)); // returns -1 (not found) 
		sol.put(1, 100); // update the existing value 
		System.out.println(sol.get(1)); // returns 100 
		sol.remove(2); // removes the mapping for 2
		sol.remove(1); // removes the mapping for 1 
		System.out.println(sol.get(2)); // returns -1 (not found)
		System.out.println(sol.get(1)); // returns -1 (not found) 

		// TEST CASE #2
		Solution sol2 = new Solution();
		sol2.put(1, 10);
		sol2.put(2, 20);
		sol2.put(3, 30);
		sol2.put(4, 40);
		System.out.println(sol2.get(1));
		System.out.println(sol2.get(2));
		System.out.println(sol2.get(3));
		System.out.println(sol2.get(4));
		sol2.put(1, 100);
		sol2.put(2, 200);
		System.out.println(sol2.get(1));
		System.out.println(sol2.get(2));
		sol2.remove(1);
		sol2.remove(4);
		System.out.println(sol2.get(1));
		System.out.println(sol2.get(2));
		System.out.println(sol2.get(3));
		System.out.println(sol2.get(4));
	}
}

class LList {
	int key = 0;
	int val = 0;
	LList next;

	public LList(int key, int val) {
		this.key = key;
		this.val = val;
	}
}

class Solution {

	LList front, rear;

	public Solution() {
		this.front = null;
		this.rear = null;
	}

	/**
	 * PURPOSE: inserts a (key, value) pair into the map. If the input value already exists, update it. Both key and value are integers.
	 * PARAMETERS:
	 *		int key, key value.
	 *		int value, integer value that associated with key.
	 */
	public void put(int key, int value) {
		LList current = front;
		while (current != null) {
			if (current.key == key) {
				current.val = value;
				return;
			}
			current = current.next;
		}
		LList newNode = new LList(key, value);
		if (rear == null)
			front = newNode;
		else
			rear.next = newNode;
		rear = newNode;
	}

	/**
	 * PURPOSE: returns the corresponding value mapped to the input key; returns -1 if not found.
	 * PARAMETERS:
	 *		int key, input key value.
	 * RETURN:
	 *		return value associated with key or -1 if key is not exist.
	 */
	public int get(int key) {
		LList current = front;
		while (current != null) {
			if (current.key == key) {
				return current.val;
			}
			current = current.next;
		}
		return -1;
	}

	/**
	 * PURPOSE: removes the corresponding value mapped to the input key.
	 * PARAMETERS:
	 *		int key, input key value.
	 */
	public void remove(int key) {
		LList current = front;
		if (current.key == key) {
			LList temp = current;
			front = current.next;
			temp = null;
			return;
		}
		while (current != null) {
			if (current.next.key == key) {
				if (current.next.next != null) {
					current.next = current.next.next;
				} else {
					current.next = null;
				}
				return;
			}
			current = current.next;
		}
	}
}
