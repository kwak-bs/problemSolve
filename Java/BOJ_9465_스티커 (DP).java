package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
	// BOJ / 9465�� / ��ƼĿ / DP/ �ǹ�2
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int [][]nums = new int[2][n+1];
			int [][] dp = new int[2][n+1];
			
			for(int i=0; i<2; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=n; j++) {
					nums[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			dp[0][1] = nums[0][1];
			dp[1][1] = nums[1][1];
			// �� ��ǥ�� �밢�� ��ǥ�� �� ��ǥ�� ���� ���� ���Ͽ� ���� ��ǥ�� �����ش�. 
			for(int i=2; i<=n ;i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + nums[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + nums[1][i];
			}
            System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}
