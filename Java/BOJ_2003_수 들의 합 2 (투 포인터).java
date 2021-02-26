package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
	// BOJ / 2003�� / ������ �� 2 / �� ������ / ��3
	
	static long num [];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(stk.nextToken());
		long m = Integer.parseInt(stk.nextToken());
		
		num= new long[n];
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Long.parseLong(stk.nextToken());
		}
		int start=0 , end =0, count = 0;
		long sum = 0;
		
		while(true) {
			
			if(sum >= m) {
				sum -= num[start++];
			}
			else if(end == n) break;
			else if(sum < m) {
				sum += num[end++];
			}
			if(sum == m) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
