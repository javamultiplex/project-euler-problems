package com.javamultiplex.projecteuler;

public class Problem28 {

	public static void main(String[] args) {

		int size = 1001;
		int[][] spiral = new int[size][size];
		int value = size * size;
		int limit = 0, k = 0, sum = 0;
		limit = size / 2;
		spiral[limit][limit] = 1;
		for (int i = 0; i < limit; i++) {
			
			//Right->Left
			for (int j = size - 1 - i; j > i; j--) {
				spiral[i][j] = value--;
			}
			//Top->Bottom
			for (int j = i; j < (size - 1 - i); j++) {
				spiral[j][i] = value--;
			}
			k = size - 1 - i;
			//Left->Right
			for (int j = i; j < (size - 1 - i); j++) {
				spiral[k][j] = value--;
			}
			//Bottom->Top
			for (int j = size - 1 - i; j > i; j--) {
				spiral[j][k] = value--;
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) // For left side diagonal
				{
					sum += spiral[i][j];
				} else if (i + j == (size - 1)) // For left side diagonal
				{
					sum += spiral[i][j];
				}
			}
		}
		System.out.println("The sum of the numbers on the diagonals in a 1001 by 1001 spiral is : "
						+ sum);

	}

}
