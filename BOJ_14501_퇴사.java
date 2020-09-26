package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
	//BOJ / 14501�� / ��� / ���Ʈ ����, dp / ��4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int t [] = new int[n+10]; //�ҿ� �ϼ�
		int p [] = new int[n+10]; //���� 
		int dp [] = new int[n+10]; // i�� ���� ���� �� �ִ� �ִ� �ݾ�.

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=n-1; i>=0; i--) {
			int day = i + t[i]; // i��° ���� ��� ������ ������ ��¥  
			
			if(day <= n) { // ���� ������ �������� ��㰡��
				dp[i] = Math.max(p[i]+dp[day], dp[i+1]);
			}
			
			else { // ����� �ʰ�
				dp[i] = dp[i+1];
			}
		}
			System.out.println(dp[0]);
	}
}
