package com.javamultiplex.projecteuler;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 5 - Smallest multiple from 1 to 20
 *
 */
public class Problem5 {

	public static void main(String[] args) {

		long limit = 20;
		long result = 1;
		for (int i = 2; i <= limit; i++) {
			result = getLCM(result, i);

		}
		System.out.println("The smallest positive number that is evenly divisible by "
				+ "all of the numbers from 1 to 20 is : " + result);
	}

	private static long getLCM(long result, int i) {

		long HCM = getHCM(result, i); // HCM is must for LCM
		//Relationship between HCM and LCM is HCM*LCM=number1*number2
		long LCM = (result * i) / HCM; 
		return LCM;

	}

	/*
	 * Here we are using Euclidean algorithm for find HCM of two numbers.
	 * 
	 */
	private static long getHCM(long result, int i) {
		long a, b, temp;
		if (result > i) {
			a = result;
			b = i;
		} else {
			a = i;
			b = result;
		}
		while (b != 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

}
