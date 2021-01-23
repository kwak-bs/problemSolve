package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2776 {
	// BOJ / 2776�� / �ϱ�� / �ؽ� / ��3
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		while ( t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			stk  = new StringTokenizer(br.readLine(), " ");
			
			int memo1[] = new int[n];
			for(int i=0; i<n; i++) {
				memo1[i] = Integer.parseInt(stk.nextToken());
			}
			Arrays.sort(memo1);
			
			int m = Integer.parseInt(br.readLine());
			stk  = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<m; i++) {
				int num = Integer.parseInt(stk.nextToken());
				
				int start = 0;
				int end = n;
				// �̺� Ž�� ���� 
				while(start < end) {
					int mid = (start + end) / 2;
				
					if(num > memo1[mid]) {
						start = mid + 1;
					}
					else {
						end = mid;
					}
				}
				//System.out.println(end);
				if(end < n && memo1[end] == num) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}
				sb.append("\n");
			}
		}
		// �� ����� �������� ������� �ϤѤ� while�� �ȿ� ���ָ� ��¼�ڴ°ų� �� �� �� 
		System.out.println(sb.toString());
	}
}
