package algorithm.hackerank;

import java.util.Scanner;

public class AppendAndDelete {

	static String appendAndDelete(String s, String t, int k) {
		// Complete this function
		String a, b;
		if (s.length() > t.length()) {
			a = t;
			b = s;
		} else {
			a = s;
			b = t;
		}

		int n = a.length(), m = b.length();
		
		
		int difIndex = n;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				difIndex = i;
				break;
			}
		}

		String result;
		if(n+m <= k) {
			result = "Yes";
		} else if (n - difIndex <= k) {
			k -= (n - difIndex );

			if (m - difIndex <= k) {
				k -= (m - difIndex);

				if (k % 2 == 0) {
					result = "Yes";
				} else {
					if (k >= m * 2) {
						result = "Yes";
					} else {
						result = "No";
					}
				}
			} else {
				result = "No";
			}
		} else {
			result = "No";
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();
		int k = in.nextInt();
		String result = appendAndDelete(s, t, k);
		System.out.println(result);
		in.close();
	}

}
