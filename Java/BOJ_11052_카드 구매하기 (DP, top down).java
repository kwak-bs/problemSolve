package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
	// BOJ / 11052�� / ī�� �����ϱ� / DP / ��1
	
	static int p[];
	static int dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		p = new int[n+1];
		dp = new int[n+1];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=1; i<p.length; i++) {
			p[i] = Integer.parseInt(stk.nextToken());
		}
		dp[1] = p[1]; 
		System.out.println(recursion(n));
	}
	
	public static int recursion(int n) {
		int max = 0;
		if(n == 1) return p[1];
		if(dp[n] > 0) return dp[n];
		
		// ���ݸ� Ž���ϸ� ��.
		for(int i=1; i<=n/2; i++) {
			int temp = recursion(n-i) + recursion(i);
			if(max > temp) {
				continue;
			}
			// ó�� ���ĺ��ʹ� temp�� �� ũ�� temp�� ����
			if(i > 1)dp[n] = temp;
			// ó���� p[n]�� ��
			if(i == 1)dp[n] = Math.max(p[n], temp);
			// ������� ���� �̹� temp�� �� ū ��Ȳ�� 
			max = dp[n]; 
		}
		return dp[n];
	}
}
