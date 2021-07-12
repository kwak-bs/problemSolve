package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918 {
	// BOJ / 1918�� / ���� ǥ��� / ����, �������� �˰��� / ���4
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		
		Stack<Character> op = new Stack<>();
		for(int i=0; i<input.length(); i++) {
			
			char ch = input.charAt(i);
			// ���ĺ��� �׳� ���
			if(ch >= 'A' && ch <='Z') {
				sb.append(ch);
			}
			// '('�� �׳� push
			else if(ch == '('){
				op.push(ch);
			}
			// ���ÿ��� '('�� ���� �� ���� pop
			else if(ch == ')') {
				while(!op.isEmpty()) {
					ch = op.pop();
					
					if(ch == '(') break;
					sb.append(ch);
				}
			}
			// �����ڴ� �켱������ ���ؼ� �־��ش�. 
			// ���� peek()�� �ִ� �����ڰ� ���� �����ں��� �켱 ������ ������ pop�ϰ� push �Ѵ�.
			else {
				while(!op.isEmpty() && chk_priority(op.peek()) >= chk_priority(ch)) {
					sb.append(op.pop());
				}
				op.push(ch);
			}
	
		}
		while(!op.isEmpty()) {
			sb.append(op.pop());
		}
		System.out.println(sb);
	}
	
	public static int chk_priority(char op) {
		
		if(op == '+' || op == '-') {
			return 1;
		}
		else if(op == '/' || op == '*') {
			return 2;
		}
		
		return 0;
	}
}
