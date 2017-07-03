package com.javamultiplex.projecteuler;

import java.util.Arrays;

public class Problem37 {

	private static int limit = 1000000; // 1 million
	private static boolean primes[] = new boolean[limit];

	/**
	 * Getting all prime numbers from 1 to 1 million using Sieve of Eratosthenes
	 * algorithm. Here we are calculating all prime numbers at the starting
	 * only.
	 * 
	 */
	static {
		// Instantiating all array elements to 'true'.
		Arrays.fill(primes, true);
		int sqrt = (int) Math.sqrt(limit);
		// 1 is not prime number.
		primes[1] = false;
		for (int i = 2; i <= sqrt; i++) {
			for (int j = 2 * i; j < limit; j = j + i) {
				primes[j] = false;
			}
		}
	}

	public static void main(String[] args) {

		int start = 11, count = 0, sum = 0;
		while (true) {
			if (primes[start]) {
				if (isLeftToRightDigitsPrime(start)
						&& isRightToLeftDigitsPrime(start)) {
					count++;
					sum += start;
					if (count == 11) {
						break;
					}
				}
			}
			start++;
		}
		System.out.println("The sum of eleven primes that are both truncatable from left to right and right to left is : "+sum);
	}

	private static boolean isRightToLeftDigitsPrime(int start) {

		// Convert int to String.
		String number = String.valueOf(start);
		String temp1 = null;
		int temp2 = 0, count = 0;
		boolean result = false;
		int length = number.length();
		for (int i = length - 1; i > 0; i--) {
			temp1 = number.substring(0, i);
			// Convert String to int.
			temp2 = Integer.valueOf(temp1);
			if (primes[temp2]) {
				count++;
			}
		}
		if (count == length - 1) {
			result = true;
		}
		return result;
	}

	private static boolean isLeftToRightDigitsPrime(int start) {

		// Convert int to String.
		String number = String.valueOf(start);
		String temp1 = null;
		int temp2 = 0, count = 0;
		boolean result = false;
		int length = number.length();
		for (int i = 1; i < length; i++) {
			temp1 = number.substring(i);
			// Convert String to int.
			temp2 = Integer.valueOf(temp1);
			if (primes[temp2]) {
				count++;
			}
		}
		if (count == length - 1) {
			result = true;
		}
		return result;
	}

}
