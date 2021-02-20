package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2529 {
	// BOJ / 2529�� / �ε�ȣ / ���Ʈ���� / ��2
	static int n; 
	static long max,min;
	static String maxStr,minStr;
	static int num[] = {0,1,2,3,4,5,6,7,8,9};
	static int print[];
	static boolean visit[];
	static String sign[];
	static StringBuffer sb;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		sign = new String[n];
		print = new int[n+1];
		visit = new boolean[10];
		sb = new StringBuffer();
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			sign[i] = stk.nextToken();
		}
		
		recursion(0);
		
		sb.append(maxStr).append("\n").append(minStr);
		System.out.println(sb);
	}
	public static void recursion(int depth) {
		
		if(depth == n+1) {
			// �־��� �ε�ȣ�� ���õ� ���ڰ� ���踦 �����ϸ�
			if(check()) {
				String s = "";
				
				for(int value : print) {
					s += value;
				}
				long temp = Long.parseLong(s);
				
				// ù �ڸ��� 0�� �����ϴ� ��찡 �����Ƿ� String�� �������ش�.
				if(temp > max) {
					max = temp;
					maxStr = s;
				}
				if(temp < min) {
					min = temp;
					minStr = s;
				}
			}
			return;
		}
		
		for(int i=0; i<num.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				print[depth] = num[i]; 
				recursion(depth + 1);
				visit[i] = false;
			}
		}
	}
	// �ε�ȣ�� �յڸ� �����ش�.
	public static boolean check() {
		boolean ok = true;
		
		for(int i=0; i<sign.length; i++) {
			if(sign[i].equals("<")) {
				if(!(print[i] < print[i+1])) {
					ok = false;
					break;
				}
			}
			else if(sign[i].equals(">")) {
				if(!(print[i] > print[i+1])) {
					ok = false;
					break;
				}
			}
		}
		
		return ok;
	}
	
}
