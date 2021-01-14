package problemSolve;

import java.util.Scanner;

public class BOJ_2133 {
	// BOJ / 1912�� / Ÿ�� ä��� / dp / ��2
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		

		int dp[] = new int[n+1];


		if(n % 2 == 0) {
			dp[2] = 3;
			// dp[4]�� ��� dp[0]�� �����ϱ� ������ dp[0]�� �����������
			// ����, ������ Ư�� ���̽� 2������ �����ִ� ���ҵ� ��.
			dp[0] = 1;  

			for(int i=4; i<=n; i+=2) {
				dp[i] = dp[i-2] * 3;
				for(int j=0; j<i-2; j+=2) {
					dp[i] += dp[j] * 2; 					
				}
			}
			

		}	
		System.out.println(dp[n]);

	}
}
