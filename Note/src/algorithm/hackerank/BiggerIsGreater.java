package algorithm.hackerank;

import java.util.Scanner;

public class BiggerIsGreater {

	static void swap(char[] wc, int i, int j) {
		char tempChar = wc[i];
		wc[i] = wc[j];
		wc[j] = tempChar;
	}

	static String biggerIsGreater(String w) {
		// Complete this function
		char[] wc = w.toCharArray();
		String result = "no answer";

		int n = w.length();
		int startIndex = -1;
		for (int i = n - 1; i >= 1; i--) {
			if (wc[i] > wc[i - 1]) {
				startIndex = i - 1;
				break;
			}
		}
		
		if(startIndex == -1){
			return result;
		}

		for (int i = n - 1; i > startIndex; i--) {
			if (wc[i] > wc[startIndex]) {
				swap(wc, startIndex, i);
				break;
			}
		}

		int i = startIndex + 1, j = n - 1;
		while (i < j) {
			swap(wc, i, j);
			i++;
			j--;
		}

		result = String.valueOf(wc);
		if (result.equals(w)) {
			result = "no answer";
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int a0 = 0; a0 < T; a0++) {
			String w = in.next();
			String result = biggerIsGreater(w);
			System.out.println(result);
		}
		in.close();
	}
}
