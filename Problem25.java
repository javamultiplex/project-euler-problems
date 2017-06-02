package com.javamultiplex.projecteuler;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 25 - 1000 digit Fibonacci number.
 *
 */
public class Problem25 {

	public static void main(String[] args) {
		
		/*
		 * We are using Binet's Fibonacci Number Formula for 
		 * calculating Fibonacci term that contains d digits.
		 * 
		 * Fibonacci term = ceil ((d-1+(log 5)/2)/(log phi))
		 * where phi = (1+sqrt(5))/2
		 * 
		 */
		double phi=(1+Math.sqrt(5))/2;
		int d=1000;
		int term=(int) Math.ceil((d-1+(Math.log10(5))/2)/Math.log10(phi));
		System.out.println("The index of the first term in the Fibonacci sequence to contain 1000 digits is : "+term);
	}
	
}
