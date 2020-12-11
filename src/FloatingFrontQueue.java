
public class FloatingFrontQueue {

	public static void main(String[] args) {
	    // Test Case 1
	    Solution sol = new Solution(1);
	    sol.add(523);
	    sol.remove();
	    System.out.print("Case 1 : getFront-> " + sol.getFront());
	    System.out.print(", getRear-> " + sol.getRear() + "\n");
	
	    // Test Case 2
	    sol = new Solution(3);
	    sol.add(-32323);
	    sol.add(-3);
	    sol.add(0);
	    sol.remove();
	    sol.remove();
	    sol.remove();
	    System.out.print("Case 2 : getFront-> " + sol.getFront());
	    System.out.print(", getRear-> " + sol.getRear() + "\n");
  }
}

class Solution {

  // Dynamic array size
  private int capacity;
  // Queue
  private int[] elements;
  // Dynamic queue size
  private int numElements = 0;
  // Dynamic index for the front of queue, defaulting to -1
  private int front = -1;
  // Dynamic index for the rear of queue, defaulting to -1
  private int rear = -1;

  // Constructor
  public Solution(int capacity) {
    this.capacity = capacity;
    this.elements = new int[this.capacity];
  }

  // Get the front index
  public int getFront() {
    return this.front;
  }

  // Get the rear index
  public int getRear() {
    return this.rear;
  }

  /**
  /* =====================================
  /* !!! DO NOT MODIFY ABOVE THIS LINE!!!
  /* ====================================
  */

  /**
   * PURPOSE: add, enqueue integer x on to queue.
   * PARAMETERS:
   *     int x, integer element.
   * RETURN VALUES:
   *     none
  */
  public void add(int x) {
    if (front == -1 && rear == -1) {
      front = 0;
      rear = 0;
      elements[rear] = x;
    } else {
      rear++;
      elements[rear] = x;
    }
  }

  /**
   * PURPOSE: remove, dequeue first element from the queue.
   * PARAMETERS:
   *     none
   * RETURN VALUES:
   *     popped, dequeued integer value.
  */
  public int remove() {
    int popped = elements[front];
    front++;
    if (front > rear) {
      front = -1;
      rear = -1;
    }
    return popped;
  }

  /**
   * PURPOSE: peek, get the front integer.
   * PARAMETERS:
   *     none
   * RETURN VALUES:
   *     boolean value of front element.
  */
  public int peek() {
    return elements[front];
  }

  /**
   * PURPOSE: isEmpty, boolean whether queue is empty or not.
   * PARAMETERS:
   *     none
   * RETURN VALUES:
   *     boolean value of whether elements is empty or not.
  */
  public boolean isEmpty() {
    if (front == -1 && rear == -1)
      return true;
    return false;
  }
}
