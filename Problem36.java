package com.javamultiplex.projecteuler;

public class Problem36 {

	public static void main(String[] args) {

		int limit = 1000000; // 1 million
		String binary = null, decimal = null;
		int sum = 0;
		for (int i = 1; i < limit; i++) {
			// Converting int to String.
			decimal = String.valueOf(i);
			// Converting decimal number to binary number.
			binary = Integer.toBinaryString(i);
			if (isPalindrome(decimal) && isPalindrome(binary)) {
				sum += i;
			}
		}
		System.out.println("The sum of all numbers, less than one million, which are palindromic in base 10 and base 2 is : "
						+ sum);
	}

	private static boolean isPalindrome(String string) {

		// Converting String to StringBuilder.
		StringBuilder str = new StringBuilder(string);
		String reversedString = str.reverse().toString();
		boolean result = false;

		if (string.equals(reversedString)) {
			result = true;
		}
		return result;
	}

}
