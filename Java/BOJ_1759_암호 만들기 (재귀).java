package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	// BOJ / 1759�� / ��ȣ ����� / ���Ʈ���� / ��5
	
	static String print[], list[];
	static int l,c;
	static StringBuffer sb;
	static String vowe[] = {"a","e","i","o","u"}; // ����
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		l = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		print = new String[l];
		list = new String[c];
		sb = new StringBuffer();
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<c; i++) {
			list[i] = stk.nextToken();
		}
		// ���������� ����.
		Arrays.sort(list);
		
		recursion(0,0);
		
		System.out.println(sb);
	}
	
	public static void recursion(int depth, int start) {
		
		if(depth == l) {
			int consonants = 0; // ����
			int vowels = 0; // ����
			boolean ok = false; // ���� ���� ������ �����ϴ� ����.
			
			for(String value : print) {
				boolean isvowel = false; // �������� �������� �Ǻ��ϴ� ����.
				
				for(int i=0; i<vowe.length; i++) {
					if(value.equals(vowe[i])) {
						vowels++;
						isvowel = true;
						break;
					}						
				}
				if(!isvowel) {
					consonants++;					
				}
				
				if(vowels>=1 && consonants >= 2) {
					ok = true;
					break;
				}
			}

			if(ok) {
				for(String value : print) {
					sb.append(value);										
				}
				sb.append("\n");
			}
			return;
		}
		
		//visit�� ���� �ʿ䰡 ����. ������ �������� �����̰� 
		// ���� �ε����� ����� ���ڷ� �޾��ָ� �Ǳ� ����.
		for(int i=start; i<list.length; i++) {
			print[depth] = list[i];
			recursion(depth + 1, i+1);
			
		}
	}
}
