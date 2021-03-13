package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16931 {
	// BOJ / 16931�� / �ѳ��� ���ϱ� / ���� / �ǹ�3
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int y = Integer.parseInt(stk.nextToken());
		int x = Integer.parseInt(stk.nextToken());
		// 101��° ��ġ�� Ž���� �ؾ��ϹǷ�
		int map[][] = new int[102][102];
		
		for(int i=1; i<=y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// ����� �Ʒ����� ���� �����ش�. 
		int ans = 2 *y*x;
		
		// ���� ���� �̿��ؼ� ������ �����ش�. 
		for(int i=1; i<=y; i++) {
			for(int j=1; j<=x; j++) {
				for(int k=0; k<4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if(map[i][j] - map[ny][nx] > 0 ) {
						ans += map[i][j] - map[ny][nx];
					}
				}
			}
		}
		System.out.println(ans);
	}
}
