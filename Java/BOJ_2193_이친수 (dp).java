package problemSolve;

import java.util.Scanner;

public class BOJ_2193 {
	//BOJ / 2193�� / ��ģ��  / dp  / ��3
	static int n;
	static long dp[];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dp = new long[n];
		
		// n�� 1�� ���.
		if(n > 0) {
			dp[0] = 1;
		}
		
		// n�� 2 �̻��� ���
		if(n > 1) {
			dp[1] = 1;
			// ��ȭ�� �������� �Ǻ���ġ 
			for(int i=2; i<n; i++) {
				dp[i] = dp[i-2] + dp[i-1];
			}

		}
		System.out.println(dp[n-1]);
	}
	
}
