package com.javamultiplex.projecteuler;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 17 - Number letter counts.
 *
 */
public class Problem17 {
	
	public static Map<Integer,String> constantWords=new LinkedHashMap<>();
	
	//Adding all constant words in Map.
	static 
	{
		constantWords.put(1, "ONE");
		constantWords.put(2, "TWO");
		constantWords.put(3, "THREE");
		constantWords.put(4, "FOUR");
		constantWords.put(5, "FIVE");
		constantWords.put(6, "SIX");
		constantWords.put(7, "SEVEN");
		constantWords.put(8, "EIGHT");
		constantWords.put(9, "NINE");
		constantWords.put(10, "TEN");
		constantWords.put(11, "ELEVAN");
		constantWords.put(12, "TWELVE");
		constantWords.put(13, "THIRTEEN");
		constantWords.put(14, "FOURTEEN");
		constantWords.put(15, "FIFTEEN");
		constantWords.put(16, "SIXTEEN");
		constantWords.put(17, "SEVENTEEN");
		constantWords.put(18, "EIGHTEEN");
		constantWords.put(19, "NINETEEN");
		constantWords.put(20, "TWENTY");
		constantWords.put(30, "THIRTY");
		constantWords.put(40, "FORTY");
		constantWords.put(50, "FIFTY");
		constantWords.put(60, "SIXTY");
		constantWords.put(70, "SEVENTY");
		constantWords.put(80, "EIGHTY");
		constantWords.put(90, "NINETY");
		constantWords.put(100, "HUNDRED");
		constantWords.put(1000, "THOUSAND");
	}
	
	public static void main(String[] args) {
		
		int start = 1;
		int end = 1000;
		int length=0;
		String word=null;
		int rem=0;
		int temp=0;
		int quotient=0;
		for(int i=start;i<=end;i++)
		{
			if(i<=20)
			{
				word=constantWords.get(i);
			}
			else if(i>20 && i<100)
			{
				word=getWordsBelowOneHundred(i);
			}
			else if(i>=100 && i<1000)
			{
				rem=i%100;
				quotient=i/100;
				/*
				 * if condition work for 101,102,103..199,201,202,203........299,301,302.....999
				 * else condition work for 100,200,300,400,500,600,700,800,900.
				 * 
				 */
				if(rem!=0)
				{
					word=constantWords.get(quotient)+constantWords.get(100)+"and";
					/*
					 * if condition work for 101,102...120,201,202....220,301,302..920
					 * else condition work for 121,122,....199,221,222,....299,321,322,.....999
					 * 
					 */
					if(rem>=1 && rem<=20)
					{
						word=word+constantWords.get(rem);
					}
					else
					{
						temp=rem;
						word=word+getWordsBelowOneHundred(temp);
						
					}
				}
				else
				{
					
					word=constantWords.get(quotient)+constantWords.get(100);
				}
			}
			else
			{
				//Getting 1000
				word=constantWords.get(1)+constantWords.get(1000);
			}
			//Adding length of all the words.
			length+=word.length();
		}
		
		System.out.println("Number of letters in words from 1 to 1000 are: "+length);

	}

	private static String getWordsBelowOneHundred(int i) {
		
		int rem=i%10;
		int temp=0;
		String word=null;
		/*
		 * if condition work for 21,22,...29,31,32.....39,41..91,92...99.
		 * else condition work for 30,40,50,60,70,80,90.
		 * 
		 */
		if(rem!=0)
		{
			//Getting 20,30,40,50,60,70,80,90.
			temp=i-rem;
			word=constantWords.get(temp)+constantWords.get(rem);
		}
		else
		{
			word=constantWords.get(i);
		}
		return word;
	}

}
