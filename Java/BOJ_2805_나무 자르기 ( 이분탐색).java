package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
	// BOJ / 2805�� / ���� �ڸ��� / �̺� Ž��/ ��3
	
	static long n,m;
	static long tree[];
	
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Long.parseLong(stk.nextToken()); // ���� ��
		m = Long.parseLong(stk.nextToken()); // ������ ���������� �ϴ� ���� ����
		
		tree = new long [(int) n];
		stk = new StringTokenizer(br.readLine(), " ");
		long max = 0;
		for(int i=0; i<n; i++) {
			tree[i] = Long.parseLong(stk.nextToken());
			
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		

		long start = 1;
		long end = max;
		long ans = 0; 

		while (start <= end) {
			long mid = (start + end) / 2;

			
			if(check(mid, tree) ) {
				ans = Math.max(ans, mid);
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
	
	public static boolean check(long mid, long arr[]) {
		
		long len = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] >= mid) {
				// ���̸�ŭ ������ �߶󳽴�. �߶� ������ ���̸� ���Ѵ�.
				len += (arr[i] - mid);				
			}
		}

		return len >= m;
	}
}
