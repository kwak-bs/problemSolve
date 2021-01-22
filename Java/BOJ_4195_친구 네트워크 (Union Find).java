package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195 {
	//BOJ / 4195�� / ģ�� ��Ʈ��ũ  / �ؽ� / ��2
	static HashMap<String, Integer> map;
	static int parent[], relation[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			parent = new int[n*2]; // �θ� ���� �迭 
			relation = new int [n*2]; // ���� �� ���� �迭
			
			for(int i=0; i<n*2; i++) {
				parent[i] = i;
				relation[i] = 1; // ��� ����� 1�� �ʱ�ȭ.
			}
			
			int idx = 0; // �θ��ε����� ģ�� �ε����� ���� ���ش�. 
			map = new HashMap<>();
			for(int i=0; i<n; i++) {
				stk= new StringTokenizer(br.readLine(), " ");

				String s1 = stk.nextToken();
				String s2 = stk.nextToken();
				
				// �̹� ���ִ� ģ�� �̸��̸� pass.
				if(!map.containsKey(s1)) { 
					map.put(s1, idx++);
				}
				if(!map.containsKey(s2)) {
					map.put(s2, idx++);
				}
				sb.append(union(map.get(s1), map.get(s2)) +"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	public static int union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		// �̹� �̾��� ģ�� ����� relation[p1 || p2] �ƹ��ų� ��ȯ�Ѵ�.
		if(p1 == p2) {
			return relation[p2];
		}
		if(p1 > p2) {
			parent[p1] = p2;
			// �� ���������� �θ��� �����Ǵµ�, ���������� ���� �迭�� �� ���� �� �ε����� �����ش�.
			relation[p2] += relation[p1];
			return relation[p2];
		}
		else {
			parent[p2] = p1;
			relation[p1] += relation[p2];
			return relation[p1];
		}
	}
}
