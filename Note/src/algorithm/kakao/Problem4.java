package algorithm.kakao;

public class Problem4 {
	public static int solution(int[][] board) {
		int answer = 0;

		int n = board.length;
		int m = board[0].length;

		int[][] table = new int[n][m];
		int[][] table2 = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j == 0)
					table[i][j] = board[i][j];
				else if (board[i][j] == 1)
					table[i][j] = table[i][j - 1] + board[i][j];
				else
					table[i][j] = 0;

				if (i == 0)
					table2[i][j] = board[i][j];
				else if (board[i][j] == 1)
					table2[i][j] = table2[i - 1][j] + board[i][j];
				else
					table2[i][j] = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (table[i][j] > answer && i + table[i][j] - 1 < n) {
					boolean error = false;
					for (int k = 0; k < table[i][j]; k++) {
						if (table[i + k][j] < table[i][j]) {
							error = true;
							break;
						}
					}
					if (!error)
						answer = table[i][j];
				}

				if (table[i][j] > answer && i - table[i][j] + 1 >= 0) {
					boolean error = false;
					for (int k = 0; k < table[i][j]; k++) {
						if (table[i - k][j] < table[i][j]) {
							error = true;
							break;
						}
					}
					if (!error)
						answer = table[i][j];
				}
			}
		}

		answer *= answer;
		return answer;
	}

	public static void main(String[] args) {
		// int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, {
		// 0, 0, 1, 0 } };
		// int[][] board = { { 1 } };
		// int[][] board = { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } };
		int[][] board = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1 } };
		System.out.println(solution(board));
	}
}

/*
 * 1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 표에서 1로 이루어진 가장 큰
 * 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)
 * 
 * 예를 들어
 * 
 * 1 2 3 4 0 1 1 1 1 1 1 1 1 1 1 1 0 0 1 0 가 있다면 가장 큰 정사각형은
 * 
 * 1 2 3 4 0 1 1 1 1 1 1 1 1 1 1 1 0 0 1 0 가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.
 * 
 * 제한사항 표(board)는 2차원 배열로 주어집니다. 표(board)의 행(row)의 크기 : 1000 이하의 자연수 표(board)의
 * 열(column)의 크기 : 1000 이하의 자연수 표(board)의 값은 1또는 0으로만 이루어져 있습니다.
 */