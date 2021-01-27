package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
	// BOJ / 1654�� / ���� �ڸ��� / �̺� Ž�� / ��3
	
	static long line[];
	static int n,k;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		k = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());
		
		line = new long [k]; 
		
		long max = 0;
		
		for(int i=0; i<k; i++) {
			line[i] = Long.parseLong(br.readLine());
			if(max < line[i]) {
				max = line[i];
			}
		}
		
		long start = 1; // 0�̸� ��Ÿ�� ���� (/by Zero �߻�)
		long end = max;
		long ans = 0;
		
		// �̺� Ž���� ���Ͽ� mid ���� ���Ѵ�. 
		while(start <= end) {
			long mid = (start + end) / 2;
			
			if(check(mid, line)) {
				// count�� k ���� ���͵� mid�� �ִ��� ã������ while���� ��� ��.
				ans = Math.max(ans, mid);
				start = mid + 1;
			} 
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
	
	// mid�� �߶� ������ Ȯ���Ѵ�.
	public static boolean check(long mid, long[] arr) {
		int count = 0;
		
		for(int i=0; i<k; i++) {
			count += arr[i] / mid;
		}
		
		return count >= n;
	}
}
