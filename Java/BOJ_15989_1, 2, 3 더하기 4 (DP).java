package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15989 {
	// BOJ / 15989�� / 1,2,3 ���ϱ� 4  / DP / ��1
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		
		int num[] = {1,2,3};
		
		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			int dp[] = new int[n+1];
			dp[0] = 1;
			// 1�� ���, 2�� ���, 3�� ��츦 ���������� ���ϰ� ��ġ�� ��ȭ���� �����.
			for(int i=0; i<num.length; i++) {
				for(int j=num[i]; j<dp.length; j++) {
					dp[j] = Math.max(dp[j], dp[j] + dp[j-num[i]]);
				}
			}
			
			System.out.println(dp[n]);
		}
	}
}
