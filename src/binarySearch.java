
public class binarySearch {

	public static void main(String[] args) {
		BinarySearch sol = new BinarySearch();

		int[] arr = { 1, 2, 3, 5, 6, 7, 8 };
		int target1 = 3;
		int target2 = 9;

		System.out.println("Binary Search with Recursive");
		System.out.println(sol.binarySearchRecursive(target1, arr, 0, arr.length - 1));
		System.out.println(sol.binarySearchRecursive(target2, arr, 0, arr.length - 1));

		System.out.println("Binary Search with Iterative");
		System.out.println(sol.binarySearchIterative(target1, arr));
		System.out.println(sol.binarySearchIterative(target2, arr));
	}
}

class BinarySearch {
	public static int binarySearchRecursive(int target, int[] array, int start, int end) {
		int middle = (start + end) / 2;
		
		if (end < start)
			return -1;
		if (target < array[middle])
			return binarySearchRecursive(target, array, start, middle - 1);
		if (target > array[middle])
			return binarySearchRecursive(target, array, middle + 1, end);
		if (target == array[middle])
			return middle;
		return -1;
	}

	public static int binarySearchIterative(int target, int[] array) {
		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int middle = (start + end) / 2;
			if (target < array[middle])
				end = middle - 1;
			if (target > array[middle])
				start = middle + 1;
			if (target == array[middle])
				return middle;
		}
		return -1;
	}
}
