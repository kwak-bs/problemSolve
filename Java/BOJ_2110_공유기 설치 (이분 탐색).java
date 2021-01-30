package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
	// BOJ / 2110�� / ������ ��ġ / �̺� Ž�� / �ǹ�1
	
	static int n,c;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		int wifi[] = new int [n];
		
		for(int i=0; i<n; i++) {
			wifi[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(wifi);
		
		int start = 1; // ������ �ּ� �Ÿ� (�Ÿ��� ������ 1�̻� ���̳�)
		int end = wifi[n-1] - wifi[0]; // ������ �ִ� �Ÿ�
		int ans = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(check(mid, wifi)) {
				ans = Math.max(ans, mid);
				start = mid + 1 ;
			} else {
				end = mid - 1;
			}
 		}
		
		System.out.println(ans);
	}
	
	public static boolean check(int dis, int arr[]) {
		int count = 1;
		
		int next = arr[0] + dis; // ù ��° ���� ���� ��.
		
		for(int i=0; i<n; i++) {
			if(arr[i] >= next) {
				count++;
				next = arr[i] + dis; // ���� ���� �����ϸ� count++ �� �� ���� ������ �̵�.
			}
		}
		
		return count >= c;
	}
}
