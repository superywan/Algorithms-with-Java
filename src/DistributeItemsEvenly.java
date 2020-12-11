
public class DistributeItemsEvenly {

	public static void main(String[] args) {

		Solution sol = new Solution();

		// Case #1 true 
		int[] resources = {3, 4, 5, 6}; 
		System.out.println(sol.canDistribute(resources, 2));
		
		// Case #2 true
		resources = new int[] {1};
		System.out.println(sol.canDistribute(resources, 1));
		
		// Case #3 true 
		resources = new int[] {1, 3, 2, 3, 4, 1, 3, 5, 2, 1};
		System.out.println(sol.canDistribute(resources, 5));
		
		// Case #4 false
		resources = new int[] {1};
		System.out.println(sol.canDistribute(resources, 4));
		
		// Custom Case true
		resources = new int[] {1, 5, 5, 3, 7, 3, 1, 2, 9};
		System.out.println(sol.canDistribute(resources, 4));
		
		resources = new int[] {1, 3, 5, 6, 3, 5, 2, 3};
		System.out.println(sol.canDistribute(resources, 6));
		
		resources = new int[] {1,3,4,6,7,1,2,1};
		System.out.println(sol.canDistribute(resources, 5)); 
	}
}

class Solution {
  
  /**
   * PURPOSE: a solution method, canDistribute, that returns whether it is possible (true or false) that a given set of resources divides into groups equal-sum.
   * PARAMETERS:
   *     int[] resources, given set of resources
   *     int groups, number of groups
   * RETURN VALUES:
   *     boolean canDistributeRecursion, recursion method that return whethar it is possible to distribute equally.
   */
	public boolean canDistribute(int[] resources, int groups) {
    int total = 0;

	  if (groups == 0) 
      return true;

    if (resources.length < groups)
      return false;

    for (int i = 0; i < resources.length; i++) {
      total += resources[i];
    }

    if (total % groups != 0)
      return false;

    return canDistributeRecursion(resources, total, 0);
	}
  
  /**
   * PURPOSE: A recursion method that finds whether given resources are possible to divide equal-sum.
   * PARAMETERS:
   *     int[] resources, given set of resources
   *     int total, total sum of all resources
   *     int currentIndex, index for recursion
   * RETURN VALUES:
   *    boolean, if given set of resources can divided into all facilities equal-sum, return true. Otherwise, return false.
   */
  private boolean canDistributeRecursion(int[] resources, int total, int currentIndex) {
    if (total == 0)
      return true;

    if (resources.length == 0 || currentIndex >= resources.length)
      return false;

    if (resources[currentIndex] <= total) {
      if (canDistributeRecursion(resources, total - resources[currentIndex], currentIndex + 1))
          return true;
    }

    return canDistributeRecursion(resources, total, currentIndex + 1);
  }
}
