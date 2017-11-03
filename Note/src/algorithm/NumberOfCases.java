package algorithm;

import java.util.Scanner;

public class NumberOfCases {

	private int cnt = 0;
	private boolean[] check;

	public void dfs(int n, int k, int[] number, int sum) {
		if (sum == k) {
			cnt++;
			return;
		} else if (sum > k) {
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				check[i] = true; // 중복 선택되지 않도록 체크
				dfs(n, k, number, sum + number[i]);
				check[i] = false; // 중복 체크 해제
			}
		}
	}

	public void process(int testcaseNumber, int n, int k, int[] number) {
		cnt = 0;
		check = new boolean[n];
		dfs(n, k, number, 0);
		System.out.println("#" + testcaseNumber + " " + cnt / 2);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			int k = scan.nextInt();

			int[] number = new int[n];
			for (int j = 0; j < n; j++) {
				number[j] = scan.nextInt();
			}

			new NumberOfCases().process(i + 1, n, k, number);
		}

		scan.close();
	}
}
