
public class EnglishPrefixHashMap {

	public static void main(String[] args) {
		//TEST CASE #1
		Solution sol = new Solution();
		sol.put("app", 100);
		System.out.println(sol.getSum("ap")); // returns 100 as "ap" is a prefix  to "app"
		sol.put("ap", 1);
		System.out.println(sol.getSum("a")); // returns 101 as "a" is a prefix to both keys in map
		System.out.println(sol.getSum("xyz")); // returns 0 as"xyz" is not a prefix to any keys in map 
		sol.put("app", 8); // replaces the value of the existing key "app" from 100 to 8
		System.out.println(sol.getSum("ap")); // returns 9 as "ap" is a prefix to both keys in map 

		// TEST CASE #2
		Solution sol2 = new Solution();
		sol2.put("A", 1);
		sol2.put("AB", 2);
		sol2.put("ABC", 3);
		sol2.put("ABCD", 4);
		sol2.put("ABCDE", 5);
		sol2.put("ABCDEF", 6);
		System.out.println(sol2.getSum("A"));
		System.out.println(sol2.getSum("AB"));
		System.out.println(sol2.getSum("ABC"));
		System.out.println(sol2.getSum("ABCD"));
		System.out.println(sol2.getSum("ABCDE"));
		System.out.println(sol2.getSum("ABCDEF"));
	}
}

class LList {
	String key;
	int val;
	LList next;

	public LList(String key, int val) {
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
	 * PURPOSE:
	 *		inserts a (key, value) pair into the map. If the input value already exists, update it. The input key is an English prefix (String) and the value is a non-negative integer.
	 * PARAMETERS:
	 *		String key, input key.
	 *		int value, non negative integer value.
	 */
	public void put(String key, int value) {
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
	 * PURPOSE: returns a summation of all corresponding values of the keys in map that start with such prefix. The input key is an English prefix.
	 * PARAMETERS:
	 *		String key, string English prefix.
	 * RETURN VALUES:
	 *		return summation of all corresponding values of the keys in map.
	 */
	public int getSum(String key) {
		boolean isMatch = false;
		int total = 0;
		int prefixLength = key.length();
		LList current = front;
		String mapKey;
		while (current != null) {
			mapKey = current.key;
			if (mapKey.length() >= prefixLength) {
				for (int i = 0; i < prefixLength; i++) {
					char prefixChar = key.charAt(i);
					char mapChar = mapKey.charAt(i);
					if (prefixChar == mapChar) {
						isMatch = true;
					} else {
						isMatch = false;
					}
				}
			}
			if (isMatch) {
				total += current.val;
				isMatch = false;
			}
			current = current.next;
		}
		return total;
	}
}
