
import java.util.Stack;

public class PostfixExpressionEvaluator {

	public static void main(String[] args) {
		// just like any problems, whatever you need here, etc. For example:
		Solution sol = new Solution();
		System.out.println(sol.postfix("4 55 + 62 23 - * 12 1 - -"));
	    // etc. 
		System.out.println(sol.postfix("5 2 4 * + 7 -"));
		System.out.println(sol.postfix("5 7 + 6 2 -     *"));
		System.out.println(sol.postfix("-1 2 +"));
		System.out.println(sol.postfix("-1           2            +"));
		System.out.println(sol.postfix("1 2 3 * + 4 +"));
		System.out.println(sol.postfix("8 5 * 7 4 2 + * +"));
		System.out.println(sol.postfix("6 8 2 / 1 - *"));
		System.out.println(sol.postfix(" 2 4 *             0 * 1 +           "));
		System.out.println(sol.postfix("12 3 + 13 -"));
		Stack stack = new Stack();
		if (stack.empty() == true) {
			System.out.println("yay");
		}
	}
}

class Solution {
	
	 /**
	  * PURPOSE: A postfix notation, a notation for writing arithmetic expressions in which the operators appear after their operands. 
	  * PARAMETERS: 
	  * 		equation, String of posfixed expression.
	  * RETURN VALUES: 
	  * 		finalResult, posfixed result.
	  */
	   public int postfix(String equation) {  
		   int result, finalResult, val1, val2;
			Stack<Integer> trackingStack = new Stack<Integer>();

			for (int i = 0; i < equation.length(); i++) {
				char currentChar = equation.charAt(i);
				if (currentChar == ' ')
					continue;
				if (Character.isDigit(currentChar) || currentChar == '-') {
					int integer = 0;
					boolean isNegative = false;
					if (currentChar == '-') {
						try {
							if (equation.charAt(i + 1) == ' ') {
								val2 = trackingStack.pop();
								val1 = trackingStack.pop();
								result = calculate(val1, val2, '-');
								trackingStack.push(result);
								continue;
							}
							if (Character.isDigit(equation.charAt(i + 1))) {
								isNegative = true;
								i++;
								currentChar = equation.charAt(i);
							}
						} catch (StringIndexOutOfBoundsException e) {
							val2 = trackingStack.pop();
							val1 = trackingStack.pop();
							result = calculate(val1, val2, '-');
							trackingStack.push(result);
							continue;
						}
					}
					if (Character.isDigit(currentChar)) {
						while (Character.isDigit(currentChar)) {
							integer = integer * 10 + (int) (currentChar - '0');
							i++;
							currentChar = equation.charAt(i);
						}
						i--;
					}
					if (isNegative)
						integer = integer * -1;
					trackingStack.push(integer);
				} else {
					val2 = trackingStack.pop();
					val1 = trackingStack.pop();
					result = calculate(val1, val2, currentChar);
					trackingStack.push(result);
				}
			}
			finalResult = trackingStack.pop();
			return finalResult;
	   }
	   
	   /**
		 * PURPOSE: Do calculate with given integers and operator 
		 * PARAMETERS: 
		 * 		num1, first number
		 * 		num2, second number
		 * 		operator, char
		 * RETURN VALUES: 
		 * 		finalResult, Integer of posfixed result.
		 */
		public int calculate(int num1, int num2, char operator) {
			int result = 0;
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			return result;
		}
	}
