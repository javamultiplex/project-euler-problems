package com.javamultiplex.projecteuler;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 9 - Special Pythagorean Triplets
 *
 */
public class Problem9 {

	public static void main(String[] args) {

		int limit = 1000, a, b, c, result;
		for (int i = 1; i < limit; i++) {
			a = i;
			/*
			 * if a+b+c=n and c^2=a^2+b^2 on solving above equations we can find
			 * value of b in terms of a and n 
			 * b=(n^2-2an)/2(n-a)
			 * 
			 */
			b = (int) ((Math.pow(limit, 2) - 2 * a * limit) / (2 * (limit - a)));
			c = limit - b - a;
			if (isPythagoreanTriplet(a, b, c)) {
				if (a + b + c == limit) {
					result = a * b * c;
					System.out.println("Pythagorean triplet for which a + b + c = 1000 is : " + result);
					break;
				}
			}
		}

	}

	/*
	 * a,b and c are Pythagorean Triplets if c>b>a and c^2=a^2+b^2
	 * 
	 */
	private static boolean isPythagoreanTriplet(int a, int b, int c) {

		boolean result = false;
		if (c > b && b > a) {
			if (c * c == a * a + b * b) {
				result = true;
			}
		}
		return result;
	}

}
