package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
	//BOJ / 2146�� / �ٸ� ����� / �׷��� / ��3
	
	static int n, area, min;
	static int map[][], copy[][];
	static boolean visit[][];
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
	
    static class dot {
		int y,x,count;
		
		public dot (int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		copy = new int[n][n];
		visit = new boolean[n][n];
		area = 1;
		min = 99999;
		
		//�Է�
    	for(int i=0; i<n; i++) {
    		stk = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<n; j++) {
    			map[i][j] = Integer.parseInt(stk.nextToken());
    		}
    	}
    	
    	//�������� �󺧸��� ���ش�. dfs �ϱ� ���� �湮ó����.
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(map[i][j] == 1 && !visit[i][j]) {
    				area++;
    				dfs(i,j);
    			}
    		}
    	}
    	// ���Ʈ ������ ��� ������ �� ���ű� ������ copy map�� �ʿ���
    	copyMap();

    	// �󺧸��� 2 �̻���� �Ǿ� �ֱ� ������ ������ ���δ� bfs �����ش�.
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(copy[i][j] >= 2) {
    		    	bfs(i, j);
    		    	copyMap();
    			}
    		}
    	}

		
    	System.out.println(min);
	}
    
    public static void bfs(int startY, int startX) {
    	Queue<dot> q = new LinkedList<>();

    	q.offer(new dot(startY,startX, 0));
    	
    	while(!q.isEmpty()) {
    		
    			dot now = q.poll();
    			
    			for(int i=0; i<4; i++) {
    				int ny = now.y + dy[i];
    				int nx = now.x + dx[i];
    				int nc = now.count + 1;
    				if(ny >= 0 && ny < n && nx >= 0 && nx < n) {
    					// ���� ��ġ�� ���� ������ ������ ���ٸ� continue
    					if(copy[ny][nx] == copy[startY][startX]) {
    						continue;
    					}
    					// ���� ��ġ�� �̹� ������ �ٸ���� continue
    					if(copy[ny][nx] == -1) {
    						continue;
    					}
    					// ������ ���� ó���� ����� ������ ���⼱ ������ ���� ���� �� �ۿ� ����. 
    					// ��� ��츦 ���鼭 ���� ���� ������ ������ ���� ���ؼ� �ּڰ����� ����.
    					if(copy[ny][nx] != 0) {
    						min = Math.min(min, nc-1);
    						return;
    					}
    					// �ٸ��� ���� ���� �湮 ó���� ���Ͽ� -1�� ���ش�.
    					if(copy[ny][nx] == 0 ) {
    						copy[ny][nx] = -1;
    						q.offer(new dot(ny,nx,nc));
    					}
    				}	
    			}
    	}
    }
    
    // dfs�� ������ �󺧸��� ���ش�. 
    public static void dfs(int y, int x) {
		map[y][x] = area;
    	
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= 0 && ny < n && nx >= 0 && nx < n) {
				if(map[ny][nx] == 1 && !visit[ny][nx]) {
					dfs(ny,nx);
				}
			}	
		}
    	
    }
    
    public static void copyMap() {
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			copy[i][j] = map[i][j];
    		}
    	}
    }
    
    public static void print(int[][] test) {

    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			System.out.print(test[i][j]);
    		}
    		System.out.println();
    	}
    }	
}
