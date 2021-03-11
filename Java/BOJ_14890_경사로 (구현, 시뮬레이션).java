package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890 {
	// BOJ / 14890�� / ���� / ���� / ���3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(stk.nextToken());
		int l = Integer.parseInt(stk.nextToken());
		
		int map[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		int ans = 0;
		// �� �˻�
		for(int i=0; i<n; i++) {
			int r[] = new int[n];
			
			for(int j=0; j<n; j++) {
				r[j] = map[i][j];
			}
			if(go(r, l)) ans++;
		}
		
		//�� �˻�
		for(int i=0; i<n; i++) {
			int c[] = new int[n];
			
			for(int j=0; j<n; j++) {
				c[j] = map[j][i];
			}
			if(go(c,l)) ans++;
		}
		System.out.println(ans);
	}
	
	public static boolean go(int a[], int l) {
		// �� �� �˻�
		int n = a.length;
		boolean c [] = new boolean[n];
		for(int i=1; i<n; i++) {
			// ������ ĭ�� ���̰� �ٸ���, ���θ� ���´�.
			if(a[i-1] != a[i]) {
				int diff = a[i]-a[i-1];
				if(diff < 0) diff = -diff;
				// ���� ĭ�� ���� ĭ�� ���̴� 1�̾�� �Ѵ�.
				if(diff != 1) return false;
				
				// ���� ���� �˻�
				if(a[i-1] < a[i]) {
					for(int j=1; j<=l; j++) {
						// ���θ� ���ٰ� ������ ����� ���
						if(i-j < 0) return false;

						// ���� ������ ĭ�� ���̰� ��� ���� �ʰų�, 
						// L���� ���ӵ��� ���� ���
						if(a[i-1] != a[i-j]) return false;
						
						// ���θ� �̹� ���� ���
						if(c[i-j]) return false;
						
						c[i-j] = true;
					}
				}
				// ������ ���� �˻� a[i-1] > a[i]
				else {
					for(int j=0; j<l; j++) {
						if(i+j >= n) return false;
						
						if(a[i] != a[i+j]) return false;
						
						if(c[i+j]) return false;
						
						c[i+j] = true;
					}
				}
			}
		}
		return true;
	}
}
