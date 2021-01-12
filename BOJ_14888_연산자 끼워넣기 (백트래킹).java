package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	// BOJ / 14888�� / ������ �����ֱ� / ���Ʈ����, ��Ʈ��ŷ / ��1
	static int n, max, min;
	static int[] num, exp;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		n = Integer.parseInt(br.readLine());
		
		num = new int[n];
		exp = new int[4];
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		
		// ���� �Է�
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		// ���� �Է�
		// ���� ���� ���� ������
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			exp[i] = Integer.parseInt(stk.nextToken());
		}
		
		dfs(num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	
	// ��Ʈ��ŷ �̿� 
	public static void dfs(int number, int next) {
		
		if(next == n) {
			max = Math.max(max, number);
			min = Math.min(min, number);
		}
		
		// �긣�� ���� 
		for(int i=0; i<4; i++) {
			// ������ ������ 1�� �̻��̸�
			if(exp[i] > 0) {
				// �ش� ������ 1 ����
				exp[i] --;
				
				switch(i) {
				
				case 0 : dfs(number + num[next], next+1);
					break;
				case 1 : dfs(number - num[next], next+1);
					break;
				case 2 : dfs(number * num[next], next+1);
					break;
				case 3 : dfs(number / num[next], next+1);
					break;
				}
				// ���ȣ���� ����Ǹ� ��Ʈ��ŷ�� ���� �ش� ������ ���� ����.
				exp[i]++;
			}
		}
	}
}







