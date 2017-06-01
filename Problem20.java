package com.javamultiplex.projecteuler;

import java.math.BigInteger;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 20 - Factorial Digit Sum.
 *
 */
public class Problem20 {

	public static void main(String[] args) {
		
		int number=100;
		//Converting int to BigInteger.
		BigInteger bigNumber=BigInteger.valueOf(number);
		BigInteger fact=BigInteger.ONE;
		while(!bigNumber.equals(BigInteger.ZERO))
		{
			fact=fact.multiply(bigNumber);
			bigNumber=bigNumber.subtract(BigInteger.ONE);
		}
		//Converting BigInteger to String.
		String factorial=String.valueOf(fact);
		int length=factorial.length();
		int sum=0,temp=0;
		for(int i=0;i<length;i++)
		{
			//Converting char to int.
			temp=factorial.charAt(i)-48;
			sum=sum+temp;
		}
		System.out.println("The sum of the digits in the number 100! is : "+sum);
	}
	
}
