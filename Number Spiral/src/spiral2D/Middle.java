package spiral2D;

import java.util.Arrays;

public class Middle {

	private static int[][] spiral;
	private static int sum;
	private static int cordinateY;
	private static int cordinateX;
	private static int leftCounter = 0;
	private static int upCounter = -1;

	public static void direction(int rows, int collums) {
		spiral = new int[rows][collums];

		sum = rows * collums + 1;
		cordinateY = rows - 1;
		cordinateX = collums - 1;
		for (int i = 0; i <= cordinateY; i++) {
			for (int j = 0; j <= cordinateX; j++) {
				spiral[i][j] = sum;
			}
		}

		clockwise();

	}

	private static void clockwise() {
		while (true) {
			leftClockwise();
			if (yes())
				break;
			upClockwise();
			if (yes())
				break;
			rightClockwise();
			if (yes())
				break;
			downClockwise();
			if (yes())
				break;
		}

		printSpiral();
	}

	static int[][] leftClockwise() {
		int count = countNumber();
		for (int i = cordinateX; i > upCounter; i--) {
			spiral[cordinateY][i] = --count;
		}
		cordinateY--;
		return spiral;
	}

	static int[][] upClockwise() {
		int count = countNumber();
		for (int i = cordinateY; i > upCounter; i--) {
			spiral[i][upCounter + 1] = --count;
		}
		upCounter++;
		return spiral;
	}

	static int[][] rightClockwise() {
		int count = countNumber();
		leftCounter++;
		for (int i = leftCounter; i < (cordinateX + 1); i++) {
			spiral[leftCounter - 1][i] = --count;
		}
		return spiral;
	}

	static int[][] downClockwise() {
		int count = countNumber();
		for (int i = leftCounter; i < (cordinateY + 1); i++) {
			spiral[i][cordinateX] = --count;
		}
		cordinateX--;
		return spiral;
	}

	static int countNumber() {
		int number = sum;
		for (int i = 0; i < spiral.length; i++) {
			for (int j = 0; j < spiral[i].length; j++) {
				if (spiral[i][j] < number) {
					number = spiral[i][j];
				}
			}
		}
		return number;
	}

	private static void printSpiral() {
		for (int i = 0; i < spiral.length; i++) {
			System.out.println(Arrays.toString(spiral[i]));
		}
	}

	static boolean yes() {
		if (countNumber() == 1) {
			return true;
		} else {
			return false;
		}
	}
}
