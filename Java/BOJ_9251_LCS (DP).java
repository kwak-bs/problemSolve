package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
	// BOJ / 9251�� / LCS / DP / ���5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char a[] = br.readLine().toCharArray();
		char b[] = br.readLine().toCharArray();
		
		int dp[][] = new int[a.length+1][b.length+1];
		
		
		for(int i=1; i<=a.length; i++) {
			for(int j=1; j<=b.length; j++) {
				// ���� ����(i)�� ������ ���� ���ڿ�[i-1][j-1]�� LCS + 1
				// ��? ���� i�� A�̰�, ���� ���ڰ� {A,C} , {C}�̸� 
				// {A,C} + A , {C} + A �� ���̱� ����.
				if(a[i-1] == b[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				// �ٸ��� 
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[a.length][b.length]);
	}
}
