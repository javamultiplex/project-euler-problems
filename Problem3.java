package com.javamultiplex.projecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 3 - Largest prime factor of 600851475143?
 *
 */
public class Problem3 {

	public static void main(String[] args) {

		/*
		 * We have to find largest prime factor of 600851475143.
		 */
		long limit = 600851475143L;
		/*
		 * 1. We are using Set for storing factors,as we know factors can be
		 * duplicate and we don't wan't duplicate. 2. TreeSet will sort the
		 * factors in ascending order, thats why we are using it.
		 */
		TreeSet<Integer> factors = new TreeSet<Integer>();
		/*
		 * Condition1:Reducing the limit,dividing it by 2 till limit%2==0.
		 */
		while (limit % 2 == 0) {
			factors.add(2);
			limit = limit / 2;
		}
		/*
		 * Condition2:At this point we don't have multiple of 2, thats why we
		 * are skipping even numbers(i=i+2).
		 */
		for (int i = 3; i <= Math.sqrt(limit); i = i + 2) {
			/*
			 * Same as Condition1.
			 * 
			 */
			while (limit % i == 0) {
				factors.add(i);
				limit = limit / i;
			}
		}
		/*
		 * 
		 * After Condition1 and Condition2 we will get limit that is prime
		 * number and greater than 2.
		 */
		if (limit > 2) {
			factors.add((int) limit);
		}
		/*
		 * Converting TreeSet to ArrayList, because we want largest factor. That
		 * is last element of the list.
		 * 
		 */
		List<Integer> list = new ArrayList<Integer>(factors);
		int size = list.size();
		int lastElement = list.get(size - 1);
		System.out.println("The largest prime factor of the number 600851475143 is: " + lastElement);
	}

}
