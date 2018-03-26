package algorithm.hackerank;

import java.util.Scanner;

public class Encryption {
	static void encryption(String s) {
		// Complete this function

		int n = s.length();
		int row = (int) Math.sqrt(n);
		int col = row * row == n ? row : row + 1;

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < col; j++) {
				if (i + j * col >= n)
					break;
				System.out.print(s.charAt(i + j * col));
			}
			System.out.print(" ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		encryption(s);
		in.close();
	}
}
