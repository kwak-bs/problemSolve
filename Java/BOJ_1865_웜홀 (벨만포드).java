package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865 {
	// BOJ / 1865�� / ��Ȧ / �׷��� / ���4
	static ArrayList<Road> graph[];
	static int INF = 987654321, n,m,w;
	static int[] dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			 stk = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			w = Integer.parseInt(stk.nextToken());
			graph = new ArrayList[n+1];
			dist = new int[n+1];
			for(int i=0; i<graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<m; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(stk.nextToken());
				int e = Integer.parseInt(stk.nextToken());
				int tt = Integer.parseInt(stk.nextToken());
				
				graph[s].add(new Road(e, tt));
				graph[e].add(new Road(s,tt));
			}
			
			for(int i=0; i<w; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(stk.nextToken());
				int e = Integer.parseInt(stk.nextToken());
				int tt = Integer.parseInt(stk.nextToken());
				
				graph[s].add(new Road(e,-tt));
			}
			
			boolean isMinus = false;
			
			for(int i=1; i<=n; i++) {
				
				if(bellmanFord(i)) {
					isMinus = true;
					sb.append("YES\n");
					break;
				}
			}
			
				
			if(!isMinus) {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static boolean bellmanFord(int start) {
		
		Arrays.fill(dist, INF);
		dist[start] = 0; // ������� 0���� �ʱ�ȭ
		boolean update = false;
		
		// (������ ���� -1)�� ���� �ִ� �Ÿ� �ʱ�ȭ �۾��� �ݺ��Ѵ�.
		for(int i=1; i<n; i++) {
			update = false;
			
			//�ִ� �Ÿ� �ʱ�ȭ
			for(int j=1; j<=n; j++) {
				for(Road road : graph[j]) {
					if(dist[j] != INF && dist[road.end] > dist[j] + road.weight) {
						dist[road.end] = dist[j] + road.weight;
						update = true;
					}
				}
			}
			
			if(!update) break;
		}
		
		// (������ ���� -1)�� ���� update�� �߻��ߴµ� �� update�� �߻��ϸ� ���� ����Ŭ�� �Ͼ ���� �ǹ��Ѵ�. 
		if(update) {
			for(int i=1; i<=n; i++) {
				for(Road road : graph[i]) {
					if(dist[i] != INF && dist[road.end] > dist[i] + road.weight) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	static private class Road {
		int end;
		int weight;
		Road(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

	}
}
