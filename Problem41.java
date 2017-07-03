package com.javamultiplex.projecteuler;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem41 {
	
	/**
	 * Here we are using Narayana Pandit's algorithm for finding nth
	 * lexicographic permutation.
	 */
	public static void main(String[] args) {

		int n=9;
		BigInteger result=BigInteger.ZERO;
		result=getMaxPrime(n);
		//while(result==0)
		while(result.equals(BigInteger.ZERO))
		{
			n--;
			result=getMaxPrime(n);
		}
		
		System.out.println("The largest n-digit pandigital prime is : "+result);
		
	}

	

	private static BigInteger getMaxPrime(int n) {
		
		int digits[]=getArray(n);
		int permutations=fact(n);
		int k = 0, i = 0;
		String result = null;
		BigInteger temp = null;
		// max=0
		BigInteger max=BigInteger.ZERO;
		for (int j = 1; j <= permutations; j++) {
			// Step 1 : Find largest index k such that digits[k]<digits[k+1]
			k = getK(digits, n);
			// Step 2 : Find largest index i such that digits[k]<digits[i]
			i = getI(digits, n, k);
			// Step 3 : Swap digits[j] and digits[k]
			digits = swapKandI(digits, k, i);
			// Step 4 : Reverse all the values in array from k+1 to end.
			digits = reverseFromKtoEnd(digits, k, n);
			result = getStringByArray(digits, n);
			//Converting String to BigInteger
			temp=new BigInteger(result);
			//Check for prime numbers.
			if(temp.isProbablePrime(1))
			{
				//Find max and return it.
				max=temp.max(max);
			}
		}
		return max;
		
	}



	private static int fact(int n) {
	
		int fact=1;
		while(n!=0)
		{
			fact=fact*n;
			n--;
		}
		return fact;
	}



	private static int[] getArray(int n) {
		
		int arr[]=new int[n];
		int j=1;
		for(int i=0;i<n;i++)
		{
			arr[i]=j++;
		}
		return arr;
	}



	private static String getStringByArray(int[] digits, int length) {

		String string = "";
		for (int i = 0; i < length; i++) {
			// Converting int to String and appending into string variable.
			string += String.valueOf(digits[i]);
		}

		return string;
	}

	private static int[] reverseFromKtoEnd(int[] digits, int k, int length) {

		/*
		 * For reversing array elements we are storing elements from k+1 to
		 * length-1 into temp array.
		 */
		int temp[] = Arrays.copyOfRange(digits, k + 1, length);
		int l = temp.length;
		for (int i = k + 1; i < length; i++) {
			digits[i] = temp[l - 1];
			l--;
		}
		return digits;
	}

	private static int[] swapKandI(int[] digits, int k, int i) {

		int temp = digits[k];
		digits[k] = digits[i];
		digits[i] = temp;
		return digits;
	}

	private static int getI(int[] digits, int length, int k) {

		int j = 0;
		for (int i = length - 1; i > k; i--) {
			if (digits[i] > digits[k]) {
				j = i;
				break;
			}
		}

		return j;
	}

	private static int getK(int[] digits, int length) {

		int k = 0;
		for (int i = length - 1; i > 0; i--) {
			if (digits[i] > digits[i - 1]) {
				k = i - 1;
				break;
			}
		}
		return k;
	}

}
