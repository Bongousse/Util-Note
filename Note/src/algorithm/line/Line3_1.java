package algorithm.line;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Line3_1 {
	
	// 플로이드 알고리즘
	// 모든 노드에서 다른 노드까지 걸리는 최소 거리 구하기
	// 시간복잡도: O(n^3)
	public static int[][] floyd(boolean graph[][]) {
		int n = graph.length;
		int distanceGraph[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					distanceGraph[i][j] = 0;
				else
					distanceGraph[i][j] = graph[i][j] ? 1 : Integer.MAX_VALUE;
			} 
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (distanceGraph[i][j] > distanceGraph[i][k] + distanceGraph[k][j]
							&& (distanceGraph[i][k] != Integer.MAX_VALUE && distanceGraph[k][j] != Integer.MAX_VALUE)) {
						distanceGraph[i][j] = distanceGraph[i][k] + distanceGraph[k][j];
					}
				}
			}
		}

		return distanceGraph;
	}

	// 
	public static boolean dfs(int[][] distanceGraph, int startNodeIndex, int currentNodeIndex, int distanceSum, int m) {
		if (startNodeIndex == currentNodeIndex && distanceSum == m) {
			// 첫번째 출발노드와 끝 노드가 같은 사이클을 찾았고 길이가 정확히 m일 때 true 리턴
			return true;
		} else if (distanceSum >= m) {
			// 현재까지 길이의 총합이 m 이상일 때 false 리턴 (가지치기)
			return false;
		}

		for (int i = 0; i < distanceGraph.length; i++) {
			if (distanceGraph[currentNodeIndex][i] != 0 && distanceGraph[currentNodeIndex][i] != Integer.MAX_VALUE) {
				if (dfs(distanceGraph, startNodeIndex, i, distanceSum + distanceGraph[currentNodeIndex][i], m)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean findCycle(boolean graph[][], int m) {
		int[][] distanceGraph = floyd(graph);

		// 0~n-1번 인덱스 노드에서 시작
		for (int i = 0; i < graph.length; i++) {
			if (dfs(distanceGraph, i, i, 0, m)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.valueOf(input);
		boolean graph[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String matrixInput = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = matrixInput.charAt(j) == '1' ? true : false;
			}
		}
		int m = Integer.valueOf(br.readLine());

		System.out.println(findCycle(graph, m) ? 1 : 0);
	}
}
