
import java.util.*;

public class ListLookAHead {
	
	public static void main(String[] args) {
		// TEST CASE #1
		System.out.println("CASE 1");
		List<Integer> ints1 = new ArrayList<>(Arrays.asList(1, 2, 3));
		MyIterator iter1 = new MyIterator(ints1.iterator());
		System.out.println(iter1.next()); // 1
		System.out.println(iter1.lookAhead()); // 2
		System.out.println(iter1.next()); // 2
		System.out.println(iter1.next()); // 3
		System.out.println(iter1.hasNext()); // false

		// TEST CASE #2
		System.out.println("\nCASE 2");
		List<Integer> ints2 = new ArrayList<>(Arrays.asList(100));
		MyIterator iter2 = new MyIterator(ints2.iterator());
		System.out.println(iter2.next()); // 100
		System.out.println(iter2.lookAhead()); // null
		System.out.println(iter2.next()); // null
		System.out.println(iter2.hasNext()); // false

		// TEST CASE #3
		System.out.println("\nCASE 3");
		List<Integer> ints3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		MyIterator iter3 = new MyIterator(ints3.iterator());
		System.out.println(iter3.next()); // 1
		System.out.println(iter3.next()); // 2   
		System.out.println(iter3.next()); // 3
		System.out.println(iter3.hasNext()); // true
		System.out.println(iter3.lookAhead()); // 4
		System.out.println(iter3.next()); // 4      
		System.out.println(iter3.next()); // 5     
		System.out.println(iter3.next()); // 6 
		System.out.println(iter3.hasNext()); // false
		System.out.println(iter3.next()); // 0 (null)

		// TEST CASE #4
		System.out.println("\nCASE 4");
		List<Integer> ints4 = new ArrayList<>(Arrays.asList(2, 4, 6));
		MyIterator iter4 = new MyIterator(ints4.iterator());
		System.out.println(iter4.next()); // 2
		System.out.println(iter4.next()); // 4
		System.out.println(iter4.lookAhead()); // 6 
		System.out.println(iter4.hasNext()); // true 
		System.out.println(iter4.next()); // 6
		System.out.println(iter4.hasNext()); //false
		System.out.println(iter4.next()); // 0 (null)
	}
}

class MyIterator implements Iterator<Integer> {

	Iterator<Integer> it;
	List<Integer> ints = new ArrayList<>();
	int index = 0;

	// Constructor - Parse Iterator to ArrayList
	public MyIterator(Iterator<Integer> iterator) {
		this.it = iterator;
		while (it.hasNext()) {
			int element = it.next();
			ints.add(element);
		}
	}

  /**
   * PURPOSE: Returns the next element in the iteration WITHOUT advancing the iterator.
   * PARAMETERS:
   *     none
   * RETURN VALUES:
   *     result, integer the next element in the iteration.
   */
	public Integer lookAhead() {
		int result = 0;
		if (hasNext())
			result = ints.get(index);
		return result;
	}
	
  /**
   * PURPOSE: Advance the iterator and return integer value
   * PARAMETERS:
   *     none
   * RETURN VALUES:
   *     result, integer the next element in the iteration.
   */
	@Override
	public Integer next() {
		int result = 0;
		if (hasNext())
			result = ints.get(index);
		index++;
		return result;
	}

  /**
   * PURPOSE: Check the iterator has a next value
   * PARAMETERS:
   *     none
   * RETURN VALUES:
   *     result, boolean if there is next element in the iterator, true. Otherwise, false. 
   */
	@Override
	public boolean hasNext() {
		int size = ints.size();
		boolean result = (index < size);
		return result;
	}
}
