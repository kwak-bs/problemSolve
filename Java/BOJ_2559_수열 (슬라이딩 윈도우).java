package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {
	// BOJ / 2559�� / ���� / �� ������ / �ǹ�3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		int arr[] = new int[n];
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++ ) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		boolean flag = false;
		for(int i=0; i<n; i++) {
			// �ʹ� k-1���� �������� sum�� max�� ���ϸ�ȵ�.
			if(i == k-1) flag = true;
			if(i >= k) {
				sum-= arr[i-k];
			}
			sum += arr[i];
			
			if(max < sum && flag) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}
