package com.javamultiplex.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Rohit Agarwal
 * @category Project Euler Problems
 * @Problem 11 - Largest product in a grid.
 *
 */
public class Problem11 {

	public static void main(String[] args) {

		long[][] grid = {
				{ 8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8 },
				{ 49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0 },
				{ 81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65 },
				{ 52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91 },
				{ 22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80 },
				{ 24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50 },
				{ 32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70 },
				{ 67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21 },
				{ 24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72 },
				{ 21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95 },
				{ 78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92 },
				{ 16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57 },
				{ 86, 56, 0, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21,  58, 51, 54, 17, 58 },
				{ 19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40 },
				{ 4, 52, 8, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66 },
				{ 88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69 },
				{ 4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36 },
				{ 20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16 },
				{ 20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54 },
				{ 1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48 } };

		long right = 0, left = 0, bottom = 0, top = 0, bottomRightDiagonal = 0, bottomLeftDiagonal = 0, topRightDiagonal = 0, topLeftDiagonal = 0;
		long max = 0;
		long[] array = new long[8];
		List<Long> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				right = 0;
				left = 0;
				bottom = 0;
				top = 0;
				bottomRightDiagonal = 0;
				bottomLeftDiagonal = 0;
				topRightDiagonal = 0;
				topLeftDiagonal = 0;
				//case 1
				if (i < 3 && j < 3) {
					right = getRightSideMultiplication(grid, i, j);
					bottom = getBottomSideMultiplication(grid, i, j);
					bottomRightDiagonal = getBottomRightDiagonalMultiplication(
							grid, i, j);
				}
				//case 2
				else if (i < 3 && (j >= 3 && j < 17)) {
					right = getRightSideMultiplication(grid, i, j);
					left = getLeftSideMultiplication(grid, i, j);
					bottom = getBottomSideMultiplication(grid, i, j);
					bottomRightDiagonal = getBottomRightDiagonalMultiplication(
							grid, i, j);
					bottomLeftDiagonal = getBottomLeftDiagonalMultiplication(
							grid, i, j);
				}
				//case 3
				else if (i < 3 && j >= 17) {
					left = getLeftSideMultiplication(grid, i, j);
					bottom = getBottomSideMultiplication(grid, i, j);
					bottomLeftDiagonal = getBottomLeftDiagonalMultiplication(
							grid, i, j);
				}
				//case 4
				else if ((i >= 3 && i < 17) && j < 3) {
					right = getRightSideMultiplication(grid, i, j);
					bottom = getBottomSideMultiplication(grid, i, j);
					top = getTopSideMultiplication(grid, i, j);
					bottomRightDiagonal = getBottomRightDiagonalMultiplication(
							grid, i, j);
					topRightDiagonal = getTopRightDiagonalMultiplication(grid,
							i, j);
				}
				//case 5
				else if (i >= 17 && j < 3) {
					right = getRightSideMultiplication(grid, i, j);
					top = getTopSideMultiplication(grid, i, j);
					topRightDiagonal = getTopRightDiagonalMultiplication(grid,
							i, j);
				}
				//case 6
				else if ((i >= 3 && i < 17) && (j >= 3 && j < 17)) {
					right = getRightSideMultiplication(grid, i, j);
					left = getLeftSideMultiplication(grid, i, j);
					bottom = getBottomSideMultiplication(grid, i, j);
					top = getTopSideMultiplication(grid, i, j);
					bottomRightDiagonal = getBottomRightDiagonalMultiplication(
							grid, i, j);
					bottomLeftDiagonal = getBottomLeftDiagonalMultiplication(
							grid, i, j);
					topRightDiagonal = getTopRightDiagonalMultiplication(grid,
							i, j);
					topLeftDiagonal = getTopLeftDiagonalMultiplication(grid, i,
							j);

				} 
				//case 7
				else if (i >= 17 && (j >= 3 && j < 17)) {
					right = getRightSideMultiplication(grid, i, j);
					left = getLeftSideMultiplication(grid, i, j);
					top = getTopSideMultiplication(grid, i, j);
					topRightDiagonal = getTopRightDiagonalMultiplication(grid,
							i, j);
					topLeftDiagonal = getTopLeftDiagonalMultiplication(grid, i,
							j);
				}
				//case 8
				else if (i >= 17 && j >= 17) {
					left = getLeftSideMultiplication(grid, i, j);
					top = getTopSideMultiplication(grid, i, j);
					topLeftDiagonal = getTopLeftDiagonalMultiplication(grid, i,
							j);

				}
				//Adding left,right,top,bottom,topRightDiagonal, topLeftDiagonal,bottomRightDiagonal,bottomLeftDiagonal side multiplication in an array.
				array[0] = left;
				array[1] = right;
				array[2] = top;
				array[3] = bottom;
				array[4] = topRightDiagonal;
				array[5] = topLeftDiagonal;
				array[6] = bottomRightDiagonal;
				array[7] = bottomLeftDiagonal;
				//Getting max multiplication from array.
				max = getMax(array);
				//Adding max into list.
				list.add(max);
			}
		}
		//Sorting list elements in ascending order.
		Collections.sort(list);
		int size = list.size();
		System.out.println("The greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid is : "
						+ list.get(size - 1));
	}

	private static long getMax(long[] array) {

		long max = array[0];
		for (int i = 1; i < 8; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		return max;
	}

	public static long getRightSideMultiplication(long[][] grid, int i, int j) {
		long temp = grid[i][j] * grid[i][j + 1] * grid[i][j + 2]
				* grid[i][j + 3];
		return temp;
	}

	public static long getLeftSideMultiplication(long[][] grid, int i, int j) {
		long temp = grid[i][j] * grid[i][j - 1] * grid[i][j - 2]
				* grid[i][j - 3];
		;
		return temp;
	}

	public static long getTopSideMultiplication(long[][] grid, int i, int j) {
		long temp = grid[i][j] * grid[i - 1][j] * grid[i - 2][j]
				* grid[i - 3][j];
		return temp;
	}

	public static long getBottomSideMultiplication(long[][] grid, int i, int j) {
		long temp = grid[i][j] * grid[i + 1][j] * grid[i + 2][j]
				* grid[i + 3][j];
		return temp;
	}

	public static long getBottomRightDiagonalMultiplication(long[][] grid,
			int i, int j) {
		long temp = grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2]
				* grid[i + 3][j + 3];
		return temp;
	}

	public static long getBottomLeftDiagonalMultiplication(long[][] grid,
			int i, int j) {
		long temp = grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j - 2]
				* grid[i + 3][j - 3];
		return temp;
	}

	public static long getTopRightDiagonalMultiplication(long[][] grid, int i,
			int j) {
		long temp = grid[i][j] * grid[i - 1][j + 1] * grid[i - 2][j + 2]
				* grid[i - 3][j + 3];
		return temp;
	}

	public static long getTopLeftDiagonalMultiplication(long[][] grid, int i,
			int j) {
		long temp = grid[i][j] * grid[i - 1][j - 1] * grid[i - 2][j - 2]
				* grid[i - 3][j - 3];
		return temp;
	}
}
