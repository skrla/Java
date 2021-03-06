package spiral2d;

public class UpperLeftCorner {

	private static int[][] spiral;
	private static int sum;
	private static int cordinateY;
	private static int cordinateX;
	private static int leftCounter = 0;
	private static int upCounter = -1;

	public static void direction(int rows, int collums, boolean goingDirection) {

		spiral = new int[rows][collums];

		sum = rows * collums;
		cordinateY = rows - 1;
		cordinateX = collums - 1;

		if (goingDirection) clockwise(); else counterClockwise();

	}

	private static void clockwise() {
		while (true) {
			rightClockwise();
			if (yes())
				break;
			downClockwise();
			if (yes())
				break;
			leftClockwise();
			if (yes())
				break;
			upClockwise();
			if (yes())
				break;
		}

		Output.printingSpiral(spiral);
	}

	private static void counterClockwise() {

		while (true) {
			downCounterClockwise();
			if (yes())
				break;
			rightCounterClockwise();
			if (yes())
				break;
			upCounterClockwise();
			if (yes())
				break;
			leftCounterClockwise();
			if (yes())
				break;
		}

		Output.printingSpiral(spiral);

	}

	private static void rightClockwise() {
		int count = countNumber();
		for (int i = leftCounter; i < (cordinateX + 1); i++) {
			spiral[leftCounter][i] = ++count;
		}
	}

	private static void downClockwise() {
		int count = countNumber();
		leftCounter++;
		for (int i = leftCounter; i < (cordinateY + 1); i++) {
			spiral[i][cordinateX] = ++count;
		}
	}

	private static void leftClockwise() {
		int count = countNumber();
		for (int i = cordinateX - 1; i > upCounter; i--) {
			spiral[cordinateY][i] = ++count;
		}
		cordinateY--;
		upCounter++;
	}

	private static void upClockwise() {
		int count = countNumber();
		for (int i = cordinateY; i > upCounter; i--) {
			spiral[i][upCounter] = ++count;
		}
		cordinateX--;
	}

	private static void downCounterClockwise() {
		int count = countNumber();
		for (int i = leftCounter; i < (cordinateY + 1); i++) {
			spiral[i][leftCounter] = ++count;
		}
		leftCounter++;

	}

	private static void rightCounterClockwise() {
		int count = countNumber();
		for (int i = leftCounter; i < (cordinateX + 1); i++) {
			spiral[cordinateY][i] = ++count;
		}
		cordinateY--;

	}

	private static void upCounterClockwise() {
		int count = countNumber();
		for (int i = cordinateY; i > upCounter; i--) {
			spiral[i][cordinateX] = ++count;
		}
		upCounter++;
		cordinateX--;

	}

	private static void leftCounterClockwise() {
		int count = countNumber();
		for (int i = cordinateX; i > upCounter; i--) {
			spiral[upCounter][i] = ++count;
		}

	}

	private static int countNumber() {
		int number = 0;
		for (int i = 0; i < spiral.length; i++) {
			for (int j = 0; j < spiral[i].length; j++) {
				if (spiral[i][j] > number) {
					number = spiral[i][j];
				}
			}
		}
		return number;
	}

	private static boolean yes() {
		if (countNumber() == sum) {
			return true;
		} else {
			return false;
		}
	}
}
