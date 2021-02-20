package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15661 {
	// BOJ / 1759�� / ��ũ�� ��ŸƮ / ���Ʈ���� / ��1

	static int board[][];
	static int n, min;
	static boolean visit[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		
		board = new int [n][n];
		min = Integer.MAX_VALUE;
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		recursion(0);
		
		System.out.println(min);
	}
	
	public static void recursion(int depth) {
		
		// depth�� n���� �Ѵ�. 
		// ù n���� ��Ϳ��� ��� visit �迭�� true�� �������� 
		// �� ���ĺ��ʹ� false�� �ϳ��� ���鼭 �ּڰ��� ���ϱ� ����.
		// �ּڰ��� ���ϸ� �Ǳ� ������ ù n���� ��Ϳ� ��� visit �迭�� true�� ���� ���x
		if(depth == n) {
			diff();
			return;
		}
		
		visit[depth] = true;
		recursion(depth + 1);
		visit[depth] = false;
		recursion(depth + 1);
	}
	
	public static void diff() {
		int start = 0;
		int link = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {

				if(visit[i] && visit[j]) {
					start += board[i][j]+board[j][i];
				}
				else if(!visit[i] && !visit[j]) {
					link += board[i][j]+board[j][i];
				}
			}
		}
		
		int temp = Math.abs(start - link);
		
		min = Math.min(min, temp);
	}
}
