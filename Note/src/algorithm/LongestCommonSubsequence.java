package algorithm;

public class LongestCommonSubsequence {
	
	private String trackSubsequence(int table[][], String a, String b){
		StringBuilder result = new StringBuilder();
		int i = a.length(), j = b.length();
		boolean isDone = false;
		
		while(!isDone){
			if(table[i][j] != table[i][j-1] && table[i][j] != table[i-1][j]){
				result.append(a.charAt(i-1));
				i--;
				j--;
			} else if(table[i][j] == table[i][j-1]){
				j--;
			} else if(table[i][j] == table[i-1][j]){
				i--;
			} 
			
			if (table[i][j] == 0) {
				isDone = true;
			}
		}
		
		return result.reverse().toString();
	}
	
	public String process(String a, String b){
		int table[][] = new int[a.length()+1][b.length()+1];
		
		for(int j=0;j<=b.length();j++){
			table[0][j] = 0;
		}
		
		for(int i=1;i<=a.length();i++){
			table[i][0] = 0;
			for(int j=1;j<=b.length();j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					table[i][j] = table[i-1][j-1] + 1;
				} else {
					table[i][j] = table[i-1][j] > table[i][j-1] ? table[i-1][j] : table[i][j-1];
				}
			}
		}
		
		String result = trackSubsequence(table, a, b);
		
		return result;
	}
	
	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String a = "CAPCAK";
		String b = "ACAYKP";
		System.out.println(lcs.process(a, b));
	}
}
