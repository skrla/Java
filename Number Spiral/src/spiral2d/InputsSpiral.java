package spiral2d;

import javax.swing.JOptionPane;

public class InputsSpiral {

	public static void main(String[] args) {

		int rows;
		int collums;
		int startingPoint;

		while (true) {
			try {
				rows = Integer.parseInt(JOptionPane.showInputDialog("Unesite broj redaka"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unesite cijeli broj");
				continue;
			}
			if (0 < rows) {
				break;
			} else if (JOptionPane.CANCEL_OPTION == rows) {
				continue;
			} else {
				JOptionPane.showMessageDialog(null, "Unesite cijeli broj veći od 0");
				continue;
			}

		}

		while (true) {
			try {
				collums = Integer.parseInt(JOptionPane.showInputDialog("Unesite broj stupaca"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unesite cijeli broj");
				continue;
			}
			if (0 < collums) {
				break;
			} else if (JOptionPane.CANCEL_OPTION == collums) {
				continue;
			} else {
				JOptionPane.showMessageDialog(null, "Unesite cijeli broj veći od 0");
				continue;
			}
		}

		while (true) {
			try {
				startingPoint = Integer.parseInt(JOptionPane.showInputDialog(
						"Unesite točku polaska: \n1 - Gornji lijevi kut \n2 - Donji lijevi kut \n3 - Gornji desni kut \n4 - Donji desni kut \n5 - Sredina"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unesite jedan od ponuđenih brojeva!");
				continue;
			}
			if (0 < startingPoint && startingPoint < 6) {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Unesite jedan od ponuđenih brojeva!");
			}
		}
		
		var goingDirection = JOptionPane.showConfirmDialog(null, "Želite da spirala ide u smjeru kazaljki na satu?",
				null, JOptionPane.YES_NO_OPTION);
		
		boolean direction = goingDirection == JOptionPane.YES_OPTION ? true : false;

		switch (startingPoint) {
		case 1 -> UpperLeftCorner.direction(rows, collums, direction);
		case 2 -> LowerLeftCorner.direction(rows, collums, direction);
		case 3 -> UpperRightCorner.direction(rows, collums, direction);
		case 4 -> LowerRightCorner.direction(rows, collums, direction);
		case 5 -> Middle.direction(rows, collums, direction);
		}
	}
}
