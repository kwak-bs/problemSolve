package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11437 {
	// BOJ / 11437�� / LCA / Ʈ�� / ���3
	static int n, m, answer;
	static ArrayList<Integer>[] list, tree ; 
	static int parent[], depth[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		n = Integer.parseInt(br.readLine()); // ��� ����
		parent = new int [n+1];
		depth = new int [n+1];
		list = new ArrayList[n+1];
		tree = new ArrayList[n+1];
			
		for (int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		for(int i=1; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			// ����� �׷���
			list[a].add(b);
			list[b].add(a);
		}
		
		makeTree(1, -1, 1);
		

		m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			
			findSameParent(n1, n2);
			
			System.out.println(findSameParent(n1,n2));
		}
	}
	
	// ����� �׷����� �������� Ʈ�� ����
	public static void makeTree(int curNode, int p, int dep) {
		
		for(int node : list[curNode]) {
			// �θ� ������ �ڽĵ��� �־��ش�. 
			if(node != p) {
				tree[curNode].add(node);
				parent[node] = curNode;
				depth[node] = dep;
				makeTree(node, curNode, dep+1);
			}
		}
	}
	
	public static int findSameParent(int node1, int node2) {
		
		// ���� ������ �����. a�� �� �ؿ� ���� ���
		while(depth[node1] > depth[node2]) {
			node1 = parent[node1];
		}
		
		// b�� �� �ؿ� ���� ���
		while(depth[node2] > depth[node1]) {
			node2 = parent[node2];
		}
		
		// ���� ���ε� ���� ���� ��� (�θ� �ٸ��ٸ�) �θ� ã�� ������ �ݺ�.
		while(node1 != node2) {
			node1 = parent[node1];
			node2 = parent[node2];
		}
			
		return node1;
	}
}
