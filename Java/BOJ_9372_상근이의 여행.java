package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9372 {
	// BOJ / 9372�� / ������� ���� / Ʈ�� / ��3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			
			stk  = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(stk.nextToken()); // ������ �� 
			int m = Integer.parseInt(stk.nextToken()); // ������� ����
			
			for(int i=0; i<m; i++) {
				stk  = new StringTokenizer(br.readLine(), " ");
				
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
			}
			// �ּ� ���д� Ʈ���� V-1���� �������� �̷���� ����. 
			// ��, ������ ������ Ÿ���� ����� ������. 
			System.out.println(n-1);
		}		
 	}
}
