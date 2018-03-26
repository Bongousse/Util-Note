package algorithm.hackerank;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
	static void extraLongFactorials(int n) {
		// Complete this function
		BigInteger result = BigInteger.ONE;

		for (int i = 1; i <= n; i++) {
			result = result.multiply(new BigInteger(String.valueOf(i)));
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		extraLongFactorials(n);
		in.close();
	}
}
