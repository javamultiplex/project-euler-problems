package com.javamultiplex.projecteuler;

import java.util.Arrays;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 10 - Summation of primes
 *
 */
public class Problem10 {

	public static void main(String[] args) {
		
		int limit=2000000;  //2 Million
		long sum=0;
		boolean primes[]=new boolean[limit];
		Arrays.fill(primes, true); //Assign true to all array elements
		generatePrimes(primes);
		for(int i=2;i<limit;i++)
		{
			if(primes[i])
			{
				sum=sum+i;
			}
		}
		System.out.println("The sum of all the primes below two million is : "+sum);
	}

	/*
	 * 
	 * Sieve of Eratosthenes - Algorithm for generating prime numbers.
	 * 
	 */
	private static void generatePrimes(boolean[] primes) {
		
		int length=primes.length;
		int sqrt=(int) Math.sqrt(length);
		for(int i=2;i<=sqrt;i++)
		{
			for(int j=i*i;j<length;j=j+i)
			{
				primes[j]=false;
			}
		}
		
	}
	
}
