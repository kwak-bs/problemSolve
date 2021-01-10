package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
	// BOJ / 5014�� / ��ŸƮ��ũ / �׷��� / ��5
	
	static int f,s,g,u,d;
	static boolean visit[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		
		f = Integer.parseInt(stk.nextToken()); // ������ ����(���� ���� ��)
		s = Integer.parseInt(stk.nextToken()); // ��ȣ�� �ִ� ��
		g = Integer.parseInt(stk.nextToken()); // ��ŸƮ��ũ�� �ִ� ��
		u = Integer.parseInt(stk.nextToken()); // up
		d = Integer.parseInt(stk.nextToken()); // down
		
		visit = new boolean[f+1];
		System.out.println(bfs(s));
	}
	
	public static String bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		visit[s] = true;
		q.offer(s);
		int count = 0;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			while(qSize-- > 0) { // �ѹ� �����϶����� count
				int now = q.poll();

				if(now == g) { // ���� ��ġ�� ��ŸƮ��ũ ���̸� return
					return String.valueOf(count);
				}
				
				// up 
				int up = now + u;
				if(up <= f  && !visit[up]) {
					q.offer(up);
					visit[up] = true;
				}
				
				// down
				int down = now - d;
				if( down > 0 && !visit[down]) {
					q.offer(down);
					visit[down] = true;
				}
				
			}
			count++;
		}
		
		return "use the stairs";
	}
}
