package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
	// BOJ / 2573�� / ���� / �׷��� / ��4
	static int y, x, year;
	static int map[][], copy[][];
	static boolean visit[][];
	static int dy[] = {1,-1,0,0}; // �����¿�
	static int dx[] = {0,0,-1,1};
	
	static class dot {
		int y;
		int x;
		
		public dot(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken()); 
		x = Integer.parseInt(stk.nextToken());
		
		map = new int[y][x];
		visit = new boolean[y][x];
		copy = new int[y][x];
		
		// map �Է�
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// copy�迭(int) �� visit�迭(boolean)�� ����
		copyMap();
		
		// ���ʿ� �� ���� �ΰ�� 0�� ���
		if(check() > 1) {
			System.out.println(0);
		}
		else {
			//check �����ϸ鼭 ����� false�� �ٲ����״� �纹��.
			copyMap();
			bfs();		
			System.out.println(year);
		}
	}
	
	// bfs�����ϸ鼭 ������ ���δ�. 
	// �� �� ���� dfs���鼭 check�� ���ش�.
	public static void bfs() {
		Queue<dot> q = new LinkedList<>();
		
		int separated = 0;
		
		// �ʱ⿡ 0�� �ƴ� ���� q�� �� �־���.
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(map[i][j] != 0) {
					q.offer(new dot(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			// qSize�� year�� �ɰ���.
			while(qSize-- > 0 ) {
				dot now = q.poll();
				
				for(int i=0; i<4; i++) {
					int ny = now.y + dy[i];
					int nx = now.x + dx[i];
					
					if(ny>=0 && ny<y && nx>=0 && nx<x ) {
						//copy�迭�� ���� �� �迭�̹Ƿ� copy�迭�� ��������  map �迭�� �����Ѵ�.
						if(copy[ny][nx] == 0) {
							
							// map �迭�� ������ �ٲ�(1�� ��) �迭.
							if(map[now.y][now.x] > 0) {
								map[now.y][now.x]--;
							}
						}
					}
				}	
				
				// �ֺ� 0�� �������� 0�� ������ visit[][] = false;
				if(map[now.y][now.x] == 0) {
					visit[now.y][now.x] = false;
				} else {
					// ���� 0�� ���� �ʾ����� ť�� �ִ´�.
					q.offer(new dot(now.y, now.x));		
				}
			}
			year++;

			// map�� 1�� �� �������� ���������Ƿ�, copy�迭�� visit�迭�� �ֽ�ȭ�Ѵ�.
			copyMap();
			
			// �ֽ�ȭ�� visit �迭�� �������� �и��� ������ ���� ������ ���Ѵ�.
			// ���� ������ ���ϴ� ����� dfs��.
			separated = check();

			// �и��� ������ ������ 2�� �̻��̸��� return�Ѵ�.
			if(separated == 2) {
				return;
			}
		}
		// ������ �� ���� ������ �и����� ������ 0�� ����Ѵ�. 
		if(separated < 2) {
			year = 0;
		}
	}
	
	// �и��� ������ dfs Ž���Ѵ�. 
	public static void dfs(int yy, int xx) {

	     for (int i = 0; i < 4; i++) {
	            int ny = yy + dy[i];
	            int nx = xx + dx[i];

	      if (0 <= ny && ny < y && 0 <= nx && nx < x) {
	               if (visit[ny][nx]) {
	                    visit[ny][nx] = false;
	                    dfs(ny, nx);
	                }
	            }
	     }
	}
	
	// �� �״�� �迭�� �����ϰ� ���� �ִ� �ε����� true�� visit �迭�� �������ش�.
	public static void copyMap() {
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				copy[i][j] = map[i][j];
				if(copy[i][j] != 0) {
					visit[i][j] = true;
				}
			}
		}
	}
	
	// �и��� ������ ���� ������ ���Ѵ�. 
	public static int check() {
		int count = 0;
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(visit[i][j]) {
					
					// �и��� ������ ������ 2�� �Ѿ�� �ٷ� return�Ѵ�. 
					if(count >= 2) {
						return count;
					}
					
					visit[i][j] = false;
					dfs(i,j);
					count++;
				}
			}
		}
		
		return count;
	}
}
