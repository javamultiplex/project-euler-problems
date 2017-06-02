package com.javamultiplex.projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 23 - Non-abundant sums
 *
 */
public class Problem23 {

	public static void main(String[] args) {

		int limit = 28123;
		List<Integer> abundant = new ArrayList<>();
		boolean[] canWriteAsSumofAbundant = new boolean[limit];
		// Assigning false to each array element.
		Arrays.fill(canWriteAsSumofAbundant, false);
		int size = 0, temp = 0, sum = 0;
		// Getting all abundant numbers.
		for (int i = 1; i < limit; i++) {
			if (isAbundant(i)) {
				// If number is abundant add into list.
				abundant.add(i);
			}
		}
		size = abundant.size();

		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				temp = abundant.get(i) + abundant.get(j);
				if (temp < limit) {
					canWriteAsSumofAbundant[temp] = true;
				}
			}
		}

		for (int i = 1; i < limit; i++) {
			if (!canWriteAsSumofAbundant[i]) {
				sum += i;
			}
		}

		System.out.println("The sum of all the positive integers which cannot be written as the sum of two abundant numbers is : "
						+ sum);
	}

	private static boolean isAbundant(int num) {

		int sqrt = (int) Math.sqrt(num);
		int rem = 0, sum = 0, temp = 0;
		boolean result = false;
		for (int i = 1; i <= sqrt; i++) {
			rem = num % i;
			if (rem == 0) {
				sum += i;
				temp = num / i;
				if (i != temp && temp != num) {
					sum += temp;
				}
			}
		}
		if (sum > num) {
			result = true;
		}
		return result;
	}

}
