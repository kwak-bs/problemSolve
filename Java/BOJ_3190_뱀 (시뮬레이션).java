package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3190 {
	// BOJ / 3190�� / �� / �ùķ��̼� / ���5
	static int n, k, map[][];
	// ��,��,��,��
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static List<int[]> snake;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<k; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int y = Integer.parseInt(stk.nextToken());
			int x = Integer.parseInt(stk.nextToken());
			
			// ����� ��ġ
			map[y-1][x-1] = 1;
		}
		
		int l = Integer.parseInt(br.readLine());
		
		int[][] dir = new int[l][2]; 
		for(int i=0; i<l; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			dir[i][0] = Integer.parseInt(stk.nextToken());
			
			char temp = stk.nextToken().charAt(0);			
			dir[i][1] = (temp == 'L') ? -1 : 1; // L -> -1, D ->1
		}
		
		snake = new LinkedList<>();
		snake.add(new int[] {0,0});
		
		int time = 0;
		int DirIdx = 0;
		int curDir = 0; // ó���� ������
		int nowY = 0;
		int nowX = 0;
		while(true) {
			time++;
			
			int nextY = nowY+dy[curDir];
			int nextX = nowX+dx[curDir];
			
			if(isFinish(nextY, nextX)) {
				break;
			}
			// ����� ������ ��� ���ְ� ������ �״��
			if(map[nextY][nextX]  ==  1) {
				map[nextY][nextX] = 0;
				snake.add(new int[] {nextY,nextX});
			}
			// ������ ������ �ڸ���
			else {
				snake.add(new int[] {nextY,nextX});
				snake.remove(0);
			}
			
			nowY = nextY;
			nowX = nextX;
			
			// DirIdx�� ���� ���� ��ȯ ���� �迭 ���̺��� ������츸 
			if(DirIdx < l) {
				// ���� �ٲ��ߵ� �ð��� �ƴٸ� 
				if(time == dir[DirIdx][0]) {
					// ���� 90��
					if(dir[DirIdx][1] == -1) {
						curDir = (curDir + 3) % 4;
					}
					// ������ 90��
					else {
						curDir = (curDir + 1)%4; 
					}
					DirIdx++;
				}
			}
		}
		
		System.out.println(time);
		
	}
	public static boolean isFinish(int ny, int nx) {
		
		// ��
		if(!(ny >=0 && ny<n && nx>=0 && nx <n)) {
			return true;
		}
		// �ڱ� �� 
		for(int i=0; i<snake.size(); i++) {
			int body[] = snake.get(i);
			
			if(body[0] == ny && body[1] == nx) {
				return true;
			}
		}
		return false;
	}
	
}
