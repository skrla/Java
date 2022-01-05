package adventcalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01part2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("/home/skrla/Downloads/input.txt"));
		int x = 0;
		int y;
		int times = 0;
		int count = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		
		while(scanner.hasNextInt()) {
			y = scanner.nextInt();
			if (times == 0) {
				a = y;
				times++;
			} else if (times == 1) {
				b = y;
				times++;
			} else if (times == 2) {
				c = y;
				times++;
			} else {
				times = a + b + c;
				if (times > x) {
					count++;
				}
				a = b;
				b = c;
				c = y;
				x = times;
			}
			}
		
		System.out.println(count);
		
		}
}
