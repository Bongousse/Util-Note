package algorithm;

public class RecursiveStringRemove {

	static int result = 0;
	static boolean isDone = false;

	public static void f(String str) {
		if (isDone) {
			return;
		}

		if (str.isEmpty()) {
			result = 1;
			isDone = true;
		}

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				int sameEndIndex = i + 1;
				for (int j = i + 1; j < str.length(); j++) {
					if (j == str.length() - 1) {
						sameEndIndex = j;
						break;
					}
					if (str.charAt(j) != str.charAt(j + 1)) {
						sameEndIndex = j;
						break;
					}
				}

				String nextStr = str.substring(0, i) + str.substring(sameEndIndex + 1, str.length());
				f(nextStr);
			}
		}
	}

	public static void main(String[] args) {
		String str = "aaaaabbaaaaaaaaabbbaaaaaaaabaaaaabbaaaa";
		f(str);
		System.out.println(result);
	}
}
