package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	// BOJ / 1074�� / Z / ���� ���� / �ǹ�1
	static int r,c,count;
	static int dy[] = {0,0,1,1};
	static int dx[] = {0,1,0,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = (int)Math.pow(2, Integer.parseInt(stk.nextToken()));
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		go(n, 0, 0);
	}
	
	public static void go(int num, int row, int col) {
		
		if(row == r && col == c) {
			System.out.println(count);
			System.exit(0);
		}
		// ã������ ��ǥ�� 4����� ���� ���� ������ �� �κ��� �� 4����Ͽ� ã�´�. 
		if(row <= r && r <(row + num) && col <= c && c < (col+num)) {
			go(num/2, row,col); // ���� ��� 
			go(num/2, row, col+num/2); // ���� ��� 
			go(num/2, row+num/2, col); // ���� �ϴ� 
			go(num/2, row+num/2, col+num/2); // ���� �ϴ� 			
		}
		// 4����� ���� ���� ������ �� ������ ������ �������� ���̹Ƿ� �� �κ��� ��� Ƚ���� ���Ѵ�. 
		else count += num*num;
	}
}
