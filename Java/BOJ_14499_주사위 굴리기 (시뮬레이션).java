package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {
	// BOJ / 14499�� / �ֻ��� ������ / ���� / ���5
	static int[] dy= {0,0,-1,1}; // ��(0) ��(1) ��(2) ��(3)
	static int[] dx= {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int y = Integer.parseInt(stk.nextToken());
		int x = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int dice[] = new int[7];
		int map[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		stk = new StringTokenizer(br.readLine(), " ");
		while(k-- > 0) {
			int d = Integer.parseInt(stk.nextToken())-1;
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx >= m || nx < 0 || ny >= n) {
				// �ٱ����� �̵���Ű���� �ϴ� ��쿡�� �ش� ����� �����ؾ� �ϸ�, ��µ� �ϸ� �� �ȴ�.
				continue;
			}
			
			// �ֻ��� �̵�
			switch(d) {
			//��
			case 0 : 
				int temp = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = dice[3];
				dice[3] = temp;
				break;
			//��
			case 1 :
				temp = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = dice[4];
				dice[4] = temp;
				break;
			// ��
			case 2 :
				temp = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[2];
				dice[2] = temp;
				break;
			// ��
			case 3 :
				temp = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[5];
				dice[5] = temp;
				break;
			}
			y = ny;
			x = nx;
			
			// 0���� �Ǵ� �� �迭 �� ���� or �ֻ��� �� ����.
			if(map[y][x] == 0) {
				map[y][x] = dice[6];
			}
			else {
				dice[6] = map[y][x];
				map[y][x] = 0;
			}
			// �ֻ��� �� ���� �� ���.
			sb.append(dice[1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
