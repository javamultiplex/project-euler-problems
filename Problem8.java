package com.javamultiplex.projecteuler;

import java.math.BigInteger;
/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 8 - Largest product in a series.
 *
 */
public class Problem8 {

	public static void main(String[] args) {
		
		String thousandDigitNumber="73167176531330624919225119674426574742355349194934"+
									"96983520312774506326239578318016984801869478851843"+
									"85861560789112949495459501737958331952853208805511"+
									"12540698747158523863050715693290963295227443043557"+
									"66896648950445244523161731856403098711121722383113"+
									"62229893423380308135336276614282806444486645238749"+
									"30358907296290491560440772390713810515859307960866"+
									"70172427121883998797908792274921901699720888093776"+
									"65727333001053367881220235421809751254540594752243"+
									"52584907711670556013604839586446706324415722155397"+
									"53697817977846174064955149290862569321978468622482"+
									"83972241375657056057490261407972968652414535100474"+
									"82166370484403199890008895243450658541227588666881"+
									"16427171479924442928230863465674813919123162824586"+
									"17866458359124566529476545682848912883142607690042"+
									"24219022671055626321111109370544217506941658960408"+
									"07198403850962455444362981230987879927244284909188"+
									"84580156166097919133875499200524063689912560717606"+
									"05886116467109405077541002256983155200055935729725"+
									"71636269561882670428252483600823257530420752963450";
		String thirteenDigitString=null;
		long lowerLimit=(long) -Math.pow(2, 63);  //Lower limit of long is -2^63
		BigInteger thirteenDigitNumber=BigInteger.ZERO;
		BigInteger multiplication=BigInteger.ZERO;
		BigInteger max=BigInteger.valueOf(lowerLimit); //Converting long to BigInteger
		for(int i=0;i<1000-12;i=i+1)
		{
			thirteenDigitString=thousandDigitNumber.substring(i, i+13);  //Extracting 13 digit number
			thirteenDigitNumber=new BigInteger(thirteenDigitString);	//Converting String to BigInteger
			multiplication=getMultiplication(thirteenDigitNumber);
			/*
			 * if multiplication>max we will get 1
			 * else if multiplication<max we will get -1
			 * else if multiplication==max we will get 0
			 */
			if(multiplication.compareTo(max)==1)					
			{
				max=multiplication;
			}
		}
		System.out.println("The greatest product of thirteen adjacent digits in the 1000-digit number is : "+ max);
	}
	private static BigInteger getMultiplication(BigInteger thirteenDigitNumber) {
		
		BigInteger remainder=BigInteger.ZERO;
		BigInteger base=BigInteger.valueOf(10); //base is decimal(10)
		BigInteger multiplication=BigInteger.ONE;
		while(thirteenDigitNumber!=BigInteger.ZERO)
		{
			remainder=thirteenDigitNumber.remainder(base);
			/*
			 * getting each digit one by one then multiplying
			 * 
			 */
			multiplication=multiplication.multiply(remainder);     
			thirteenDigitNumber=thirteenDigitNumber.divide(base);
		}
		return multiplication;
	}
	
}
