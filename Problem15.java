package com.javamultiplex.projecteuler;

import java.math.BigInteger;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 15 - Lattice paths.
 *
 */
public class Problem15 {

	public static void main(String[] args) {

		long n = 20;
		/*
		 * We can relate this problem to Pascal's triangle. we have to found
		 * 2nCn where C=combination. Combination formula = n!/r!(n-r)!
		 */
		BigInteger result = factorial(2 * n).divide(factorial(n).multiply(factorial(n)));
		System.out.println("There are " + result + " routes through a 20×20 grid.");
	}

	public static BigInteger factorial(long num) {
		BigInteger fact = BigInteger.ONE;
		BigInteger zero = BigInteger.ZERO;
		// Converting long to String and assigning to BigInteger.
		BigInteger number = new BigInteger(String.valueOf(num));
		while (!number.equals(zero)) {
			fact = fact.multiply(number);
			number = number.subtract(BigInteger.ONE);
		}
		return fact;
	}

}
