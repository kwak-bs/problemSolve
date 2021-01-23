package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_5568 {
	// BOJ / 5568�� / ī�� ���� / �ؽ� / ��5
	static HashSet<String> set;
	static int num[], n , k;
	static boolean visit[];
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		num = new int[n];
		set = new HashSet<>();
		sb = new StringBuilder();
		visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		// k��, ���� �ε���, ���ڿ��� �Ѱ��ش�.
		dfs(k, 0, "");
		
		// set size ���.
		System.out.println(set.size());
	}
	
	public static void dfs(int k, int index, String s) {
		
		// 2���� �� ���������� set�� �־���
		if(k == 0) {
			set.add(s);
			return;
		}
		
		for(int i=0; i<n; i++) {
			
			if(!visit[i]) {
				visit[i] = true;
				dfs(k-1, i, s+num[i]);
				// ��Ʈ��ŷ ó��
				visit[i] = false;
			}
		}
	}
}
