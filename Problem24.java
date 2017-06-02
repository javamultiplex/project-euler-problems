package com.javamultiplex.projecteuler;

import java.util.Arrays;


/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 24 - Lexicographic Permutations
 *
 */
public class Problem24 {

	/**
	 * Here we are using Narayana Pandit's algorithm for finding nth
	 * lexicographic permutation.
	 */
	public static void main(String[] args) {

		int n = 1000000; // 1 million
		int digits[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int length = 10;
		int k = 0, count = 0, i = 0;
		String result = null;
		while ((count + 1) != n) {
			// Step 1 : Find largest index k such that digits[k]<digits[k+1]
			k = getK(digits, length);
			// Step 2 : Find largest index i such that digits[k]<digits[i]
			i = getI(digits, length, k);
			// Step 3 : Swap digits[i] and digits[k]
			digits = swapKandI(digits, k, i);
			// Step 4 : Reverse all the values in array from k+1 to end.
			digits = reverseFromKtoEnd(digits, k, length);
			count++;
		}
		result = getStringByArray(digits, length);
		System.out.println("The millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9 is : "
						+ result);
	}

	private static String getStringByArray(int[] digits, int length) {

		String string = "";
		for (int i = 0; i < length; i++) {
			// Converting int to String and appending into string variable.
			string += String.valueOf(digits[i]);
		}

		return string;
	}

	private static int[] reverseFromKtoEnd(int[] digits, int k, int length) {

		/*
		 * For reversing array elements we are storing elements from k+1 to
		 * length-1 into temp array.
		 */
		int temp[] = Arrays.copyOfRange(digits, k + 1, length);
		int l = temp.length;
		for (int i = k + 1; i < length; i++) {
			digits[i] = temp[l - 1];
			l--;
		}
		return digits;
	}

	private static int[] swapKandI(int[] digits, int k, int i) {

		int temp = digits[k];
		digits[k] = digits[i];
		digits[i] = temp;
		return digits;
	}

	private static int getI(int[] digits, int length, int k) {

		int j = 0;
		for (int i = length - 1; i > k; i--) {
			if (digits[i] > digits[k]) {
				j = i;
				break;
			}
		}

		return j;
	}

	private static int getK(int[] digits, int length) {

		int k = 0;
		for (int i = length - 1; i > 0; i--) {
			if (digits[i] > digits[i - 1]) {
				k = i - 1;
				break;
			}
		}
		return k;
	}

}
