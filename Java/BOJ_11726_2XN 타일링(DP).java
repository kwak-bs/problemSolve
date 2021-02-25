package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
	// BOJ / 11726�� / 2��n Ÿ�ϸ� / DP / ��3
	
	static int dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new int [n+1];
		
		dp[n] = recursion(n);
		
		System.out.println(dp[n]);
	}
	
	public static int recursion(int n) {
		
		if(n == 1 || n == 0) return 1;
		if(dp[n] > 0) return dp[n];
		
		dp[n] = recursion(n-2) + recursion(n-1);
		dp[n] %= 10007;
		
		return dp[n];
	}
}
