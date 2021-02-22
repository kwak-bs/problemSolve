package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10973 {
	// BOJ / 10973�� / ���� ���� / ���� / ��3
	
	static int n;
	static int num[];
	static StringBuffer sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		num = new int [n];
		sb = new StringBuffer();
		boolean possible = false;
		int mark = 0;
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i=num.length-1; i>=1; i--) {
			// ���� �ε��� ���� �� ū ���� �ε����� mark�� ���� 
			if(num[i] < num[i-1]) {
				possible = true;
				mark = i;
				break;
			}
		}
		
		if(possible) {
			solution(mark);
		}
		else {
			sb.append(-1);
		}
		
		System.out.println(sb);
	}
	
	public static void solution(int mark) {
		int max = 0;
		int maxIdx = -1;
		
		for(int i=num.length-1; i>=mark; i--) {
			// ���� ������ mark-1�� ������ ���� ������ �ִ� ���� 
			if(num[mark-1] > num[i]) {
				if(max < num[i]) {
					max = num[i];
					maxIdx = i;
				}
			}
		}
		
		// swap
		int temp = max;
		num[maxIdx] = num[mark-1];
		num[mark-1] = max;
		
		Integer ans[] = new Integer[n];
		
		// ���� Ÿ������ ��ȯ (���������� ����)
		for(int i=0; i<n; i++) {
			ans[i] = num[i];
		}
		
		// ���� ���� �������� ����
		Arrays.sort(ans, mark, num.length, Collections.reverseOrder());
		
		for(int i=0; i<num.length; i++) {
			sb.append(ans[i]).append(" ");
		}
	}
}
