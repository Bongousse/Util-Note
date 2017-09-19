package algorithm.kakao;

public class Problem2 {
	public boolean solution(int[] arr) {
		boolean answer = true;

		int[] check = new int[100001];

		for (int i = 1; i <= 100000; i++)
			check[i] = 0;

		for (int i = 0; i < arr.length; i++) {
			if (check[arr[i]] == 1) {
				answer = false;
				break;
			}
			check[arr[i]] = 1;
		}

		for (int i = 1; i <= arr.length; i++) {
			if (check[i] == 0) {
				answer = false;
				break;
			}
		}

		return answer;
	}
}

/*
 * 길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다. 1부터 n까지 숫자가 중복 없이 한 번씩
 * 들어 있는 경우 true를, 아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.
 * 
 * 제한사항 배열의 길이는 10만 이하입니다. 배열의 원소는 10만 이하의 자연수입니다.
 */