package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15662 {
	// BOJ / 15662�� / ��Ϲ���(2) / ���� / �ǹ�2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		
		int a[][] = new int[t][8];

		for(int i=0; i<t; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer stk;

		while(k-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(stk.nextToken()) - 1;
			
			int dir = Integer.parseInt(stk.nextToken());
			// ����� ���� ����. 1=�ð�, -1=�ݽð�, 0= ȸ�� ����
			int[] d = new int[t];
			d[n] = dir;
			// ���� ��� ���������� ����
			for(int i=n-1; i>=0; i--) {
				if(a[i][2] != a[i+1][6]) {
					d[i] = -d[i+1];
				}
				else {
					// ������ ȸ��x �̹Ƿ�, ���������� ȸ�� ���Ѵ�.
					break;
				}
			}
			
			// ������ ��� ���������� ����
			for(int i=n+1; i<t; i++) {
				if(a[i][6] != a[i-1][2]) {
					d[i] = -d[i-1];
				}
				else {
					break;
				}
			}
			
			for(int i=0; i<t; i++) {
				
				if(d[i] == 0) continue;
				
				// �ð� ���� ȸ��
				if(d[i] == 1) {
					int temp = a[i][7];
					
					for(int j=7; j>=1; j--) {
						a[i][j] = a[i][j-1];
					}
					
					a[i][0] = temp;
				}
				
				// �ݽð� ���� ȸ��
				if(d[i] == -1) {
					int temp = a[i][0];
					
					for(int j=0; j<7; j++) {
						a[i][j] = a[i][j+1];
					}
					
					a[i][7] = temp;
				}
			}
		}
		int ans = 0;
		for(int i=0; i<t; i++) {
			if(a[i][0] == 1) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
