package spiral2d;

import javax.swing.JOptionPane;

public class Output {

	public static void printingSpiral(int[][] spiral) {
		for (int i = 0; i < spiral.length; i++) {
			for (int j = 0; j < spiral[i].length; j++) {
				if (spiral[i][j] >= 100) {
					System.out.print(spiral[i][j] + " ");
				} else if (spiral[i][j] >= 10) {
					System.out.print(" " + spiral[i][j] + " ");
				} else {
					System.out.print("  " + spiral[i][j] + " ");
				}
			}
			System.out.println();
		}

		var thanks = JOptionPane.showConfirmDialog(null, "Želite li ispisati još jednu spiralu?", null,
				JOptionPane.YES_NO_OPTION);

		System.out.println("");

		switch (thanks) {
		case JOptionPane.YES_OPTION -> InputsSpiral.main(null);
		default -> System.out.println("Hvala, doviđenja!");
		}
	}
}
