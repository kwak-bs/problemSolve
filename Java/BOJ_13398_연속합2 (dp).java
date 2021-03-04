package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13398 {
	// BOJ / 13398�� / ������ 2 / dp / ���5
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int num[] = new int[n];
		int dp[][] = new int[n][2];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		int max = num[0];
		dp[0][0] = num[0];
		dp[0][1] = dp[0][0];
		
		// dp[i][0] = �ش� ���� �������� ���� ���¿����� �ִ� �� 
		// dp[i][1] = �ش� �������� �ϳ��� ������ ���¿����� �ִ� ��
		for(int i=1; i<n; i++) {
			dp[i][0] = Math.max(num[i], dp[i-1][0] + num[i]);
			if(max < dp[i][0]) {
				max = dp[i][0];
			}
		}
	
		for(int i=1; i<n; i++) {
			dp[i][1] = Math.max(dp[i-1][1] +num[i], dp[i-1][0]);
			if(max <dp[i][1]) {
				max = dp[i][1];
			}
		}
		
		System.out.println(max);
	}
}
