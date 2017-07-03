package com.javamultiplex.projecteuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem67 {

	public static void main(String[] args) {

		File file = new File("D:/triangle.txt");
		int numberofRows = 100;
		String[] rows = getTriangleRowsFromFile(file, numberofRows);
		int[][] triangle = new int[numberofRows][numberofRows];
		String[] temp = null;
		int length = 0, max = 0;
		for (int i = 0; i < numberofRows; i++) {
			// Assigning zero to each element of 2d array.
			Arrays.fill(triangle[i], 0);
		}
		for (int i = 0; i < numberofRows; i++) {
			// Splitting each triangle row by delimiter space.
			temp = rows[i].split(" ");
			length = temp.length;
			for (int j = 0; j < length; j++) {
				/*
				 * Assigning each element of temp array to 2d array. But before
				 * that we have to convert String to Integer.
				 */
				triangle[i][j] = Integer.valueOf(temp[j]);
			}
		}

		max = getMaxTotalFromTopToBottom(triangle, numberofRows);
		System.out.println("The maximum total from top to bottom in given triangle is : "
						+ max);

	}

	private static int getMaxTotalFromTopToBottom(int[][] triangle, int size) {

		int max = 0;
		for (int i = 1; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					// Updating first element of each row.
					triangle[i][j] = triangle[i][j] + triangle[i - 1][0];
				} else if (j == i) {
					// Updating last element of each row.
					triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
				} else {
					// Updating other elements.
					triangle[i][j] = triangle[i][j]
							+ Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
				}
			}
		}

		max = triangle[size - 1][0];
		// Finding max element in last row.
		for (int i = 1; i < size; i++) {

			if (triangle[size - 1][i] > max) {
				max = triangle[size - 1][i];
			}
		}

		return max;
	}

	private static String[] getTriangleRowsFromFile(File file, int numberofRows) {

		Scanner input = null;
		String[] rows = new String[numberofRows];
		try {

			input = new Scanner(file);
			int i = 0;
			while (input.hasNextLine()) {
				rows[i] = input.nextLine();
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}

		return rows;
	}

}
