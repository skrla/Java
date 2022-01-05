package adventcalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("/home/skrla/Downloads/input.txt"));
		int x = Integer.MIN_VALUE;
		int y;
		int times = 0;
		int count = 0;
		
		while (scanner.hasNextInt()) {
			y = scanner.nextInt();
			if (times == 0) {
				x = y;
				times++;
			} else if (y > x) {
				count++;
				x = y;
			} else {
				x = y;
			}
		}
		
		System.out.println(count);
	}

}
