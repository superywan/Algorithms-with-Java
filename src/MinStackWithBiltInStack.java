
import java.util.Stack;

public class MinStackWithBiltInStack {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();

		minStack.push(16);

		minStack.push(15);

		minStack.push(14);
		
		minStack.push(13);

		minStack.push(12);

		System.out.println(minStack.getMin());

		minStack.pop();
		
		System.out.println(minStack.minTracker);
		
		System.out.println(minStack.top());
		
		minStack.pop();
		
		System.out.println(minStack.minTracker);

		System.out.println(minStack.getMin());
	}
}

/**
* The MinStack program implements a Stack class with the following features:
* push(x) -- push element x onto stack
* pop() -- remove the element on top of the stack
* top() -- get the top element.
* getMin() -- retrieve the minimum element in the stack in constant time (i.e., O(1)
*/

class MinStack {
	public Stack<Integer> currentStack;
	public Stack<Integer> minTracker = new Stack<Integer>();

	public MinStack() {
		currentStack = new Stack<Integer>();
	}

	public void push(int x) {
		currentStack.push(x);
		if (currentStack.size() == 1) {
			minTracker.push(x);
		} else {
			if (x < minTracker.peek())
				minTracker.push(x);
			else
				minTracker.push(minTracker.peek());
		}
	}

	public void pop() {
		currentStack.pop();
		minTracker.pop();
	}

	public int top() {
		return currentStack.peek();
	}

	public int getMin() {
		currentStack.forEach(item -> {
			if (item < minTracker.peek())
				minTracker.push(item);
		});
		return minTracker.peek();
	}
}