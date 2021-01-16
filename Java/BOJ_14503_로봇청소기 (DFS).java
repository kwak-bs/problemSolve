package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
	// BOJ / 14503�� / �κ�û�ұ� / �׷��� / ��5
	
	static int y,x,d,r,c, count;
	static int map[][];
	static int dy[] = {-1,0,1,0};  // �ϵ�����
	static int dx[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken()); 
		x = Integer.parseInt(stk.nextToken());
		map = new int[y][x];
		
		stk = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		d = Integer.parseInt(stk.nextToken()); // ���� 0�� , 1��, 2��, 3��
		count = 1;
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		dfs(r,c,d);
		System.out.println(count);
	}
	
	public static void dfs(int r, int c, int direction) {
		
		//���� ��ġ�� û���Ѵ�.
		map[r][c] = -1;
		
		//���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
		for(int i=0; i<4; i++) {
			direction = (direction + 3) % 4; // ���� �������� ��ȯ (�� -> �� -> �� -> ��)
			int ny = r + dy[direction];
			int nx = c + dx[direction];
			
			// û�Ұ� �ȵ� ���� ������ count++,  dfs
			if(ny >=0 && ny < y && nx >= 0 && nx < x && map[ny][nx] == 0) {
				count++;
				dfs(ny,nx, direction);
				//System.out.println("(ny, nx) "+ny + " " + nx);
				
				//���⼭ return�� ���ϸ� �����ϴ� ���� �ڷΰ��� �ٸ� ���� û���Ҽ��� ����.
				return;
			}
		}
		
		//�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��
		//���� ĭ�� ���� �ƴ϶�� ���� �Ͽ�, �ٶ󺸴� ������ ������ ä�� �� ĭ ����.
		int back = (direction + 2) % 4;
		int by = r + dy[back];
		int bx = c + dx[back];
		if(by>=0 && by<y && bx>=0 && bx<x && map[by][bx] != 1) {
			dfs(by,bx,direction);
			//System.out.println("(by, bx) "+by + " " + bx);
		}

		//System.out.println("(r, c) "+r + " " + c);
	}
}
