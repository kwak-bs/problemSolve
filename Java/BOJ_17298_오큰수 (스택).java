package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {
	// BOJ / 17298�� / ��ū�� / ����, �ڷᱸ�� / ���4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int arr [] = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		for(int i=0; i<n; i++) {
			// ���� ���ÿ� ��� �ִ� �� = ���� index
			// ���� ���� ���� �ε������� ������ ũ�� �迭�� ���� �ε����� ���� ���ذ��� ���� ���� �ִ´�.
			while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
				arr[st.pop()] = arr[i];
			}
			st.add(i);
		}
		while(!st.isEmpty()) {
			arr[st.pop()] = -1;
		}
		for(int i=0; i<n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}
}
