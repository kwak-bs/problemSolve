package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
	// BOJ / 2589�� / ������ / �׷���, ���Ʈ���� / ��5
	
	static char [][] map;
	static char [][] copy;
	static int [][] count;
	static int y, x, result;
	static int [] dy = {1,-1,0,0}; //����
	static int [] dx = {0,0,1,-1}; //�¿�
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		
		map = new char[y][x];
		copy = new char[y][x];
		count = new int[y][x];
		
		// map �Է�
		for(int i=0; i<y; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// map ����
		copyMap();
		
		//������ ������ �������������.
		bf();
		
		System.out.println(result);
	}
	
	// copymap
	public static void copyMap() {
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	// ���Ʈ ������ �� ���� Ž��
	public static void bf() {
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(copy[i][j] == 'L') {
					//L ���� bfs
					bfs(i,j);
					
					// bfs�� count���� �ִ밪 ���ϱ�
					int temp = countMax();

					// temp �� �ִ� �� 
					if(result < temp) {
						result = temp;
					}
					
					copyMap(); //�ʱ�ȭ
					count = new int[y][x]; // �ʱ�ȭ
				}
			}
		}
	}
	
	// �� 'L' �������� bfs ���Ƽ� hour ���� �����Ѵ�. 
	public static void bfs(int yy, int xx) {
		Queue<int []> q = new LinkedList<>();
		int hour = 0;
		
		q.offer(new int[] {yy,xx, 0});
		copy[yy][xx] = 'W'; // ��湮 ���� �ʱ� ���� W�� �ٲ��� 
		
		while(!q.isEmpty()) {
			int [] now = q.poll();
			hour= now[2];
			
			for(int i=0; i<4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				
				if(ny>= 0 && ny <y && nx >= 0 && nx < x ) {
					// count[ny][nx] == 0 �̰� �� ����ߵ�. �̰� �����༭ �޸� �ʰ� ��
					if(copy[ny][nx] == 'L' && count[ny][nx] == 0) {
						count[ny][nx] = hour + 1;
						q.offer(new int[] {ny,nx,hour+1});
						copy[now[0]][now[1]] = 'W'; // �������� ��湮 x
					}
				}
			}
		}
	}
	
	// bfs�� count �� ���� �ִ��� �����Ѵ�.
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
