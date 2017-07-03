package com.javamultiplex.projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem49 {

	public static void main(String[] args) {

		int start = 1489, end = 9999, i1 = 0, i2 = 0, i3 = 0;
		int constant = 3330;
		BigInteger num1 = null, num2 = null, num3 = null;
		List<Integer> permutations = new ArrayList<>();
		String result = null;
		for (i1 = start; i1 <= end; i1 = i1 + 2) {
			// Converting int to String and storing in BigInteger.
			num1 = new BigInteger(String.valueOf(i1));
			// Checking prime numbers
			if (num1.isProbablePrime(1)) {
				i2 = i1 + constant;
				i3 = i2 + constant;
				// Converting int to String and storing in BigInteger.
				num2 = new BigInteger(String.valueOf(i2));
				num3 = new BigInteger(String.valueOf(i3));
				// Checking prime numbers
				if (num2.isProbablePrime(1) && num3.isProbablePrime(1)) {
					permutations = getPermuations(i1);
					if (permutations.contains(i2) && permutations.contains(i3)) {
						result = String.valueOf(i1) + String.valueOf(i2)
								+ String.valueOf(i3);
						break;
					}
				}
			}
		}
		System.out.println("12-digit number is : " + result);

	}

	private static List<Integer> getPermuations(int i1) {

		List<Integer> result = new ArrayList<>();
		int n = 24; // 4!=24
		int digits[] = getArrayFromInteger(i1);
		int length = 4; // 4 digit number
		int k = 0, i = 0, temp = 0;
		// Adding given number to result because it is also permutation.
		result.add(i1);
		for (int j = 2; j <= n; j++) {
			// Step 1 : Find largest index k such that digits[k]<digits[k+1]
			k = getK(digits, length);
			// Step 2 : Find largest index i such that digits[k]<digits[i]
			i = getI(digits, length, k);
			// Step 3 : Swap digits[i] and digits[k]
			digits = swapKandI(digits, k, i);
			// Step 4 : Reverse all the values in array from k+1 to end.
			digits = reverseFromKtoEnd(digits, k, length);
			temp = getIntegerFromArray(digits);
			result.add(temp);
		}
		return result;
	}

	private static int getIntegerFromArray(int[] digits) {

		int length = digits.length;
		String temp = "";
		int result = 0;
		for (int i = 0; i < length; i++) {
			// Converting int to String.
			temp += String.valueOf(digits[i]);
		}
		// Converting String to int.
		result = Integer.valueOf(temp);
		return result;
	}

	private static int[] getArrayFromInteger(int i1) {

		// Converting int to String.
		String str = String.valueOf(i1);
		int length = str.length();
		int digits[] = new int[length];
		for (int i = 0; i < length; i++) {
			// Converting char to int.
			digits[i] = str.charAt(i) - 48;
		}
		return digits;
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
