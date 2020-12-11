
public class FindThatSock {
  
   public static void main(String[] args) {
      Solution sol = new Solution();
      System.out.println(sol.findThatSock(new int[] { 1, 1, 2, 2, 3, 3, 4 }) == 4);
      System.out.println(sol.findThatSock(new int[] { 1 }) == 1);
      System.out.println(sol.findThatSock(new int[] { 0, 0, 1, 1, 2, 3, 3, 14, 14, 18, 18 }) == 2);
      System.out.println(sol.findThatSock(new int[] { 22, 22, 101, 200, 200, 7000, 7000 }) == 101);
      System.out.println(sol.findThatSock(new int[] { 0 }) == 0);

      // Test Case #1 (n is odd, sock is on left side)
      int[] arr = new int[] { 1, 1, 100, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13,
            14, 14, 15, 15 };
      System.out.println(sol.findThatSock(arr) == 100);

      // Test Case #2 (n is odd, sock is on right side)
      arr = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14,
            15, 15, 16, 16, 17, 17, 100, 18, 18, 19, 19 };
      System.out.println(sol.findThatSock(arr) == 100);

      // Test Case #3 (n is odd, sock is on the middle)
      arr = new int[] { 1, 1, 2, 2, 3, 3, 100, 4, 4, 5, 5, 6, 6 };
      System.out.println(sol.findThatSock(arr) == 100);

      // Test Case #4 (n is even, sock is on left side)
      arr = new int[] { 1, 1, 2, 2, 100, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10 };
      System.out.println(sol.findThatSock(arr) == 100);

      // Test Case #5 (n is even, sock is on right side)
      arr = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14,
            15, 15, 16, 16, 17, 17, 18, 18, 100, 19, 19, 20, 20 };
      System.out.println(sol.findThatSock(arr) == 100);

      // Test Case #6 (n is even, sock is on the middle)
      arr = new int[] { 1, 1, 2, 2, 3, 3, 100, 4, 4, 5, 5, 6, 6 };
      System.out.println(sol.findThatSock(arr) == 100);
   }
}

class Solution {
   /*
    * PURPOSE:
    *    Find non-repeating element from given socks array.
    * PARAMETER:
    *    int[] socks, socks array which always include non-repeating element.
    * RETURN:
    *    int result, return non-repeating element.
    */
   public int findThatSock(int[] socks) {
      int middle = socks.length / 2;
      // if socks array only has one value, always return the non-repeating element. 
      if (socks.length == 1)
         return socks[0];
      // Call the recursion method.
      int result = findThatSockRecursion(socks, 0, socks.length - 1);
      return result;
   }

   /*
    * PURPOSE:
    *    Recursion method that "binary searchish" for non-repeating element.
    * PARAMETER:
    *    int[] socks, socks array.
    *    int start, starting index.
    *    int end, ending index.
    * RETURN:
    *    return non-repeating element.
    */
   private int findThatSockRecursion(int[] socks, int start, int end) {
      int middle = (start + end) / 2;
      // if the middle element is the non-repating element.
      if (socks[middle] != socks[middle - 1] && socks[middle] != socks[middle + 1])
         return socks[middle];
      // if there's only three elements left.
      if (end - start == 2) {
         if (socks[middle] == socks[middle + 1])
            return socks[middle - 1];
         if (socks[middle] == socks[middle - 1])
            return socks[middle + 1];
      }

      // From 2n(repeating element) + 1(non-repeating element), n is middle.
      // Check middle is even or odd number.
      if (middle % 2 == 0) {
         if (socks[middle] == socks[middle + 1])
            return findThatSockRecursion(socks, middle, end);
         if (socks[middle] == socks[middle - 1])
            return findThatSockRecursion(socks, start, middle);
      } else {
         if (socks[middle] == socks[middle - 1])
            return findThatSockRecursion(socks, middle + 1, end);
         if (socks[middle] == socks[middle + 1])
            return findThatSockRecursion(socks, start, middle - 1);
      }
      // return -1 for an error.
      return -1;
   }
}

