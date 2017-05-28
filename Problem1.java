package com.projecteuler;
/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problem 1: Multiples of 3 and 5
 * 
 *
 */
public class Problem1 {
	
	public static void main(String[] args) {

		int sum=0;
		for(int num=1;num<1000;num++)
		{
			/*
			 * On dividing a number by 3 or 5, if we are getting remainder zerO
			 * it means that number is multiple of either 3 or 5
			 * 
			 */
			if(num%3==0 || num%5==0) 
			{
				sum=sum+num;
			}
		}
		System.out.println("\nThe sum of all multiples of 3 or 5 below 1000 is : "+sum);
		
	}

}
