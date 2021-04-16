package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5566 {
	// BOJ / 5566�� / �ֻ��� ���� / ���� / �����2
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken()); // ���û��� 
		int m = Integer.parseInt(stk.nextToken()); // �ֻ���
		int [] dir = new int[n+1];
		int [] dice = new int [m];
		
		for(int i=1; i<dir.length; i++) {
			dir[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<m; i++) {
			dice[i] = Integer.parseInt(br.readLine());
		}
		int board[] = new int[2001];
		int t = 1001;
		n += 1000;

		int cnt = 0;
		for(int i=0; i<dice.length; i++) {
			cnt++;
			t-=1000;
			int p = dice[i]; // �ֻ��� ���� ������.
			t += p; // �ֻ��� ��ŭ �̵� 
			if(t+1000 >= n) break; // �̵����ڸ��� �Ѿ�������� 
			t += dir[t]; // �ֻ����� �̵��� ��ġ�� ���ø� ���� 
			t+=1000;
			if( t >= n) break;
		}
		System.out.println(cnt);
	}
}
