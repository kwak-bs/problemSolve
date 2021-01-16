package problemSolve;

import java.util.Scanner;

public class BOJ_11727 {
	//BOJ / 11727�� /  2 x N Ÿ�ϸ�2 / dp / ��3
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long dp [] = new long[n];
		
		dp[0] = 1; // n�� 1�϶�			
		
		if(n > 1) { // n�� 1 �̻��� �� 
			dp[1] = 3; //n�� 2�϶�
		}
		
		for(int i=2; i<n; i++) {
			dp[i] = dp[i-1] + (dp[i-2] * 2);
			dp[i] %= 10007;   // ���⼭ ��� ������� 21��° �ٿ��� �ѹ��� ����Ҷ�� �ϴϱ� ���� ���Գ�
		}
		System.out.println(dp[n-1]);
	}
}
