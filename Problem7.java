package com.javamultiplex.projecteuler;

import java.util.Arrays;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 7 - 10001st Prime?
 */
public class Problem7 {

	/**
	 * 
	 * Here for finding prime numbers we are using algorithm Sieve of
	 * Eratosthenes.
	 * 
	 */
	public static void main(String[] args) {

		/**
		 * 
		 * Minimum boolean array Size should be 104744 because we have to find
		 * 10001st prime number.
		 * 
		 */
		int size = 104744, count = 0, limit = 10001;
		boolean primes[] = new boolean[size];
		// Assigning true to all array elements.
		Arrays.fill(primes, true);
		// Using algorithm Sieve of Eratosthenes.
		generatePrimeNumbers(primes);
		for (int i = 2; i < size; i++) {
			if (primes[i]) {
				count++;
				if (count == limit) {
					System.out.println("The 10001st prime number is : " + i);
				}
			}
		}

	}

	private static void generatePrimeNumbers(boolean[] primes) {

		int size = primes.length;
		int sqrt = (int) Math.sqrt(size);
		for (int i = 2; i < sqrt; i++) {
			if (primes[i]) {
				for (int j = i * i; j < size; j = j + i) {
					primes[j] = false;
				}
			}
		}
	}
}
