package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	//BOJ / 1697�� / ���ٲ��� / �׷���, BFS / ��1
	
	static int n;
	static int k;
	static int[] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken()); // ������ ��ġ 
		k = Integer.parseInt(st.nextToken()); // ���� ��ġ
		map = new int [100001];	
		
		if( n == k) {
			System.out.println("0");
		} else {
			bfs(n);
			System.out.println(map[k]);
		}
	}
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		map[n] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(map[k] != 0) { // ���� ��ġ�� 0�� �ƴ϶�� �ּڰ��� ã�� �� 
				break;
			}
			if((now-1>=0) && map[now-1] == 0) { // -1 �̵�
				map[now-1] = map[now] + 1;
				q.offer(now-1);
			}
			if((now+1<map.length) && map[now+1] == 0) { // +1 �̵�
				map[now+1] = map[now] + 1;
				q.offer(now+1);
			}
			if((2 * now<map.length) && map[2*now] == 0) { // *2 �����̵�
				map[now * 2] = map[now] + 1;
				q.offer(now * 2);
			}
		}
	}
}