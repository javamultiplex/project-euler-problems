package com.javamultiplex.projecteuler;

import java.math.BigInteger;

public class Problem34 {

	//9! * 7 = 2540160
	public static int upperBound=2540160;
	//one digit number won't generate sum.
	public static int lowerBound=10;
	public static BigInteger fact[]=new BigInteger[10];
	static
	{
		//fact[0]=1
		fact[0]=BigInteger.ONE;
		BigInteger temp=null;
		for(int i=1;i<10;i++)
		{
			//convert int to BigInteger.
			temp=BigInteger.valueOf(i);
			fact[i]=temp.multiply(fact[i-1]);
		}
	}
	public static void main(String[] args) {
		
		String temp=null;
		int length=0,sum=0;
		for(int i=lowerBound;i<=upperBound;i++)
		{
			//Convert int to String.
			temp=String.valueOf(i);
			length=temp.length();
			if(isFactorion(temp,length))
			{
				sum+=i;
			}
		}
		System.out.println("The sum of all numbers which are equal to the sum of the factorial of their digits : "+sum);
		
	}
	private static boolean isFactorion(String num, int length) {
		
		int temp=0;
		//sum=0
		BigInteger sum=BigInteger.ZERO;
		String factSum=null;
		boolean result=false;
		for(int i=0;i<length;i++)
		{
			//convert char to int.
			temp=num.charAt(i)-48;
			sum=sum.add(fact[temp]);
		}
		//convert BigInteger to String.
		factSum=String.valueOf(sum);
		if(num.equals(factSum))
		{
			result=true;
		}
		return result;
	}
	
}
