package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
	// BOJ / 4963�� / ���� ���� / �׷���, BFS, DFS / ��2
	static int[][] map;
	static boolean[][] visit;
	static int [] dy = {0, 0, 1, -1, 1, -1, -1, 1}; // �� , ���»��ϴ밢��
	static int [] dx = {1, -1, 0, 0, 1, -1, 1, -1}; // ��,  ���»��ϴ밢��

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int w = Integer.parseInt(st.nextToken()); // ��
			int h = Integer.parseInt(st.nextToken()); // ��
			int count = 0;
			
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new int[1001][1001];
			visit = new boolean[1001][1001];
			
			// map �Է�
			for(int i=1; i<=h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1 �߽߰� dfs, count++
			for(int i=1; i<=h; i++) {
				for(int j=1; j<=w; j++) {
					if(map[i][j] == 1 && !visit[i][j]) { 
						dfs(i,j,w,h);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	static void dfs(int y, int x, int w, int h) {
		
		visit[y][x] = true;
		
		for(int i =0; i<dx.length; i++) {
			int yy = dy[i] + y;
			int xx = dx[i] + x;
			
			if(xx > 0 && yy > 0 && xx <= w && yy <= h) {
				if(map[yy][xx] == 1 && !visit[yy][xx]) {
					dfs(yy, xx,w,h);
				}
			}
			
		}
	}
}
