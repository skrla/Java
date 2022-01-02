package spiral2d;

public class Output {

	public static void printingSpiral(int[][] spiral) {
		for (int i = 0; i < spiral.length; i++) {
			for (int j = 0; j < spiral[i].length; j++) {
				if (spiral[i][j] >= 100) {
					System.out.print(spiral[i][j] + " ");
				} else if(spiral[i][j] >= 10) {
					System.out.print(" " + spiral[i][j] + " ");
				} else {
					System.out.print("  " + spiral[i][j] + " ");
				}
				}
			System.out.println();
			}
		
	}

}
