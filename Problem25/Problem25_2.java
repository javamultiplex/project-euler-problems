package com.javamultiplex.projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 25 - 1000 digit Fibonacci number.
 *
 */
public class Problem25_2 {

	public static void main(String[] args) {

		List<BigInteger> fib = new ArrayList<>();
		long start = System.currentTimeMillis();
		// Default values fib[0]=1,fib[1]=1
		fib.add(0, BigInteger.ONE);
		fib.add(1, BigInteger.ONE);
		int i = 2;
		int length = 1000;
		int digits = 0;
		BigInteger temp = null;
		while (true) {
			// fib[n]=fib[n-1]+fib[n-2]
			temp = fib.get(i - 1).add(fib.get(i - 2));
			fib.add(i, temp);
			digits = getNumberofDigits(temp);
			if (digits == length) {
				System.out.println("The index of the first term in the Fibonacci sequence to contain 1000 digits is : "
								+ (i + 1));
				break;
			}
			i++;
		}
		long end = System.currentTimeMillis();
		//Converting milliseconds to seconds
		double seconds = (double) (end - start) / 1000;
		System.out.println("Time taken : " + seconds + " sec");

	}

	private static int getNumberofDigits(BigInteger temp) {

		// Convert BigInteger to String.
		String number = String.valueOf(temp);
		int length = number.length();
		return length;
	}

}
