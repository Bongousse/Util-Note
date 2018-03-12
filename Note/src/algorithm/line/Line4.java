package algorithm.line;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Line4 {

	public static class LruCache {
		public LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();

		// add나 get된지 오래된 항목을 자료구조에서 제거
		// 시간복잡도: O(1)
		public void evict() {
			// LinkedHashMap의 첫번째 노드는 get, add를 가장 먼저 한 노드
			Integer lastRecentlyUsedKey = cache.entrySet().iterator().next().getKey();
			cache.remove(lastRecentlyUsedKey);
		}

		// 자료구조에 key, value에 해당하는 항목을 추가한다.
		// 시간복잡도: O(1)
		public void add(Integer key, Integer value) {
			if (cache.containsKey(key)) {
				// 이미 캐쉬에 key값이 저장되어 있는 경우 기존 노드를 삭제 후 마지막 노드에 저장
				Integer origianlValue = cache.remove(key);
				cache.put(key, (Integer) origianlValue + (Integer) value);
			} else {
				// 새로운 key값인 경우 마지막 노드에 저장
				cache.put(key, value);
			}
		};

		// key에 해당하는 항목을 찾아 그 value를 반환. 항목이 없는 경우 Exception
		// 시간복잡도: O(1)
		public Integer get(Integer key) {
			if (cache.containsKey(key)) {
				// 기존 노드를 삭제 후 마지막 노드에 저장
				Integer origianlValue = cache.remove(key);
				cache.put(key, origianlValue);
				return cache.get(key);
			} else {
				throw new RuntimeException("Not exist. key: " + key);
			}
		};

		// key에 해당하는 항목을 찾아 그 value를 반환하고 항목을 자료구조에서 제거. 항목이 없는 경우 Exception
		// 시간복잡도: O(1)
		public Integer remove(Integer key) {
			if (cache.containsKey(key)) {
				return cache.remove(key);
			} else {
				throw new RuntimeException("Not exist. key: " + key);
			}
		};
	};

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LruCache cache = new LruCache();

		while (true) {
			String input = br.readLine();

			String operation = input.split(" ")[0];
			Integer key, value;

			try {
				switch (operation) {
				case "evict":
					cache.evict();
					break;
				case "add":
					key = Integer.valueOf(input.split(" ")[1]);
					value = Integer.valueOf(input.split(" ")[2]);
					cache.add(key, value);
					break;
				case "get":
					key = Integer.valueOf(input.split(" ")[1]);
					System.out.println(cache.get(key));
					break;
				case "remove":
					key = Integer.valueOf(input.split(" ")[1]);
					System.out.println(cache.remove(key));
					break;
				case "exit":
					return;
				}
			} catch (Exception e) {
				System.out.println("-1");
			}
		}
	}
}
