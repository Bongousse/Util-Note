package algorithm.hackerank;

import java.util.Scanner;

public class TheGridSearch {
	static String gridSearch(String[] G, String[] P) {
		// Complete this function
		String result = "NO";
		for (int i = 0; i <= G.length - P.length; i++) {
			int startIndex = 0;
			while (true) {
				int index = G[i].indexOf(P[0], startIndex);
				if (index == -1 || "YES".equals(result))
					break;
				for (int j = 1; j < P.length; j++) {
					int nextLineIndex = G[i + j].indexOf(P[j], startIndex);
					if (index == nextLineIndex) {
						if (j == P.length - 1) {
							result = "YES";
						}
					} else {
						break;
					}
				}
				startIndex = index + 1;

			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int R = in.nextInt();
			// int C = in.nextInt();
			String[] G = new String[R];
			for (int G_i = 0; G_i < R; G_i++) {
				G[G_i] = in.next();
			}
			int r = in.nextInt();
			// int c = in.nextInt();
			String[] P = new String[r];
			for (int P_i = 0; P_i < r; P_i++) {
				P[P_i] = in.next();
			}
			String result = gridSearch(G, P);
			System.out.println(result);
		}
		in.close();
	}
}
