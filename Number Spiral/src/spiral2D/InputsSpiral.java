package spiral2D;

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
			break;
		}

		while (true) {
			try {
				collums = Integer.parseInt(JOptionPane.showInputDialog("Unesite broj stupaca"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unesite cijeli broj");
				continue;
			}
			break;
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

		switch (startingPoint) {
		case 1:
			UpperLeftCorner.direction(rows, collums);
			break;
		case 2:
			LowerLeftCorner.direction(rows, collums);
			break;
		case 3:
			UpperRightCorner.direction(rows, collums);
			break;
		case 4:
			LowerRightCorner.direction(rows, collums);
			break;
		case 5:
			Middle.direction(rows, collums);
			break;
		default:
			LowerRightCorner.direction(rows, collums);
			break;
		}
	}
}
