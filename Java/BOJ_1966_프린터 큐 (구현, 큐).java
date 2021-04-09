package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
	// BOJ / 1966�� / ������ ť / ť / �ǹ�3
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		StringBuffer sb = new StringBuffer();
		while(t-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			int p[] = new int[n];
			

			Queue<int[]> q = new LinkedList<>();
			stk = new StringTokenizer(br.readLine(), " ");
				
			for(int i=0; i<n; i++) {
				p[i] = Integer.parseInt(stk.nextToken());

				q.add(new int[] {i, p[i]});
			}	
			int ans = 0;
			while(!q.isEmpty()) {
				int now[] = q.poll();
				boolean isMax = true;
				// ���� �ִ� q�� Ž�� 
				for(int[] arr : q) {
					// ���� ���� �ִ񰪰� ���� �ִ� �켱 ������ �ִ� ��
					if(arr[1] > now[1]) {
						isMax = false;
					}
				}
				// ���� ������ �ִ��̸�
				if(isMax) {
					ans++;
					// ���� ���� �ε����� m�̸�
					if(now[0] == m) {
						sb.append(ans).append("\n");
						break;
					}
				}
				// �ִ��� �ƴϸ� �ٽ� �־���
				else {
					q.add(now);
				}
			}
		}
		System.out.println(sb.toString());
	}
}
