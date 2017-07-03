package com.javamultiplex.projecteuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem42 {

	public static Map<Character, Integer> map = new HashMap<>();
	public static List<Integer> triangles = new ArrayList<>();
	static {

		// Adding alphabets position in Map.
		map.put('A', 1);
		map.put('B', 2);
		map.put('C', 3);
		map.put('D', 4);
		map.put('E', 5);
		map.put('F', 6);
		map.put('G', 7);
		map.put('H', 8);
		map.put('I', 9);
		map.put('J', 10);
		map.put('K', 11);
		map.put('L', 12);
		map.put('M', 13);
		map.put('N', 14);
		map.put('O', 15);
		map.put('P', 16);
		map.put('Q', 17);
		map.put('R', 18);
		map.put('S', 19);
		map.put('T', 20);
		map.put('U', 21);
		map.put('V', 22);
		map.put('W', 23);
		map.put('X', 24);
		map.put('Y', 25);
		map.put('Z', 26);

		// generating triangle numbers, we have to generate only 18 triangle
		// numbers.
		int temp = 0;
		for (int n = 1; n <= 18; n++) {
			temp = n * (n + 1) / 2;
			triangles.add(temp);
		}

	}

	public static void main(String[] args) {

		File file = new File("D:/words.txt");
		Scanner input = null;
		int count = 0;
		try {
			input = new Scanner(file);
			String string = null;
			if (input.hasNextLine()) {
				// Reading whole line from the file.
				string = input.nextLine();
			}
			// Separating strings with delimiter ","
			String[] myStrings = string.split(",");
			// Sorting strings in ascending order
			Arrays.sort(myStrings);
			int length = myStrings.length;
			int tempLength = 0, sum = 0;
			String temp = null;
			for (int i = 0; i < length; i++) {
				sum = 0;
				tempLength = myStrings[i].length();
				// Removing "" from each string.
				myStrings[i] = myStrings[i].substring(1, tempLength - 1);
				// Converting String to upper case.
				temp = myStrings[i].toUpperCase();
				tempLength = temp.length();
				for (int j = 0; j < tempLength; j++) {

					// Getting alphabet position from Map and adding it.
					sum = sum + map.get(temp.charAt(j));
				}

				// Checking whether word is triangle or not.
				if (triangles.contains(sum)) {
					count++;
				}

			}

			System.out.println("Total triangle words : " + count);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

}
