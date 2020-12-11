
import java.util.Stack;

public class BacktrackingWithStack {    
   
	public static void main(String[] args) {
      Solution sol = new Solution();
 
      int[] pushed1 = {1, 2, 3, 4}; 
      int[] popped1 = {3, 4, 2, 1};
      System.out.println(sol.isSameEventSequence(pushed1, popped1)); // true 
      
      int[] pushed2 = {2,1,3}; 
      int[] popped2 = {3,2,1};
      System.out.println(sol.isSameEventSequence(pushed2, popped2)); // false
      
      int[] pushed3 = {1,2,3}; 
      int[] popped3 = {1,2,3};
      System.out.println(sol.isSameEventSequence(pushed3, popped3)); // true
      
      int[] pushed4 = {1, 2, 3, 5, 4}; 
      int[] popped4 = {1, 3, 2, 5, 4};
      System.out.println(sol.isSameEventSequence(pushed4, popped4)); // true
      
      int[] pushed5 = {1, 2, 3, 4, 5}; 
      int[] popped5 = {3, 4, 5, 1, 2}; 
      System.out.println(sol.isSameEventSequence(pushed5, popped5)); // false
    }
}

/**
 * PURPOSE: Check if two input integer arrays, events_pushed and events_popped, represent the result of an actual sequence of events happened on an initially empty stack.
 * PARAMETERS:
 *     events_pushed, integer array that tracks pushed values respectively and sequentially.
 *     events_popped, integer array that tracks popped values respectively and sequentially.
 * RETURN VALUES: 
 *     flag, return true and false otherwise.
*/
class Solution {
	public boolean isSameEventSequence(int[] events_pushed, int[] events_popped) {
		boolean flag = false;
		Stack<Integer> trackingStack = new Stack<Integer>();
		int poppedLength = events_popped.length;
		int poppedIndex = 0;
		// Return false flag when both arrays aren't same size.
		if (events_pushed.length != events_pushed.length)
			return flag;
		// Simulate through the process of pushes and pops in order.
		for (int i = 0; i < poppedLength; i++) {
			trackingStack.push(events_pushed[i]);
			// To avoid empty stack error make sure trackingStack is not empty.
			// Lastly, check current top item matches to "poppedIndex" item.   
			while (!trackingStack.empty() && trackingStack.peek() == events_popped[poppedIndex]) { 
				trackingStack.pop(); 
				poppedIndex++;
			}
		}
		// every pops worked successfully, now flag is true.
		if (poppedLength == poppedIndex)
			flag = true;
		return flag;
   }
}

