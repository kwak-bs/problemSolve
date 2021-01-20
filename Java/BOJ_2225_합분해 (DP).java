package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225 {
	//BOJ / 2225�� / �պ��� / DP / ��5
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		// dp[k][n] = n�� ����� ���ؼ� k���� ������ ���� �� �ִ� ����� �� 
		long dp[][] = new long[k+1][n+1];
		
		// k=1�� ���� ������ dp ���� 1�̴�.
		if(k > 0) {
			for(int i=0; i<=n; i++) {
				dp[1][i] = 1;
			}
		}
		// k=2�� ���� ������ dp ���� n+1�̴�.
		if(k > 1) {
			for(int i=0; i<=n; i++) {
				dp[2][i] = i+1;
			}
		}
		
		// ��ȭ�� 
		// �� ���ڸ� ������ �� ���� ������ ���� �� �ִ� ����� �� ���� ���Ѵ�.
		for(int i=3; i<=k; i++) {
			for(int j=0; j<=n; j++) {
				for(int x=0; x<=j; x++)  {
					dp[i][j] += dp[i-1][x] % 1000000000;
				}
			}
		}
		System.out.println(dp[k][n]% 1000000000);
	}
}
