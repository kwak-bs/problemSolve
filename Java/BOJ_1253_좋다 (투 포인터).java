package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
	// BOJ / 1253�� / ���� / �̺� Ž�� / ���3
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[N];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);
		
		int answer = 0;
		if(arr.length > 2) {
			for(int i=0; i<arr.length; i++) {
				if(binarySearch(arr, arr[i], i)) {
					answer++; 
				}
			}			
		}
		
		System.out.println(answer);
	}
	
	public static boolean binarySearch(int[] arr, int target, int idx) {
		
		int start = 0; 
		int end = arr.length-1;
		
		while(start < end) {
			// Ÿ�� idx�� ����� ��
			if(end == idx) end--;
			if(start == idx) start++;
			// ������ ���� �� �ٽ� ����
			if(end == start) return false;
			
			// �� ������ ���� ���� ����
			int sum = arr[start] + arr[end];
			
			// ��
			if(sum == target) {
				return true;
			}
			if(sum > target) {
				end--;
			}
			else if(sum < target) {
				start++;
			}
		}
		return false;
	}
}
