package algorithm.hackerank;

import java.util.Scanner;

public class AbsolutePermutation {
	public static int[] getPermutation(int n, int k) {
		int result[] = new int[n];
		boolean check[] = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			// i-x = k -> x = i-k
			// x-i = k -> x = i+k
			if (i - k >= 1 && i - k <= n && !check[i - k]) {
				result[i - 1] = i - k;
				check[i - k] = true;
			} else if (i + k >= 1 && i + k <= n && !check[i + k]) {
				result[i - 1] = i + k;
				check[i + k] = true;
			} else {
				result = new int[1];
				result[0] = -1;
				return result;
			}
		}

		return result;
	}

	public static void printResult(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int result[] = getPermutation(n, k);
			printResult(result);

		}
		in.close();
	}
}
