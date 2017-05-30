package com.javamultiplex.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problems 2 - Even Fibonacci numbers
 *
 */
public class Problem2 {

	public static void main(String[] args) {

		int limit = 4000000; // 4 million
		long result = getSumOfEvenFibonacciSequence(limit);
		System.out.println("The sum of even valued terms of fibonacci sequence "
				+ "whose values do not exceed four million is : " + result);
	}

	private static long getSumOfEvenFibonacciSequence(int limit) {

		List<Integer> fib = new ArrayList<Integer>();
		/*
		 * Default values of first two terms of fibonacci sequence is 1,1.
		 */
		fib.add(0, 1);
		fib.add(1, 1);
		int i = 1, temp, evenSum = 0;
		while (fib.get(i) <= limit) {
			i++;
			temp = getNextFibonacciTerm(fib, i);
			fib.add(i, temp);
			temp = fib.get(i);
			if (temp <= limit) {
				if (temp % 2 == 0) {
					evenSum += temp;
				}
			}
		}

		return evenSum;
	}

	private static int getNextFibonacciTerm(List<Integer> fib, int i) {

		/*
		 * On adding previous 2 terms we can get next fibonacci term.
		 * 
		 */
		int result = fib.get(i - 1) + fib.get(i - 2);
		return result;

	}

}
