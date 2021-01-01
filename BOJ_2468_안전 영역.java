package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
	// BOJ / 2468�� / ���� ���� / ���Ʈ����, �׷��� / ��1
	
	static int [][] map;
	static boolean [][] isFlood;
	static int l;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// length �Է�
		l = Integer.parseInt(br.readLine());
		
		map = new int[l][l];
		isFlood = new boolean[l][l];
		int safe = 0;
		int maxResult = 0;
		
		// map �Է�
		for(int i =0; i<l; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<l; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �ִ� ���̰� ã��
		int maxHeight = 0 ;
		for(int i =0; i<l; i++) {
			for(int j=0; j<l; j++) {
				if(map[i][j] > maxHeight) {
					maxHeight = map[i][j];
				}
			}
		}

		//i�� ���� ���� ���̴�.
		for(int i=0; i<=maxHeight; i++) {
			checkFlood(i);
			for(int j=0; j<l; j++) {
				for(int k=0; k<l; k++) {
					if(!isFlood[j][k]) { // ���� ����� �ʾ����� dfs ������.
						dfs(j,k);
						safe++; // �������뺰�� count++
					}
				}
			}
			
			if(safe > maxResult) { // �ִ밪 ��ȯ
				maxResult = safe;
			}

			safe = 0; // count �ʱ�ȭ
			isFlood = new boolean[l][l]; // isFlood �ʱ�ȭ
		}
		System.out.println(maxResult);
	}
	
	// �� �帶�� ���� ����(��� ����, ���Ʈ ����) ���� ���� check�� true�� ��ȯ�Ѵ�.
	public static void checkFlood (int floodHeight ) {
		for(int i=0; i<l; i++) {
			for(int j=0; j<l; j++) {
				if(map[i][j] <= floodHeight) {						
					isFlood[i][j] = true;
				}
			}			
		}
	}
	
	public static void dfs(int y, int x) {
		isFlood[y][x] = true;

		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(nx >= 0 && nx < l && ny >= 0 && ny < l) {
				if(!isFlood[ny][nx]) {
					dfs(ny,nx);
				}
			}
		}
	}
}
