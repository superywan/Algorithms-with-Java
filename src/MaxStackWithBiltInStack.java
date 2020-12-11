
import java.util.Stack;

public class MaxStackWithBiltInStack {
	
	public static void main(String[] args) {
		MaxStack maxStack = new MaxStack();

		maxStack.push(-4);

		maxStack.push(1);

		maxStack.push(-3);
		
		maxStack.push(-2);

		maxStack.push(-1);

		System.out.println(maxStack.getMax());

		maxStack.pop();
		
		System.out.println(maxStack.maxTracker);

		System.out.println(maxStack.top());
		
		maxStack.pop();
		
		System.out.println(maxStack.maxTracker);

		System.out.println(maxStack.getMax());
	}
}

/**
* The MaxStack program implements a Stack class with the following features:
* push(x) -- push element x onto stack
* pop() -- remove the element on top of the stack
* top() -- get the top element.
* getMax() -- retrieve the max element in the stack in constant time (i.e., O(1)
*/

class MaxStack {
	public Stack<Integer> currentStack;
	public Stack<Integer> maxTracker = new Stack<Integer>();

	public MaxStack() {
		currentStack = new Stack<Integer>();
	}

	public void push(int x) {
		currentStack.push(x);
		if (currentStack.size() == 1) {
			maxTracker.push(x);
		} else {
			if (x > maxTracker.peek())
				maxTracker.push(x);
			else
				maxTracker.push(maxTracker.peek());
		}
	}
  
	public void pop() {
		currentStack.pop();
		maxTracker.pop();
	}

	public int top() {
		return currentStack.peek();
	}

	public int getMax() {
		currentStack.forEach(item -> {
			if (item > maxTracker.peek())
				maxTracker.push(item);
		});
		return maxTracker.peek();
	}
}
