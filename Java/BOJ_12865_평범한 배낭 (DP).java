package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
	// BOJ / 12865�� / ����� �賶 / dp / ���5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int dp[][] = new int[n+1][k+1];
		int w[] = new int[n+1];
		int v[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			w[i] = Integer.parseInt(stk.nextToken());
			v[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				// �⺻������ �� ������ ��ġ�� �����Ѵ�. 
				dp[i][j] = dp[i-1][j];
				if(j - w[i] >= 0) {
					// �ڽ��� ��ġ��  
					// ���� ���Կ��� �ڽ��� ���Ը� ���� �� ���� ������ ��ġ + �ڽ��� ��ġ �� ���Ѵ�.
					dp[i][j] = Math.max(dp[i][j], v[i] + dp[i-1][j-w[i]]);
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
