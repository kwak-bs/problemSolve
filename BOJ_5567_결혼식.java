package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5567 {
	//BOJ / 5567�� / ��ȥ��  / ����, �׷��� �̷�, �׷��� Ž��, �ʺ� �켱 Ž��  / ��1
	
	static int n; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int [][] friends = new int[n+1][n+1];
		boolean [] visit = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friends[a][b] = 1;  //ģ�� ���� ���� 
			friends[b][a] = 1;
		}
		
		System.out.println(solution(friends, visit));
	}
	
	static int solution(int[][] friends, boolean[] visit ) {
		int count = 0;
		
		for(int i=1; i<=n; i++) {
			if(friends[1][i] == 1) {
				if(!visit[i]) { // ���� ģ���� count
					visit[i] = true;
					count++;
				}
				for(int j=2; j<=n; j++) { // ���� ģ���� ģ���� count
					if(friends[i][j] == 1 && !visit[j]) {
						visit[j] = true;
						count++;
					}
				}
			}
		}
		return count;
	}
}
