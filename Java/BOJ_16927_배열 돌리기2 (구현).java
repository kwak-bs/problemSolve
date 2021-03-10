package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16927 {
	// BOJ / 16927�� / �迭 ������ 2 / ���� / �ǹ�1
	static int y,x, r;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		r = Integer.parseInt(stk.nextToken());
		int map [][] = new int[y][x];
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
		int groupn = Math.min(y, x) / 2 ;
		
		// �� �׷��� �̵��� ��� ���� 1���� ����Ʈ�� �־��ش�.
		for(int k=0; k<groupn; k++) {
			ArrayList<Integer> group = new ArrayList<>();
			
			// ù ��
			for(int j=k; j<x-k; j++) {
				group.add(map[k][j]);
			}
			
			// ������ �� ( k+1 ~ y-k-1����)
			for(int i=k+1; i<y-k-1; i++) {
				group.add(map[i][x-k-1]);
			}
			
			// ������ �� 
			for(int j=x-k-1; j>k; j--) {
				group.add(map[y-k-1][j]);
			}
			
			// ù ��
			for(int i=y-k-1; i>k; i--) {
				group.add(map[i][k]);
			}
			groups.add(group);
		}
		// rĭ ��ŭ ȸ����Ų��. 
		for(int k=0; k<groupn; k++) {
			ArrayList<Integer> group = groups.get(k);
			int len = group.size();
			int index = r % len; // ������ �迭�� ���̸�ŭ ���� �Ȱ��� �迭�� �ǹǷ�, �迭�� ���̸�ŭ �����ָ� �ȴ�.
			
			// �״�� �־��ش�.
			// ù ��
			for(int j=k; j<x-k; j++, index = (index + 1) % len) {
				map[k][j] = group.get(index);
			}
			
			// ������ �� ( k+1 ~ y-k-1����)
			for(int i=k+1; i<y-k-1; i++, index = (index + 1) % len) {
				map[i][x-k-1] = group.get(index);
			}
			
			// ������ �� 
			for(int j=x-k-1; j>k; j--, index = (index + 1) % len) {
				map[y-k-1][j] = group.get(index);
			}
			
			// ù ��
			for(int i=y-k-1; i>k; i--, index = (index + 1) % len) {
				map[i][k] = group.get(index);
			}
		}
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
