package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
	// BOJ / 1238�� / ��Ƽ / ���ͽ�Ʈ��  / ���3
	static final int INF = 987654321;
	static int n,m,x;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken()); // �л�
		m = Integer.parseInt(stk.nextToken()); // ����
		x = Integer.parseInt(stk.nextToken())-1; // ������ , 0���� �����Ұ���
		
		ArrayList<Edge> []graph = new ArrayList[n];
		ArrayList<Edge> []reverse_graph = new ArrayList[n];
		for(int i=0; i<n; i++) {
			graph[i] = new ArrayList<>();
			reverse_graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(stk.nextToken()) - 1;
			int b = Integer.parseInt(stk.nextToken()) - 1;
			int c = Integer.parseInt(stk.nextToken());
			
			graph[a].add(new Edge(b,c)); // �־��� �Է� 
			reverse_graph[b].add(new Edge(a,c)); // �־��� �Է� �ݴ�� 
		}
		// �ܹ������� �Է��� �־����� ������ �պ��� �ذ��ϴ� ���������� �ܹ��� �׷����� ���������ε� ������ �� 
		// �������� �������� �� ����� ���� �����ָ� �ּ� �պ� �Ÿ��� ���� �� �ִ�. 
		
		int dist1[] = dijkstra(graph); // x���� �ٸ� ���� �ִܰŸ�
		int dist2[] = dijkstra(reverse_graph); // �ٸ� ���鿡�� x���� �ִ� �Ÿ�
		int answer = 0;
		for(int i=0; i<dist1.length; i++) {
			answer = Math.max(answer, dist1[i] + dist2[i]);
		}
		System.out.println(answer);
	}	
	public static int[] dijkstra(ArrayList<Edge> town[]) {
		
		int dist[] = new int[n];
		Arrays.fill(dist, INF);
		dist[x] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w;
			}
		});
		pq.add(new Edge(x, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			for(int i=0; i<town[now.v].size(); i++) {
				Edge next = town[now.v].get(i);
				
				if(dist[next.v] > dist[now.v] + next.w) {
					dist[next.v] = dist[now.v] + next.w;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
		}
		return dist;
	}
	private static class Edge {
		int v,w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}