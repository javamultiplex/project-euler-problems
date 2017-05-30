package com.javamultiplex.projecteuler;

/**
 * 
 *
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 6 - Sum square difference
 *
 */
public class Problem6 {

	public static void main(String[] args) {

		long limit = 100;
		// 1^2+2^2+3^2+.....+n^2=(n*(n+1)*(2n+1))/6
		long sumOfSquaresOfNaturalNumbres = (limit * (limit + 1) * ((2 * limit) + 1)) / 6;
		// 1+2+3+4+...+n=(n*(n+1))/2
		long sumOfNaturalNumbers = (limit * (limit + 1)) / 2;
		long squareOfSumOfNaturalNumbers = (long) Math.pow(sumOfNaturalNumbers, 2);
		long difference = Math.abs(squareOfSumOfNaturalNumbers - sumOfSquaresOfNaturalNumbres);
		System.out.println("The sum square difference is : " + difference);

	}

}
