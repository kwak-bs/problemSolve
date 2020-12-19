package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	//BOJ / 7576�� / �丶��  / �׷���, bfs / ��1
	
	static int [][] map;
	static int [] dr = {1,-1,0,0}; // ����
	static int [] dc = {0,0,1,-1}; // �¿�
	static int N;
	static int M;
	static int day;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[1001][1001];
		day = 0;
		
		// map �Է�.
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for( int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		
		// �̰� �ι�° �̽�����. ���⼭ bfs ȣ���ϸ� �ȵ�. tc3���� �ɸ�. �� ������ 1�� ������ ����ִ� ��Ȳ������ ���������� bfs�� ȣ���ϱ� ������ �ȵ�.
//		for(int i=1; i<=M; i++) {
//			for(int j=1; j<=N; j++) {
//				if(map[i][j] == 1) { // 1�� �κ� ã�Ƽ� bfs ����.
//					//System.out.println(i + " " + j);
//					bfs(i,j,0);
//				}
//			}
//		}

		bfs();
		if(check()) {
			System.out.println(day);
		}
		else {
			System.out.println(-1);
		}
	}
		
	public static void bfs() {
		
		Queue<int []> q = new LinkedList<>();
		
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == 1) { // 1�� �κ� ã�Ƽ� ť�� �־��� 
					q.offer(new int[] {i,j, 0}); // �Էµ� map���� 1�� ã�� day = 0���� �ʱ�ȭ �� q�� �־��� 
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			int [] now = q.poll();
			
			//���Ⱑ ù��° �̽�����.
			// day = now[2] �̰� �����ְ� q�� day�� ���Խ������� �ʾ����� day�� for���� �������� �����Ǵ� �̽��� �߻�����.
			day = now[2];
			
			for(int k=0; k<dr.length; k++) {
				int r = now[0] + dr[k]; // {1,-1,0,0}
				int c = now[1] + dc[k]; // {0,0,1,-1}
				
				if(r > 0 && c>0 && r<=M && c<=N) {
					if(map[r][c] == 0) {
						q.offer(new int[] {r,c, day+1} );
						map[r][c] = 1;
					}
				}
			}
		}
	}
	
	public static boolean check() {
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == 0) { 
					return false;
				}
			}
		}
		
		return true;
	}
}
