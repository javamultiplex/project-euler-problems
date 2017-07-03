package com.javamultiplex.projecteuler;

import java.util.LinkedHashMap;
import java.util.Map;

public class Problem26 {

	public static void main(String[] args) {

		int n = 1, target = 1000;
		String result = null;
		int length = 0, max = 0, denominator = 0;

		for (int d = 2; d < target; d++) {
			result = getRecurringDecimalDigits(n, d);
			length = result.length();
			if (length > max) {
				max = length;
				denominator = d;
			}
		}
		System.out.println("The value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part : "
						+ denominator);
	}

	private static String getRecurringDecimalDigits(int n, int d) {

		/*
		 * In map, we will store remainder as a key and its position as a value.
		 */
		Map<Integer, Integer> map = new LinkedHashMap<>();
		String result = "";
		// Get first remainder.
		int remainder = n % d;
		int position = 0, temp = 0;
		/*
		 * Run while loop until remainder !=0 and map doesn't contains
		 * remainder.
		 */
		while (remainder != 0 && !(map.containsKey(remainder))) {
			position = result.length();
			map.put(remainder, position);
			remainder = remainder * 10;
			temp = remainder / d;
			// Convert int to String and append into result.
			result += String.valueOf(temp);
			remainder = remainder % d;
		}

		if (remainder == 0) {
			return "";
		} else {
			/*
			 * As you know we are storing remainder and its position in map. and
			 * our result contains recurring sequence. So extracting the
			 * recurring sequence from result.
			 */
			return result.substring(map.get(remainder));
		}
	}

}
