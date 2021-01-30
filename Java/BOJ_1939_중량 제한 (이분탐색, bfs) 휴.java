package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939 {
	// BOJ / 1939�� / �߷����� / �̺� Ž�� / ���4
	
	static int n, m, maxlimit, ans;
	static ArrayList<islands> islands[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		islands = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			islands[i] = new ArrayList<islands>();
		}
		
		for(int i =0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int limit = Integer.parseInt(stk.nextToken());
			
			// ����� �׷���
			islands[from].add(new islands(to, limit));
			islands[to].add(new islands(from, limit));
			maxlimit = Math.max(maxlimit, limit);
			
		}
		

		stk = new StringTokenizer(br.readLine(), " ");
		int Fa = Integer.parseInt(stk.nextToken());
		int Fb = Integer.parseInt(stk.nextToken());
		
		findMaxWeight(Fa,Fb);
		
		System.out.println(ans);
	}
	
	public static void findMaxWeight(int FactoryA, int FactoryB) {
		
		int start = 1;
		int end = maxlimit;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		boolean visit[] = new boolean[n+1];
		
		while(start <= end ) {
			int mid = (start + end) / 2;
			
			q.add(FactoryA);
			visit[FactoryA] = true;
			// �ش� �߷��� �ű�� �ִ� ���� �ִ�.
			if(checkRoute(q, visit, mid, FactoryB)) {
				ans = Math.max(ans,  mid);
				start = mid + 1;
			}
			// ����.
			else {
				end = mid - 1;
			}
			// ��θ� üũ�ϰ� �ٽ� �ʱ�ȭ.
			q.clear();
			Arrays.fill(visit, false);
		}
	}
	
	public static boolean checkRoute(Queue<Integer> q, boolean[] visit ,int mid,int FactoryB) {
		// bfs�� ���Ͽ� ��θ� üũ�Ѵ�.
		while(!q.isEmpty()) {
			int now = q.poll();
			
			//System.out.println("now : "  + now);

			
			for(islands island : islands[now]) {
				// �̵��� ���� �ٸ��� �߷� ������ ����ϸ�
				if(island.limit >= mid) {
					
					// �̵��� ���� �������̸� true ��ȯ.
					if(island.end == FactoryB) {	

						return true;
					}
					
					// �������� �ƴϸ� q�� �߰� 
					if(!visit[island.end]) {
						//System.out.println("visit end :" + island.end);
						visit[island.end] = true;
						q.add(island.end);
					}
				}
			}
		}
		
		return false;
	}
}

class islands {
	int end, limit;
	
	islands (int end, int limit) {
		this.end = end;
		this.limit = limit;
	}
}
