package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
	// BOJ / 1107�� / ������  / �긣�� ���� / ��5
	
	static int n,m;
	static boolean broken[];
	static int min, limit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		
		// ��Ÿ�� ����(Nullpointer ����) ����
		if(m != 0) {
			stk=new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<m; i++) {
				broken[Integer.parseInt(stk.nextToken())] = true;
			}			
		}
		
		limit = (n+"").length()+1;
		min = Math.abs(n-100);
		
		// ������ ��� ��ȣŽ�� 
		for(int i=0; i<10; i++) {
			if(broken[i]) {
				continue;
			}
			dfs(1,i);
		}
		System.out.println(min);
	}
	
	public static void dfs(int depth, int ch) {
		
		if(limit < depth) {
			return;
		}
		
		// �ִ��� ���� �� �ִ� ����� ��ȣ�� �����ְ� +-ó���� depth
		min = Math.min(min, depth + Math.abs(n-ch));
		
		for(int i=0; i<10; i++) {
			if(broken[i]) {
				continue;
			}
			dfs(depth+1, (ch*10) + i);
		}
	}

}
