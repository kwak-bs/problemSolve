package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891 {
	// BOJ / 14891�� / ��Ϲ��� / �ùķ��̼� / ���5
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a[][] = new int[4][8];

		for(int i=0; i<a.length; i++) {
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
			int d = Integer.parseInt(stk.nextToken()); // 1:�ð�, -1:�ݽð�
			
			// 1 �ð� , -1 �ݽð�, 0 ȸ��x
			int turn[] = new int[4];
			turn[n] = d;
			
			// ���� ȸ�� ���� ����
			for(int i=n; i>=1; i--) {
				// �ٸ���
				if(a[i][6] != a[i-1][2] ) {
					turn[i-1] = -turn[i];
				}
				else break;
			}
			
			// ������ ȸ�� ���� ����
			for(int i=n; i<=2; i++) {
				// �ٸ���
				if(a[i][2] != a[i+1][6] ) {
					turn[i+1] = -turn[i];
				}
				else break;
			}
			
			// ��Ϲ��� ȸ�� 
			for(int i=0; i<4; i++) {
				switch(turn[i]) {
				
				case 0 : continue;
				// �ð�
				case 1 : 
					int temp = a[i][7];
					for(int j=7; j>=1; j--) {
						a[i][j] = a[i][j-1];  
					}
					a[i][0] = temp; 
					break;
				// �ݽð�
				case -1 :
					int tmp = a[i][0];
					for(int j=0; j<7; j++) {
						a[i][j] = a[i][j+1];
					}
					a[i][7] = tmp;
					break;
				}
			}
		}
		int sum = 0;
		// ������ �� ��� 
		for(int i=0; i<4; i++) {
			if(i == 0 && a[i][0] == 1) {
				sum++;
			}			
			else if(i == 1 && a[i][0] == 1) {
				sum+=2;
			}
			else if(i == 2 && a[i][0] == 1) {
				sum+=4;
			}
			else if(i == 3 && a[i][0] == 1) {
				sum+=8;
			}
		}
		System.out.println(sum);
	}
}
