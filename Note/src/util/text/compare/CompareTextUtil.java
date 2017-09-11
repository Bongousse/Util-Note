package util.text.compare;

import constant.IConstant;
import util.text.read.ReadTextUtil;

public class CompareTextUtil implements IConstant {

	private CompareStringLineDto[] trackSubsequence(int table[][], String a[], String b[]) {
		StringBuilder result = null;
		int i = a.length, j = b.length;
		boolean isDone = false;

		int COMPARE_SIZE = a.length + b.length - table[a.length][b.length];

		CompareStringLineDto[] compareString = new CompareStringLineDto[COMPARE_SIZE];

		for (int idx = 0; idx < COMPARE_SIZE; idx++) {
			compareString[idx] = new CompareStringLineDto();
		}

		int compareIdx = 0;

		while (!isDone) {
			if (!(i == 0 || j == 0) && table[i][j] != table[i][j - 1] && table[i][j] != table[i - 1][j]) {
				if (result == null) {
					result = new StringBuilder();
				} else {
					result.append(NEW_LINE);
				}
				result.append(a[i - 1]);

				i--;
				j--;

				compareString[compareIdx].setCompTypeCd("S");
				compareString[compareIdx].setStrA(a[i]);
				compareString[compareIdx].setStrB(b[j]);
			} else {
				if (j != 0 && table[i][j] == table[i][j - 1]) {
					j--;

					compareString[compareIdx].setCompTypeCd("D");
					compareString[compareIdx].setStrA("");
					compareString[compareIdx].setStrB(b[j]);
				} else if (i != 0 && table[i][j] == table[i - 1][j]) {
					i--;

					compareString[compareIdx].setCompTypeCd("D");
					compareString[compareIdx].setStrA(a[i]);
					compareString[compareIdx].setStrB("");
				}
			}

			compareIdx++;

			if (i == 0 && j == 0) {
				isDone = true;
			}
		}

		return compareString;
	}

	public CompareStringLineDto[] process(String a[], String b[]) {
		int table[][] = new int[a.length + 1][b.length + 1];

		for (int j = 0; j <= b.length; j++) {
			table[0][j] = 0;
		}

		for (int i = 1; i <= a.length; i++) {
			table[i][0] = 0;
			for (int j = 1; j <= b.length; j++) {
				if (a[i - 1].equals(b[j - 1])) {
					table[i][j] = table[i - 1][j - 1] + 1;
				} else {
					table[i][j] = table[i - 1][j] > table[i][j - 1] ? table[i - 1][j] : table[i][j - 1];
				}
			}
		}

		CompareStringLineDto[] result = trackSubsequence(table, a, b);

		return result;
	}

	public static void main(String[] args) {
		ReadTextUtil rtu = new ReadTextUtil();

		StringBuffer text1 = rtu.readText("./input/text1.txt");
		StringBuffer text2 = rtu.readText("./input/text2.txt");

		String[] text1ByNewLine = text1.toString().split(System.lineSeparator());
		String[] text2ByNewLine = text2.toString().split(System.lineSeparator());

		CompareTextUtil ctu = new CompareTextUtil();
		CompareStringLineDto[] result = ctu.process(text1ByNewLine, text2ByNewLine);

		for (int i = result.length - 1; i >= 0; i--) {
			System.out.printf("%s %-70s %-70s\n", result[i].getCompTypeCd(), result[i].getStrA(), result[i].getStrB());
		}
	}
}
