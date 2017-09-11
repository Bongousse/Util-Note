package util.text.compare;

import constant.IConstant;
import util.text.read.ReadTextUtil;

public class CompareTextUtil implements IConstant {

	private CompareStringLineDto[] compareStringA, compareStringB;
	private int COMPARE_SIZE;

	private String trackSubsequence(int table[][], String a[], String b[]) {
		StringBuilder result = null;
		int i = a.length, j = b.length;
		boolean isDone = false;

		COMPARE_SIZE = a.length + b.length - table[a.length][b.length];

		compareStringA = new CompareStringLineDto[COMPARE_SIZE];
		compareStringB = new CompareStringLineDto[COMPARE_SIZE];

		for (int idx = 0; idx < COMPARE_SIZE; idx++) {
			compareStringA[idx] = new CompareStringLineDto();
			compareStringB[idx] = new CompareStringLineDto();
		}

		int csaIdx = 0;
		int csbIdx = 0;

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

				compareStringA[csaIdx].setStr(a[i]);
				compareStringA[csaIdx].setCompTypeCd("S");
				compareStringB[csbIdx].setStr(b[j]);
				compareStringB[csbIdx].setCompTypeCd("S");
			} else {
				if (j != 0 && table[i][j] == table[i][j - 1]) {
					j--;

					compareStringA[csaIdx].setStr("");
					compareStringA[csaIdx].setCompTypeCd("D");
					compareStringB[csbIdx].setStr(b[j]);
					compareStringB[csbIdx].setCompTypeCd("D");
				} else if (i != 0 && table[i][j] == table[i - 1][j]) {
					i--;

					compareStringA[csaIdx].setStr(a[i]);
					compareStringA[csaIdx].setCompTypeCd("D");
					compareStringB[csbIdx].setStr("");
					compareStringB[csbIdx].setCompTypeCd("D");
				}
			}

			csaIdx++;
			csbIdx++;

			if (i == 0 && j == 0) {
				isDone = true;
			}
		}

		return result.reverse().toString();
	}

	public String process(String a[], String b[]) {
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

		String result = trackSubsequence(table, a, b);

		for (int i = COMPARE_SIZE - 1; i >= 0; i--) {
			System.out.printf("%s %-70s %-70s\n", compareStringA[i].getCompTypeCd(), compareStringA[i].getStr(),
					compareStringB[i].getStr());
		}

		return result;
	}

	public CompareStringLineDto[] generatorCompareStringLineDtoArray(String[] strArray) {
		CompareStringLineDto[] result = new CompareStringLineDto[strArray.length];

		for (int i = 0; i < strArray.length; i++) {
			result[i].setStr(strArray[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		ReadTextUtil rtu = new ReadTextUtil();

		StringBuffer text1 = rtu.readText("./input/text1.txt");
		StringBuffer text2 = rtu.readText("./input/text2.txt");

		String[] text1ByNewLine = text1.toString().split(System.lineSeparator());
		String[] text2ByNewLine = text2.toString().split(System.lineSeparator());

		CompareTextUtil ctu = new CompareTextUtil();
		ctu.process(text1ByNewLine, text2ByNewLine);
	}
}
