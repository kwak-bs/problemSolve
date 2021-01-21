package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520 {
	//BOJ / 1520�� / ������ �� / DP / ��4
	static int [] dy = {1,-1,0,0}; // ����
	static int [] dx = {0,0,1,-1}; // �¿�
	static int y,x;
	static int [][] map, dp;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		
		map = new int[y][x];
		dp = new int[y][x];
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				dp[i][j] = -1; // �湮 ó���� ���� -1����
			}
		}
		


		System.out.println(dfs(0,0));
//		for(int i=0; i<y; i++) {
//			for(int j=0; j<x; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	
	public static int dfs(int yy, int xx ) {
		
		// ���������� ���������� 1�� ����.
		if(yy == y-1 && xx == x-1) {
			return 1;
		}
		
		// �̹� �湮�� ���̶�� �湮�� ���� ���� ����.
		if(dp[yy][xx] != -1) {
			return dp[yy][xx];
		}
		
		// �湮ó��
		dp[yy][xx] = 0;
		
		for(int i=0; i<4; i++) {
			int ny = yy + dy[i];
			int nx = xx + dx[i];
			
			if(ny>=0 && ny <y && nx >=0 && nx <x ) {
				// ���� ������ ���̰� ������ �� �� �־��ְ� ��ȯ���� �����ش�. 
				if(map[yy][xx] > map[ny][nx] ) {
					dp[yy][xx] += dfs(ny,nx);
				}
			}
		}
		// ��Ʈ��ŷ �� ������ �ٽ� �����ֱ� ����.
		return dp[yy][xx];
	}
}
