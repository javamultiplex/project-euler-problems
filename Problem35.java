package com.javamultiplex.projecteuler;

import java.util.Arrays;

public class Problem35 {

	private static int limit = 1000000; //1 million
	private static boolean primes[] = new boolean[limit];
	
	/**
	 * Getting all prime numbers from 1 to 1 million using Sieve of Eratosthenes algorithm.
	 * Here we are calculating all prime numbers at the starting only.
	 * 
	 */
	static {
		//Instantiating all array elements to 'true'.
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

		String temp = null;
		String circularNumbers[] = null;
		int length = 0, count = 0;
		for (int i = 1; i < limit; i++) {
			// Convert int to String.
			temp = String.valueOf(i);
			length = temp.length();
			circularNumbers = getAllCircularNumber(temp, length);
			if (isPrime(circularNumbers, length)) {
				count++;
			}
		}
		System.out.println("Number of circular primes below one million : "
				+ count);

	}

	private static boolean isPrime(String[] circularNumbers, int length) {

		int temp = 0, count = 0;
		boolean result = false;
		for (int i = 0; i < length; i++) {
			//Convert String to int.
			temp = Integer.valueOf(circularNumbers[i]);
			if (primes[temp]) {
				count++;
			}
		}
		if (count == length) {
			result = true;
		}
		return result;
	}

	private static String[] getAllCircularNumber(String temp, int length) {

		String[] circulars = new String[length];
		circulars[0] = temp;

		for (int i = 1; i < length; i++) {
			//rotating digits of given number.
			circulars[i] = temp.substring(i, length) + temp.substring(0, i);
		}
		return circulars;
	}

}
