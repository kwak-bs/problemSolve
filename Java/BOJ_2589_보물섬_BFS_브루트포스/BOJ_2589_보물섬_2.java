package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_2 {
	// BOJ / 2589�� / ������ / �׷���, ���Ʈ���� / ��5
	
	static int y,x, max;
	static char map[][];
	static boolean visit[][];
	static int count[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		map = new char[y][x];
		visit = new boolean[y][x];
		count = new int[y][x];
		
		// map �Է�
		for(int i=0; i<y; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// ���Ʈ������ �� ���� Ž���Ѵ�.
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(map[i][j] == 'L') {
					bfs(i,j,0); // ù ����L�� count�� 0��
					
					int temp = countMax(); // �� �������� �ִ��� �ִܰŸ��� ���Ѵ�.
					
					// temp�� �ִ밪�� ���Ѵ�.
					if(max < temp) {
						max = temp;
					}
					// �� ������ ���� bfs������ �ʱ�ȭ
					count = new int[y][x]; 
					visit = new boolean[y][x];
				}
			}
		}
		
		System.out.println(max);
	}
	
	// �� 'L' �������� bfs ���Ƽ� count��(hour) ����
	public static void bfs(int yy,int xx, int cnt) {
		Queue<int[]>q = new LinkedList<>();
		cnt = 0;
		visit[yy][xx] = true;
		q.offer(new int[] {yy,xx, cnt});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			
			for(int i=0; i<4; i++) {
				int ny = now[0]+ dy[i];
				int nx = now[1] + dx[i];
				cnt = now[2];
				
				if(ny>=0 && ny <y&& nx >= 0 && nx < x) {
					if(map[ny][nx] == 'L' && !visit[ny][nx]) {
						visit[ny][nx] = true;
						count[ny][nx] = count[now[0]][now[1]] + 1;
						q.offer(new int[] {ny,nx, count[ny][nx]});
					}
				}
			}			
		}
	}
	
	// �� �������� �ִ� �Ÿ����� �ִ��� ���Ѵ�.
	public static int countMax() {
		int max = 0;
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(max < count[i][j]) {
					max = count[i][j];
				}
			}
		}
		
		return max;
	}
}
