
import java.util.Stack;

public class QueueImplementWithTwoStack {    

	public static void main(String[] args) {
       // just like any problems, whatever you need here, etc.
       Solution queue1 = new Solution();
       queue1.add(1);
       queue1.add(2);
       queue1.add(3);
       System.out.println("Q empty? " + queue1.isEmpty());
       System.out.println("first ahead: " + queue1.peek());
       System.out.println(queue1.remove());
       System.out.println("first ahead: " + queue1.peek());
       System.out.println(queue1.remove());
       System.out.println("first ahead: " + queue1.peek());
       System.out.println(queue1.remove());
       System.out.println("Q empty? " + queue1.isEmpty());
    }
}
class Solution {

   /**
    * The Solution class implements a Stack class with the following geatures:
    * add(int x) enqueue integer x on to queue
    * remove() dequeue first element from the queue
    * peek() get the front integer
    * isEmpty() return boolean whether queue is empty.
    */

   // YOUR STACK TO USE FOR THIS PROBLEM
   private Stack<Integer> pushStack = new Stack<Integer>();
   private Stack<Integer> popStack = new Stack<Integer>();

  /**
  * =====================================
  * !!! DO NOT MODIFY ABOVE THIS LINE!!!
  * ====================================
  */ 

   public void add(int x) { 
     while (!pushStack.isEmpty()) {
       popStack.push(pushStack.pop());
     }
     pushStack.push(x);
     while (!popStack.isEmpty()) {
       pushStack.push(popStack.pop());
     }
   }

   public int remove() { 
     if (pushStack.isEmpty()) {
       System.out.println("Queue is Empty!");
       System.exit(0);
     }
     int poppedVal = pushStack.pop();
     return poppedVal;
   }

   public int peek() { 
     if (pushStack.isEmpty()) {
       System.out.println("Queue is Empty!");
       System.exit(0);
     }
     return pushStack.peek();
   }

   public boolean isEmpty() { 
     return pushStack.isEmpty();
   }
}
