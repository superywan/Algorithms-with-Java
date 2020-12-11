
import java.util.*;

public class MaxHeapWithAL {

  public static void main(String[] args) {
    // Test Case 1
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    Solution sol = new Solution(list);
    sol.enqueue(6);
    sol.dequeue();
    sol.enqueue(5);
    System.out.println("Case1 : " + sol.print());

    // Test Case 2
    list = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    Solution sol2 = new Solution(list);
    sol2.enqueue(1);
    sol2.enqueue(123);
    sol2.enqueue(15);
    sol2.enqueue(1);
    System.out.println("Case2 : " + sol2.print());

    // Test Case 3
    list = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1));
    Solution sol3 = new Solution(list);
    sol3.enqueue(1);
    System.out.println("Case3 : " + sol3.print());

    // Test Case 4
    list = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1));
    Solution sol4 = new Solution(list);
    sol4.enqueue(1);
    sol4.enqueue(123);
    sol4.enqueue(15);
    sol4.enqueue(1);
    System.out.println("Case4 : " + sol4.print());

    // Test Case 5
    list = new ArrayList<>(Arrays.asList(16, 14, 10, 8, 7, 9, 3, 2, 4, 1));
    Solution sol5 = new Solution(list);
    sol5.enqueue(1);
    sol5.enqueue(1);
    sol5.dequeue();
    sol5.dequeue();
    sol5.dequeue();
    sol5.dequeue();
    sol5.dequeue();
    sol5.dequeue();
    sol5.dequeue();
    sol5.dequeue();
    sol5.enqueue(1);
    sol5.enqueue(1);
    sol5.enqueue(16);
    System.out.println("Case5 : " + sol5.print());

    // Test Case 6
    list = new ArrayList<>(Arrays.asList(16, 14, 10, 8, 7, 9, 3, 2, 4, 1));
    Solution sol6 = new Solution(list);
    sol6.enqueue(1);
    sol6.enqueue(1);
    sol6.dequeue();
    sol6.dequeue();
    sol6.dequeue();
    sol6.dequeue();
    sol6.dequeue();
    sol6.dequeue();
    sol6.dequeue();
    sol6.dequeue();
    sol6.enqueue(1);
    sol6.enqueue(16);
    sol6.enqueue(16);
    sol6.dequeue();
    System.out.println("Case6 : " + sol6.print());
  }
}

class Solution {
  private ArrayList<Integer> list;

  // -------------------------------------------- 
  // !!!!PLEASE DO NOT MODIFY THIS CONSTRUCTOR!!!
  // -------------------------------------------- 
  public Solution(ArrayList<Integer> list) {
    this.list = list;
  }
  // -------------------------------------------- 
  // !!!!PLEASE DO NOT MODIFY THIS PRINT METHOD
  // -------------------------------------------- 

  public String print() {
    return Arrays.toString(list.toArray());
  }

  /*
   * PURPOSE:
   *    enqueues an integer element into heap.
   * PARAMETER:
   *    int element, element that enqueuing.
   */
  public void enqueue(int element) {
    list.add(list.size(), element);
    reheapUp(list.size() - 1);
  }

  /*
   * PURPOSE:
   *    dequeues the highest priority element from heap.
   * PARAMETER:
   *    None.
   */
  public void dequeue() {
    int removing = list.get(0);
    int moving = list.remove(list.size() - 1);
    if (list.size() - 1 != -1)
      reheapDown(moving);
  }

  /*
   * PURPOSE:
   *    this method is called by enqueue method. iteratively shifts the element up the tree to "reheap" it.
   * PARAMETER:
   *    int x, last Index number.
   */
  private void reheapUp(int x) {
    int current = x;
    while (list.get(current) > list.get((current - 1) / 2)) {
      Collections.swap(list, current, (current - 1) / 2);
      current = (current - 1) / 2;
    }
  }

  /*
   * PURPOSE:
   *    this method is called by dequeue. iteratively shifts the element down the tree to "reheap" it.
   * PARAMETERS:
   *    int x, last index element that might bubble up. 
   */
  private void reheapDown(int x) {
    int hole = 0;
    int next = newHole(hole, x);
    while (next != hole) {
      list.set(hole, list.get(next));
      hole = next;
      next = newHole(hole, x);
    }
    list.set(hole, x);
  }

  /*
   * PURPOSE:
   *   Compare moving element with left and right child node.     
   * PARAMETERS:
   *    int hole,
   *    int node,
   * RETURN:
   *    return new hole, depending on element is bigger than left or right.     
   */
  private int newHole(int hole, int element) {
    int lastIndex = list.size() - 1;
    int left = (hole * 2) + 1;
    int right = (hole * 2) + 2;
    if (left > lastIndex)
      return hole;
    else if (left == lastIndex) {
      if (element < list.get(left))
        return left;
      else
        return element;
    } else {
      if (list.get(left) < list.get(right)) {
        if (list.get(right) <= element)
          return hole;
        else
          return right;
      } else {
        if (list.get(left) <= element)
          return hole;
        else
          return left;
      }
    }
  }
}
