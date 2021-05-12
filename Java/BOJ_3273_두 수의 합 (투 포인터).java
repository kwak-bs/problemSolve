package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
	// BOJ / 3273�� / �� ���� �� / �� ������ / �ǹ�4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);
		int x  = Integer.parseInt(br.readLine());
		int answer = 0;
		int l = 0; 
		int r = arr.length-1;
		while(l < r) {
			int sum = arr[l] + arr[r];
			// ���� ū ���ҿ� ���ߴµ� x���� �۰ų� ������ l++
			if(sum <= x) {
				l++;
			}
			// ���� ū ���ҿ� ���ߴµ� x���� ũ�� r--
			else if(sum > x) {
				r--;
			}
			if(sum == x) answer++;
			
		}
		System.out.println(answer);
	}
}
