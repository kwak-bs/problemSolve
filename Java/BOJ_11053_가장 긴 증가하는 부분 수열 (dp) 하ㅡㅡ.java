package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
	//BOJ / 11053�� / ���� �� �����ϴ� �κ� ���� / dp / ��2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int n = Integer.parseInt(br.readLine());
		int [] num = new int [n];
		int [] dp = new int[n];
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		// �Է��� 1 �̻����
		dp[0] = 1;
		int temp = num[0];
		int max = 0;
		for(int i=1; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				// ��ȭ�� ���ϱ� ���ô�. �ּ����� �����ϱ� ���� .
				// ���߿� �ٽ� �� Ǯ���.
				// ���� ����ڸ� i�ε����� ���ڸ� �������� �� �� �ε������� ���� �߿��� 
				// ���� ū ������ dp + 1 �ϸ� �ȴ�.
				if(num[i] > num[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
				
			}
		}
		
		for(int i=0; i<n; i++) {
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
	}
}
