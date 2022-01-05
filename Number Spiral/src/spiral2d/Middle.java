package spiral2d;

public class Middle {

	private static int[][] spiral;
	private static int sum;
	private static int cordinateY;
	private static int cordinateX;
	private static int leftCounter = 0;
	private static int upCounter = -1;

	public static void direction(int rows, int collums, boolean goingDirection) {

		spiral = new int[rows][collums];

		sum = rows * collums + 1;
		cordinateY = rows - 1;
		cordinateX = collums - 1;
		for (int i = 0; i <= cordinateY; i++) {
			for (int j = 0; j <= cordinateX; j++) {
				spiral[i][j] = sum;
			}
		}

		if (goingDirection) clockwise(); else counterClockwise();

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

		Output.printingSpiral(spiral);
	}
	
	private static void counterClockwise() {

		while (true) {
			upCounterClockwise();
			if (yes())
				break;
			leftCounterClockwise();
			if (yes())
				break;
			downCounterClockwise();
			if (yes())
				break;
			rightCounterClockwise();
			if (yes())
				break;
		}

		Output.printingSpiral(spiral);

	}

	private static void leftClockwise() {
		int count = countNumber();
		for (int i = cordinateX; i > upCounter; i--) {
			spiral[cordinateY][i] = --count;
		}
		cordinateY--;
	}

	private static void upClockwise() {
		int count = countNumber();
		for (int i = cordinateY; i > upCounter; i--) {
			spiral[i][upCounter + 1] = --count;
		}
		upCounter++;
	}

	private static void rightClockwise() {
		int count = countNumber();
		leftCounter++;
		for (int i = leftCounter; i < (cordinateX + 1); i++) {
			spiral[leftCounter - 1][i] = --count;
		}
	}

	private static void downClockwise() {
		int count = countNumber();
		for (int i = leftCounter; i < (cordinateY + 1); i++) {
			spiral[i][cordinateX] = --count;
		}
		cordinateX--;
	}
	
	private static void upCounterClockwise() {
		int count = countNumber();
		for (int i = cordinateY; i > upCounter; i--) {
			spiral[i][cordinateX] = --count;
		}
		cordinateX--;

	}

	private static void leftCounterClockwise() {
		int count = countNumber();
		for (int i = cordinateX; i > upCounter; i--) {
			spiral[upCounter + 1][i] = --count;
		}
		upCounter++;
	}

	private static void downCounterClockwise() {
		int count = countNumber();
		leftCounter++;
		for (int i = leftCounter; i < (cordinateY + 1); i++) {
			spiral[i][leftCounter - 1] = --count;
		}
	}

	private static void rightCounterClockwise() {
		int count = countNumber();
		for (int i = leftCounter; i < (cordinateX + 1); i++) {
			spiral[cordinateY][i] = --count;
		}
		cordinateY--;

	}

	private static int countNumber() {
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

	private static boolean yes() {
		if (countNumber() == 1) {
			return true;
		} else {
			return false;
		}
	}
}
