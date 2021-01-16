package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1890 {
	// BOJ / 1890�� / ���� / dp / ��2
	// bfs�� Ǯ���ٰ� �ð��ʰ� ���� ����. �� �� �ð� 
	static boolean visit[][];
	static int n;
	static int map[][];
	static long dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new long[n][n];

		for(int i=0; i<n; i++) {
			stk= new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		dp[0][0] = 1;

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// �� ���ִ� �Ÿ� ����
				int next = map[i][j];
				// ������ ��ǥ�� �ǳʶڴ�.
				if(i == n-1 && j == n-1) {
					continue;
				}
				// y���� ���� �ȿ� ������, ���� dp ���� ���� dp���� ���Ѵ�.
				if(next + i < n) {
					dp[next+i][j] += dp[i][j];
				}
				// ��������
				if(next + j < n) {
					dp[i][next+j] += dp[i][j];
				}
			}
		}
		System.out.println(dp[n-1][n-1]);

	}
}
