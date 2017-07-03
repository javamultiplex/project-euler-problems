package com.javamultiplex.projecteuler;

import java.math.BigInteger;

public class Problem48 {

	public static void main(String[] args) {
		
		int limit=1000;
		BigInteger temp=null,power=null;
		//sum=0
		BigInteger sum=BigInteger.ZERO;
		for(int i=1;i<=limit;i++)
		{
			//Convert int to String and assigning to BigInteger object.
			temp=new BigInteger(String.valueOf(i));
			//temp^i
			power=temp.pow(i);
			//adding powers
			sum=sum.add(power);
		}
		//Convert BigInteger to String.
		String finalSum=String.valueOf(sum);
		int length=finalSum.length();
		String result=finalSum.substring(length-10,length);
		System.out.println(result);
	}
	
}
