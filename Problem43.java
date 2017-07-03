package com.javamultiplex.projecteuler;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem43 {

	/**
	 * Here we are using Narayana Pandit's algorithm for finding nth
	 * lexicographic permutation.
	 */
	public static void main(String[] args) {

		int digits[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int length = 10;
		int permutations = 3628800; // 10!=3628800
		int k = 0, i = 0;
		String result = null;
		BigInteger temp = null;
		// sum=0
		BigInteger sum = BigInteger.ZERO;
		for (int j = 1; j <= permutations; j++) {
			// Step 1 : Find largest index k such that digits[k]<digits[k+1]
			k = getK(digits, length);
			// Step 2 : Find largest index i such that digits[k]<digits[i]
			i = getI(digits, length, k);
			// Step 3 : Swap digits[j] and digits[k]
			digits = swapKandI(digits, k, i);
			// Step 4 : Reverse all the values in array from k+1 to end.
			digits = reverseFromKtoEnd(digits, k, length);
			result = getStringByArray(digits, length);
			if (isSubStringDivisible(result, length)) {
				// Converting String to BigInteger.
				temp = new BigInteger(result);
				sum = sum.add(temp);
			}
		}
		System.out.println("The sum of all 0 to 9 pandigital numbers : "+sum);
	}

	private static boolean isSubStringDivisible(String string, int length) {

		String substring = null;
		int primes[] = { 2, 3, 5, 7, 11, 13, 17 };
		int temp = 0, count = 0;
		boolean result = false;
		for (int i = 1; i <= length - 3; i++) {
			substring = string.substring(i, i + 3);
			// Converting String to int.
			temp = Integer.valueOf(substring);
			if (temp % primes[i - 1] == 0) {
				count++;
			}
		}

		if (count == 7) {
			result = true;
		}
		return result;
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
