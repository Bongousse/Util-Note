package algorithm.samsung;

import java.util.Scanner;

public class SupplyRoute {

	public int process(int N, int table[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 && j == 0) {
					table[i][j] = table[i][j];
				} else if (i == 0) {
					table[i][j] += table[i][j - 1];
				} else if (j == 0) {
					table[i][j] += table[i - 1][j];
				} else if (table[i][j - 1] > table[i - 1][j]) {
					table[i][j] += table[i - 1][j];
				} else {
					table[i][j] += table[i][j - 1];
				}
			}
		}

		return table[N - 1][N - 1];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = scan.nextInt();
			int table[][] = new int[N][N];

			for (int i = 0; i < N; i++) {
				String inputTemp = scan.next();
				for (int j = 0; j < N; j++) {
					table[i][j] = inputTemp.charAt(j) - 48;
				}
			}

			System.out.println("#" + t + " " + new SupplyRoute().process(N, table));
		}
	}
}
