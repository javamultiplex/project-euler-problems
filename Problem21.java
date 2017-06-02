package com.javamultiplex.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 21 - Amicable numbers
 *
 */
public class Problem21 {

	public static void main(String[] args) {

		int target = 10000;
		List<Integer> list = new ArrayList<>();
		int b = 0, c = 0, sum = 0;
		for (int a = 2; a <= target; a++) {
			if (!list.contains(a)) {
				b = sumOfDivisors(a);
				if (a != b) {
					c = sumOfDivisors(b);
					if (c == a) {
						list.add(b);
						list.add(a);
					}
				}
			}
		}
		int size = list.size();
		for (int i = 0; i < size; i++) {
			sum += list.get(i);
		}
		System.out.println("The sum of all the amicable numbers under 10000 is :" + sum);

	}

	private static int sumOfDivisors(int num) {

		List<Integer> list = new ArrayList<>();
		int limit = (int) Math.sqrt(num);
		int temp = 0;
		int sum = 0;
		// Getting divisors and adding into List.
		for (int i = 1; i <= limit; i++) {
			if (num % i == 0) {
				list.add(i);
				temp = num / i;
				if (i != temp) {
					list.add(temp);
				}
			}
		}
		// Sorting List in acceding order.
		Collections.sort(list);
		int size = list.size();
		for (int i = 0; i < size - 1; i++) {
			sum += list.get(i);
		}
		return sum;
	}

}
