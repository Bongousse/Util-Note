package algorithm.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] table = new int[n];
		for (int i = 0; i < n; i++) {
			table[i] = sc.nextInt();
		}
		sc.close();

		Arrays.sort(table);

		int result = 0, temp = 0;
		for (int i = 0; i < n; i++) {
			result = result + temp + table[i];
			temp += table[i];
		}
		
		System.out.println(result);
		
	}
}

/*
1
1 + 2
1 + 2 + 3
1 + 2 + 3 + 3
1 + 2 + 3 + 3 + 4

*/
