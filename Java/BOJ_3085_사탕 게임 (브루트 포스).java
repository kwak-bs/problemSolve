package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3085 {
	// BOJ / 3085�� / ���� ����  / �긣�� ���� / ��4
	
	static char board[][], copy[][];
	static int n;
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		
		board = new char[n][n];
		copy = new char[n][n];
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine());
			board[i] = stk.nextToken().toCharArray();
		}
		// copy �迭�� �ڵ� ����
		copy();
		
		// ù �迭 ���� ���� ���ϱ�
		int max = countLength();
		
		
		// ���Ʈ������ �� �迭 ��ġ �ٲ��ֱ� 
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				max = Math.max(max, swap(i,j));
			}
		}
		
		System.out.println(max);
	}
	
	public static int swap(int yy, int xx) {
		
		int mmax = 0;

		
		for(int i=0; i<4; i++) {
			int ny = yy + dy[i];
			int nx = xx + dx[i];
			
			//swap
			if(ny>=0 && ny <n && nx >= 0 && nx <n ) {
				char temp= copy[yy][xx];
				copy[yy][xx] = copy[ny][nx];
				copy[ny][nx] = temp;
				
				// �ٲ� �迭 ���� ���� ���ϱ�
				mmax = Math.max(mmax, countLength());
				
				copy();
			}
			
		}
		
		return mmax;
	}
	
	public static int countLength() {
		
		int ylength = 1;
		int xlength = 1;
		int ymax = 1;
		int xmax = 1;
		int max = 0;
		
		for(int i=0; i<n; i++) {
			// x�� ���� ���� ���ϱ�
			for(int j=0; j<n; j++) {
				if(j == 0) {
					xlength = 1;
				}
				if(j > 0) {
					if(copy[i][j] == copy[i][j-1]) {
						xlength++;
					}
					else {
						xlength = 1;
					}
				}
				xmax = Math.max(xmax, xlength);
			}
			
			// y�� ������� ���ϱ�
			for(int k=0; k<n; k++) {
				if(k == 0) {
					ylength = 1;
				}
				if(k > 0) {
					if(copy[k][i] == copy[k-1][i]) {
						ylength++;
					}
					else {
						ylength = 1;
					}
				}	
				ymax = Math.max(ymax, ylength);
			}

			max = Math.max(ymax, xmax);
		}
		return max;
	}
	
	public static void copy() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				copy[i][j] = board[i][j];
			}
		}
	}
}
