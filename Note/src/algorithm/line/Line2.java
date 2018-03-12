package algorithm.line;

import java.util.Scanner;

public class Line2 {

	private static void print(int[] byteArray) {
		for (int i = 0; i < byteArray.length; i++) {
			System.out.print(byteArray[i] + " ");
		}
		System.out.println();
	}

	private static void memcpy(int[] byteArray, int dest, int src, int size) {
		if (size < 0) {
			throw new RuntimeException();
		}

		int n = byteArray.length;
		for (int i = src; i < src + size; i++) {
			if (dest + i > n) {
				throw new RuntimeException();
			}
			byteArray[dest + i] = byteArray[i];
		}

		print(byteArray);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int c = scan.nextInt();
		int[] byteArray = new int[c];
		for (int i = 0; i < c; i++) {
			byteArray[i] = scan.nextInt();
		}
		int dest = scan.nextInt();
		int src = scan.nextInt();
		int size = scan.nextInt();

		try {
			memcpy(byteArray, dest, src, size);
		} catch (Exception e) {
			print(byteArray);
		}

		scan.close();
	}
}
