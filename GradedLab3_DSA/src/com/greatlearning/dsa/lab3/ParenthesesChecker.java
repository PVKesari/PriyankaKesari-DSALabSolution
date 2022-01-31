package com.greatlearning.dsa.lab3;

// Java program for checking
// balanced brackets
import java.util.*;

public class ParenthesesChecker {

	// function to check if brackets are balanced
	static boolean checkBalancedBrackets(String input) {
		// If the expression is not even then return false
		// as it do not contain balanced parenthesis
		if (input.length() % 2 != 0) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();

		// Traversing the Expression
		for (int i = 0; i < input.length(); i++) {
			char x = input.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				// Push the element in the stack
				stack.push(x);
				continue;
			}

			// If current character is not opening
			// bracket, then it must be closing. So stack
			// cannot be empty at this point.
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// Check Empty Stack
		return (stack.isEmpty());
	}

	// Driver code
	public static void main(String[] args) {
		System.out.println("Enter the parenthesis expression to check");
		Scanner sc = new Scanner(System.in);
		String expr = sc.next();
		// Function call
		if (checkBalancedBrackets(expr))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered String do not contain Balanced Brackets");
	}
}
