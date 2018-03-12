package algorithm.line;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Line3 {
	private static int n;
	private static boolean findFlag = false;

	// cycle을 찾기 위한 DFS 탐색
	private static void dfs(boolean[][] graph, int startNode, int currentNode, int edgeCount, int m) {
		if (edgeCount == m && startNode == currentNode) {
			findFlag = true;
			return;
		} else if (edgeCount >= m) {
			return;
		}

		for (int i = 0; i < n; i++) {
			if (graph[currentNode][i]) {
				if (findFlag)
					break;
				dfs(graph, startNode, i, edgeCount + 1, m);
			}
		}
	}

	// 시간복잡도: cycle의 길이 m이 고정되어 있지 있고, 중복 노드를 허용하기 때문에 NP-complete 문제이다.
	// 따라서 시간복잡도를 구할 수 없음
	private static int findCycle(boolean[][] graph, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j]) {
					if (findFlag)
						break;
					dfs(graph, i, j, 1, m);
				}
			}
		}
		if (findFlag) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		n = Integer.valueOf(input);
		boolean graph[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String matrixInput = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = matrixInput.charAt(j) == '1' ? true : false;
			}
		}
		int m = Integer.valueOf(br.readLine());

		System.out.println(findCycle(graph, m));
	}
}

/*
 * 4 
 * 0111 
 * 1000 
 * 1000 
 * 0010 
 * 3
 */