package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10026 {
	//BOJ / 10026�� / ���ϻ���/ �׷��� / ��5
	
	static int n;
	static char map [][];
	static boolean visit [][];
	static int dy[] = { -1, 1, 0, 0 }; 
	static int dx[] = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visit = new boolean[n][n];
		int count = 0;
		
		// map �Է�
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// ����
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j]) { // �湮���� ������ ã�Ƽ� ����� �Բ� �Ѱ���
					count++;
					dfs(i,j, map[i][j]); 
				}
			}
		}
		System.out.print(count + " ");
		
		count = 0 ; // �ʱ�ȭ 
		visit = new boolean[n][n]; // �ʱ�ȭ
		
		// ���ϻ�������� map �ٲٱ�
		changeMap();
		
		// ���ϻ���
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j]) { // �湮���� ������ ã�Ƽ� ����� �Բ� �Ѱ���
					count++;
					dfs(i,j, map[i][j]); 
				}
			}
		}
		System.out.print(count);
	}
	
	public static void dfs(int y, int x, char color) {
		
		if(visit[y][x]) { 
			return;
		}
		visit[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if(!visit[ny][nx] && map[ny][nx] == color) {
					dfs(ny,nx,map[ny][nx]);
				}
			}
		}
	}
	
	// ���ϻ���� map
	public static void changeMap() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
	}
}
