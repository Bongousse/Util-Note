package algorithm.samsung;

import java.util.Scanner;

public class RepairShop {

	public int process(int N, int M, int K, int A, int B, int a[], int b[], int t[]) {
		int sum = 0;
		
		

		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N, M, K, A, B;

		N = scan.nextInt();
		M = scan.nextInt();
		K = scan.nextInt();
		A = scan.nextInt();
		B = scan.nextInt();

		int a[] = new int[A];
		int b[] = new int[B];
		int t[] = new int[K];

		for (int i = 0; i < A; i++) {
			a[i] = scan.nextInt();
		}

		for (int i = 0; i < B; i++) {
			b[i] = scan.nextInt();
		}

		for (int i = 0; i < K; i++) {
			t[i] = scan.nextInt();
		}

		new RepairShop().process(N, M, K, A, B, a, b, t);
	}
}
