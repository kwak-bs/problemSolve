package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050 {
	// BOJ / 11050�� / ���� ��� 1 / ����, ���� / ����� 1
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1][k+1];
		// �Ľ�Į�� ��Ģ�� ����Ѵ�. 
		// n = (n-1) + (n-1) 
		// k = (k-1) + (k)
		System.out.println(BC(n,k));
	}
	
	public static int BC(int n, int k) {
		// ������ ����� ���̸� ����ϱ� ���� �״�� ���
		if(dp[n][k] > 0) {
			return dp[n][k];
		}
		// 0�̰ų� �� ���� ������ ������ 1 
		if(k == 0 || n == k) {
			return dp[n][k] = 1;
		}
		// �Ľ�Į�� ��Ģ 
		return dp[n][k] = BC(n-1,k-1) + BC(n-1, k);
	}
}
