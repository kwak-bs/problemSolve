package problemSolve2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {
	// BOJ / 1874�� / ���� ���� / ���� / ��3
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int n = sc.nextInt();
		
		int num[] = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = sc.nextInt();
		}
		int start = 0;
		
		for(int i=0; i<n; i++) {
			int value = num[i];
			
			// value�� ���� push�� �̷��� ������� stack�� value�� ���� push�� �� 
			// ������ ���Ҹ� pop�Ѵ�. push�϶� +�� sb�� ����, pop�϶� -���� �Ѵ�.
			if(value > start ) {
				for(int j=start + 1; j<=value; j++) {
					st.push(j);
					sb.append("+").append("\n");
				}
				
				start = value;
			}
			 
			else if(st.peek() != value) {
				System.out.println("NO");
				return;
			}
			
			// (1) value�� start���� ũ�� value�� ���� push �ϰ� peek�� pop�Ѵ�.
			// (2) value�� start���� ������ (������ -1)�̸� peek�� pop�Ѵ�.
			st.pop();
			sb.append("-").append("\n");
		}
		
		System.out.println(sb);
	}
}
