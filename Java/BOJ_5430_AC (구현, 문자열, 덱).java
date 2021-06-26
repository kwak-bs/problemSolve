package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_5430 {
	// BOJ / 5430�� / AC / ����, ���ڿ�, �� / ���5
	// ���� StringBuilder ������ �������
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk;
		ArrayDeque<Integer> dq;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			dq = new ArrayDeque<>();
			stk = new StringTokenizer(br.readLine(), ",[]");
			
			for(int i=0; i<n; i++) {
				dq.add(Integer.parseInt(stk.nextToken()));
			}
			
			AC(p, dq);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	// ��ɾ��� ���� ����
	public static void AC(String p, ArrayDeque<Integer> dq) {
		
		boolean right = true;
		for(int i=0; i<p.length(); i++) {
			char op = p.charAt(i);
			
			if(op == 'R') {
				right = !right;
			}
			else if(op == 'D') {
				if(dq.size() > 0) {
					if(right) dq.removeFirst();
					else dq.removeLast();
				}
				else {
					sb.append("error");
					return;
				}
			}
		}
		makeString(dq, right);
	}
	
	public static void makeString(ArrayDeque<Integer> dq, boolean right) {

		sb.append("[");
		if(dq.size() > 0) {
			if(right) {
				// ���� �ϳ��� �־��ְ� �� ������ ","�� �־���� ������ ���ڿ��� ó������ �ʿ䰡 ��������.
				sb.append(dq.pollFirst());		
				while(!dq.isEmpty()) {
					sb.append(",").append(dq.pollFirst());
				}
			}
			else {
				sb.append(dq.pollLast());
				while(!dq.isEmpty()) {
					sb.append(",").append(dq.pollLast());
				}
			}
		}
		sb.append("]");
	}
}
