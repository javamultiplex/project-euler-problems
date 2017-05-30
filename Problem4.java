package com.javamultiplex.projecteuler;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 4- Largest palindrome product
 *
 */
public class Problem4 {

	public static void main(String[] args) {

		int maxThreeDigit = 999;
		int minThreeDigit = 100;
		int multInteger = 0;
		// lowest multiple of 2 three digit numbers
		int max = 100 * 100;
		for (int i = maxThreeDigit; i >= minThreeDigit; i--) {
			for (int j = i; j >= minThreeDigit; j--) {
				multInteger = i * j;

				// Checking multiplication is palindrome or not
				if (isPalindrome(multInteger)) {
					if (multInteger > max) {
						max = multInteger;
						break;
					}
				}
			}
		}
		System.out.println("Largest palindrom made from the product of two " + "3-digit numbers is: " + max);
	}

	private static boolean isPalindrome(int multInteger) {

		boolean result = false;
		String multString = null;
		StringBuffer multStringBuffer = null;
		// Converting Integer to String
		multString = String.valueOf(multInteger);
		/*
		 * Converting String to StringBuffer, We want to reverse the string
		 * thats why we have to use StringBuffer.
		 */
		multStringBuffer = new StringBuffer(multString);
		if (multString.equals(multStringBuffer.reverse().toString())) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}
