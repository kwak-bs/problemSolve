package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
	//BOJ / 14502�� / ������ / �׷���, ���Ʈ����  / ��5
	
	static int [][] map;
	static int [][] copy;
	static int [] dy = {1, -1, 0, 0};
	static int [] dx = {0, 0, 1, -1};
	static int y, x, max;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(st.nextToken()); // ���� ũ��
		x = Integer.parseInt(st.nextToken()); // ���� ũ��
		map = new int[y][x];
		copy = new int[y][x];

		// map �Է�
		for(int i=0; i<y; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeWall(0, 0);
		

		System.out.println(max);
		
	}
	
	// ��Ʈ��ŷ + ���� �̿��Ͽ� �� �����
	public static void makeWall(int start, int wallCount) { 
		
		if(wallCount == 3) {
			copyMap(); // �� 3�� �������� �� ���� ( ���̷��� ��Ʈ�� ��)
			
			// ���̷��� ��Ʈ����
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					if(copy[i][j] == 2) {
						dfs(i,j);
					}
				}
			}

			max = Math.max(max, countSafeZone()); // �������� �ִ� ���ϱ� 
			return;
			
		}
		
		for(int i=start; i< y * x; i++) {
			int dy = i / x; // ���� 
			int dx = i % x;
			
			if(map[dy][dx] == 0) {
				map[dy][dx] = 1;
				// ��Ʈ��ŷ
				makeWall(i + 1, wallCount + 1); 
				map[dy][dx] = 0;
			}
		}
	}
	
	// dfs �̿��Ͽ� ���̷��� ��Ʈ����
	public static void dfs(int yy, int xx) {
		
        for (int i = 0; i < 4; i++) {
            int ny = yy + dy[i];
            int nx = xx + dx[i];

            if (0 <= ny && ny < y && 0 <= nx && nx < x) {
                if (copy[ny][nx] == 0) {
                    copy[ny][nx] = 2;
                    dfs(ny, nx);
                }
            }
        }
	}
	
	// ���̷����� ��Ʈ�� ��
	public static void copyMap() {
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	// �������� ���� ����
	public static int countSafeZone() {
		int safe = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (copy[i][j] == 0)
                    safe++;
            }
        }
        return safe;
	}
}
