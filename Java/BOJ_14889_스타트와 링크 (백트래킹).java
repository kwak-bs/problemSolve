package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
	// BOJ / 1759�� / ��ŸƮ�� ��ũ / ���Ʈ���� / ��3
	static int board[][];
	static int n, min;
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		
		board = new int [n][n];
		visit = new boolean[n];
		min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		nCr(0,0);
		System.out.println(min);
	}
	
	public static void nCr (int start, int depth) {
		
		if(depth == n/2) {
			diff();
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				nCr(i+1, depth + 1);
				visit[i] = false;
			}
		}
	}
	// �湮�� ���� �湮���� ���� ���� �ּڰ��� ���Ѵ�.
	public static void diff() {
		
		int start = 0;// visit = true �� start��
		int link = 0; // visit = false �� link��
		
		for(int i =0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				if(visit[i] && visit[j]) {
					start += board[i][j];
				}
				else if (!visit[i] && !visit[j]) {
					link += board[i][j];
				}
			}
		}
		
		int temp = Math.abs(start - link);
		
		min = Math.min(temp, min);
	}
}
