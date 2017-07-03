package com.javamultiplex.projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem50 {

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

		List<Integer> commulativeSum = new ArrayList<>();
		int temp = 2, i = 3, k = 0;
		/**
		 * Generating commulative sum of prime numbers. if prime = 2, sum = 2 if
		 * prime = 3, sum = 3+2=5 if prime = 5, sum = 5+5=10 if prime = 7, sum =
		 * 7+10=17
		 */
		commulativeSum.add(temp);
		while (temp < limit) {
			if (primes[i]) {
				temp = commulativeSum.get(k) + i;
				commulativeSum.add(temp);
				k++;
			}
			i++;
		}
		int size = commulativeSum.size();
		int diff = 0, length = 0, max = 0;
		for (int m = size - 2; m >= 0; m--) {
			length = 0;
			temp = commulativeSum.get(m);
			if (primes[temp]) {
				length = m + 1;
			} else {
				for (int j = 0; j < size - 1; j++) {
					temp = commulativeSum.get(m) - commulativeSum.get(j);
					if (primes[temp]) {
						// finding length of consecutive primes.
						length = m - j;
						break;
					}
				}
			}

			if (length > max) {
				max = length;
				diff = temp;
			}
		}
		System.out.println("Prime number below one-million that can be written as the sum of the most consecutive primes is : "
						+ diff);
	}

}
