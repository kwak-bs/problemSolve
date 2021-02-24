package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14391 {
	// BOJ / 14391�� / ���� ���� / ���Ʈ���� / ���3
	
	static int y,x,ans;
	static int board[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk= new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		
		board = new int[y][x];
		visit = new boolean[y][x];
		
		for(int i=0; i<y; i++) {
			String s = br.readLine();
			for(int j=0; j<x; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		
		recursion(0,0);
		
		System.out.println(ans);
	}
	
	public static void recursion(int yy, int xx) {
		
		//�˻縦 �� ������ check
		if(yy >= y) {
			check();
			return;
		}
		// �� ���� �� �˻�������, ���� ������
 		if(xx >= x) {
			recursion(yy+1, 0);
			return;
		}
		
		//�ش� ��ǥ ����
		visit[yy][xx] = true;
		recursion(yy, xx+1);
		//�ش� ��ǥ �̼���
		visit[yy][xx] = false;
		recursion(yy,xx+1);
	}
	
	// true = ����, false = ����
	public static void check() {
		
		int sum = 0;
		// ���� 
		for(int i=0; i<y; i++) {
			int temp = 0;
			for(int j=0; j<x; j++) {
				if(visit[i][j]) {
					temp *= 10; // ���ӵ� ��� �ڸ��� ������
					temp += board[i][j];
				}
				else {
					sum += temp;
					temp = 0;
				}
			}
			// �� ���� ���ΰ� �� ��� ����� ����
			sum += temp;
		}
		
		//���� 
		for(int i=0; i<x; i++) {
			int temp = 0;
			for(int j=0; j<y; j++) {
				if(!visit[j][i]) {
					temp *= 10;
					temp += board[j][i];
				}
				else {
					sum += temp;
					temp = 0;
				}
			}
			// �� ���� ���ΰ� �� ��� ����� ����.
			sum+= temp;
		}
		
		ans = Math.max(sum, ans);
	}
}
