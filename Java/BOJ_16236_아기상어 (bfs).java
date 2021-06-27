package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	// BOJ / 16236�� / �Ʊ� ��� / ����, BFS / ���4
	static int n, map[][], size, sr,sc,time,count;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static ArrayList<fish> al;
	static boolean v[][];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		size = 2;
		StringTokenizer stk;
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j] == 9) {
					sr = i;
					sc = j;
					// �̰� �߿�! 9�� �״�� �״ٰ� ���� ���� Ʋ�ȴ�. �� �ִ� �ʱ� �ڸ��� ������ �̵��� �ڸ��� ������ 0���� �ʱ�ȭ���ش�.
					map[i][j] = 0;
				}
			}
		}
		
		bfs(sr,sc);
	}
	
	public static void bfs(int sr, int sc) {
		
		while(true) {
			Queue<fish> q = new LinkedList<>();
			al = new ArrayList<>(); // ������ �ִ� ����� ����Ʈ 
			v = new boolean[n][n];
			q.add(new fish(sr,sc,0)); // �ʱ� �Ʊ� ��� ��ġ 
			
			while(!q.isEmpty()) {
				fish now = q.poll();
				
				for(int i=0; i<4; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];
					
					if(!(nr >= 0 && nr < n && nc >= 0 && nc < n)) continue;
					if(v[nr][nc]) continue;
					// 1���� ũ�� ������� ����
					if(map[nr][nc] >= 1 && map[nr][nc] < size) {
						// ��� ��ġ ���� 
						q.add(new fish(nr,nc,now.dist+1));
						// ���� �� �ִ� ����� �߰� 
						al.add(new fish(nr,nc,now.dist+1));
						v[nr][nc] = true;
					}
					// ���� �� ������ ������ �� �� �ִ�.
					else if(map[nr][nc] == size || map[nr][nc] == 0) {
						q.add(new fish(nr,nc,now.dist+1));
						v[nr][nc] = true;
					}
				}
			}
			// ���̰� ������ , �� �κ����� breakó�� ���ش�. 
			if(al.size() == 0) {
				System.out.println(time);
				return;
			}
			// ���̰� ������ �Ÿ��� ���� ����� ���̷� ���� 
			fish eat = al.get(0);
			for(int i=1; i<al.size(); i++) {
				if(eat.dist > al.get(i).dist) {
					eat = al.get(i);
				}
				// �Ÿ��� ���� ��� 
				if(eat.dist == al.get(i).dist) {
					// ���� ���� �ִ� ����� 
					if(eat.r > al.get(i).r) {
						eat = al.get(i);
					}
					// ���� ���� �ִ� ����� ���� ���� ������ 
					else if(eat.r == al.get(i).r) {
						// ���� ���ʿ� �ִ� ����� 
						if(eat.c > al.get(i).c) {
							eat = al.get(i);
						}
					}
				}
			}
			// ���� ������� �Ÿ��� �ð��� �߰� 
			time += eat.dist;
			// �Ծ����� 1���� 
			count++;
			// ũ��� ���� ���� ����⸦ ������ size +1
			if(count == size) {
				size++;
				count = 0;
			}
			// ���� ������� �ڸ��� 0 
			map[eat.r][eat.c] = 0;
			// ���� ����� �ڸ��� ��� �̵�
			sr = eat.r;
			sc = eat.c;
		}
	}
	private static class fish {
		int r;
		int c;
		int dist;
		public fish(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
}
