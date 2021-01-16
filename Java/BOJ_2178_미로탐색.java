package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
	//BOJ / 2178�� /  �̷� Ž�� / bfs, �׷��� / ��1
	
	static int map [][];
	static boolean visit [][];
	static int [] dr = {1, -1, 0, 0}; // ����
	static int [] dc = {0, 0, 1, -1}; // �¿� 
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		// �׷��� �Է� 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j) - '0'; // ��� ������ ����� . �˾Ƶ��� 
			}
		}
		bfs(0,0);
		
		System.out.println(map[N-1][M-1]);
	}
	
	// ť,  bfs
	public static void bfs(int i, int j) {
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int [] now = q.poll();
			visit[i][j] = true;
			for(int k=0; k<dr.length; k++) {
				int r = now[0] + dr[k]; // �� + ��/��
				int c = now[1] + dc[k]; // �� + ��/��
				
				//��ǥ�� ���� Ȥ�� N, M�� �Ǿ� ������ ����� �ʵ���
				if(r >= 0 && c >= 0 && r <N && c < M) {
					if(map[r][c] != 0 && !visit[r][c] ) {
						q.offer(new int[] {r,c});
						visit[r][c] = true;
						map[r][c] = map[now[0]][now[1]] + 1; // ������ ���� +1
					}
				}
			}
		}
	}
}
