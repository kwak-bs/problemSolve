package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1309 {
	//BOJ / 1309�� / ������ / dp / ��1
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int map[][] = new int[n][2];
		int dp[] = new int[n+1];
		dp[0] = 1;
	
		if(n >= 1) {
			dp[1] = 3;
		}
		// 1) X X => dp[n-1]
		// 2) X 0 | ? ?, 0 X | ? ? -> 2*dp[n-1] 
		// 3) X 0 | X 0, 0 X | 0 X -> dp[n-1] - dp[n-2]
		// ��, 1) + 2) - 3) => 2*DP[n-1] + DP[n-2] 
		// 3)�� ���� �� ĭ�� �ϳ��� ��ģ �� �迭�ϵ�, ù �ٿ� �ϳ��� �ְ� �ϴ� �迭�� �������̱� ������
		// ��ü DP[n-1]���� �ϳ��� ������ DP[n-2]�� ���ش�.
		for(int i=2; i<=n; i++) {
			dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
		}
		System.out.println(dp[n]);
	}
}
