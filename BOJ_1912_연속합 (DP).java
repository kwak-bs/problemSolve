package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
	// BOJ / 1912�� / ������ / dp / ��2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int n = Integer.parseInt(br.readLine());
		int num[] = new int[n];
		int dp[] = new int[n];
		
		stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		dp[0] = num[0];
		int max = Integer.MIN_VALUE;
		
		if( dp[0] > max) {
			max = dp[0];
		}
		
		// ó���� ���� ������ Ǯ���ٰ� �ð��ʰ���. 
		// �����غ��� ���� ���߷����� ����� �ʿ䰡 ���� ��������. �ð������� 1�ʸ� ���߷��� ����. 2�ʿ��� �ȵ�.
		for(int i=1; i<n; i++) {	
			dp[i] = Math.max(num[i], dp[i-1] + num[i]);	
			if(dp[i]> max) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
	}
}
