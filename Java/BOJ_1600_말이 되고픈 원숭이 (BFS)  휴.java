package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
	//BOJ / 1600�� / ���� �ǰ��� ������ / �׷��� / ��5
	static int [][] map;
	static boolean [][][] visit;
	static int y,x, result, limit;
	static int [] dy = {1, -1, 0, 0};
	static int [] dx = {0, 0, 1, -1};
	static int [] hy = {-2, -2, 2, 2, 1, -1, 1, -1};
	static int [] hx = {1, -1, 1, -1, 2, 2, -2, -2};
	static dot start, end;
	
	static class dot {
		int y,x, jump;
		
		public dot(int y, int x, int jump) {
			this.y = y;
			this.x = x;
			this.jump = jump;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		limit = Integer.parseInt(br.readLine());
		
		stk = new StringTokenizer(br.readLine(), " ");
		
		x = Integer.parseInt(stk.nextToken());
		y = Integer.parseInt(stk.nextToken());
		map = new int[y][x];
		// visit �迭�� 3�������� �������ش�. �� �տ� ���� ���� Ƚ�� + 1 �Ѱ��� �����Ѵ�.
		// ������ �� ���� ���� Ƚ���̴�.
		visit = new boolean[limit+1][y][x];
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		start = new dot(0,0,0);
		end = new dot(y-1,x-1, 0);
		visit[0][0][0] = true;
		bfs(start);
	}
	
	public static void bfs(dot dot) {
		Queue<dot> q = new LinkedList<>();
		q.offer(dot);

		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			while(qSize-- > 0) {
				dot now = q.poll();
				//System.out.println(now.y + " " + now.x+ " " + now.jump);
				
				if(now.x == end.x && now.y == end.y) {
					System.out.println(result);
					return;
				}
				
				// ��� Ž�� 
		        for (int i = 0; i < 4; i++) {
		            int ny = now.y + dy[i];
		            int nx = now.x + dx[i];
		           
		            if (0 <= ny && ny < y && 0 <= nx && nx < x ) {
		            	if(map[ny][nx] == 0 &&
			            		!visit[now.jump][ny][nx]) {
		            		// �ɾ��� ��� ���� ���� �� ���� Ƚ�� visit �迭�� üũ���ش�.
		            		visit[now.jump][ny][nx] = true;
		            		q.offer(new dot (ny,nx, now.jump));	
		            	}
		            }
		        }
		        
		        // �� ���� Ž��
		        if(now.jump < limit) {
		        	for (int i = 0; i < 8; i++) {
		        		int ny = now.y + hy[i];
		        		int nx = now.x + hx[i];

		        		if (0 <= ny && ny < y && 0 <= nx && nx < x ) {
		        			if(map[ny][nx] == 0 && 
			        				!visit[now.jump+1][ny][nx]) {
		        				// ������ ���� ��쿡�� ���� ���� +1 ���� üũ���ش�.
		        				visit[now.jump+1][ny][nx] = true;
		        				q.offer(new dot (ny,nx,now.jump+1));	
		        			}
		        		}
		        	}
		        }
			}
			result++;
		}
		System.out.println(-1);
		return;
	}
}
