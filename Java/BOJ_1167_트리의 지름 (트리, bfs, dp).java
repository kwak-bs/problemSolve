package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1167 {
	// BOJ / 1167�� / Ʈ���� ���� / Ʈ�� / ���3
	
	static ArrayList<Node> list[];
	static int n;
	static int dp[];
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList [n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Node>();
		}

		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int index = Integer.parseInt(stk.nextToken());

			while(true) {
				
				int to = Integer.parseInt(stk.nextToken());

				if(to == -1) {
					break;
				}
				
				int weight = Integer.parseInt(stk.nextToken());

				// ����� �׷���
				list[index].add(new Node(to, weight));

			}
		}
		
		// ��Ʈ ��带 ���۳��� �Ͽ� ����ġ�� ���� ���� ū, �� ���� �� ���� ��带 ã�´�.
		visit = new boolean[n+1];
		dp = new int[n+1];
		bfs(1);
		int maxNodeIndex = 0;
		int max = 0;
		for(int i=1; i<=n; i++) {
			if(max < dp[i]) {
				max = dp[i];
				maxNodeIndex = i;
			}
		}
		
		// maxNodeIndex�� ���۳��� �Ͽ� ���� �� �� �������� Ʈ���� ������ �ȴ�.
		visit = new boolean[n+1];
		dp = new int[n+1];
		int ans = 0;
		bfs(maxNodeIndex);
		
		for(int i=1; i<=n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
	
	public static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);

		while(!q.isEmpty()) {
 
			int now = q.poll();
			visit[now] = true;
			
			for(Node link : list[now]) {	
				if(!visit[link.to]) {
					q.add(link.to);
					
					// ����� ����� ����ġ = ���� ����ġ���� �� + ���� ������ ����ġ.
					dp[link.to] += (dp[now] +link.weight);
				}
			}
		}
	}
}


class Node {
	int to;
	int weight;
	
	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
	
}
