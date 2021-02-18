package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {
	// BOJ / 6064�� / ī�� �޷�  / ���� / ��1
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int m = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			
			int gcd = gcd(Math.max(m, n), Math.min(m, n));
			long lcm = lcm(m,n,gcd);

			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			// x�� ����.
			int ans = x % (m+1);
			int tempY = ans;
			boolean flag = false;
			
			// x�� ����� ������ y��ŭ�� ������ ��.
			for(int i=0; i<n; i++) {
				//ans�� n�� ������ �����ϱ� tempY�� ansȭ �Ͽ� �������.
				// ��� tempY�� �������� Ȱ���Ͽ� ����.
				tempY = tempY % n == 0 ? n : tempY % n;
				
				if(tempY == y) {
					flag = true;
					break;
				}
				tempY += m;
				ans +=m;
			}
			
			if(flag) {
				sb.append(ans).append("\n");
			}
			else {
				sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static int gcd(int big, int small) {
		
		while(small > 0) {
			int temp = big % small;
			big = small;
			small = temp;
		}
		return big;
	}
	
	public static int lcm(int m, int n, int gcd) {
		return m * n / gcd;
	}
}
