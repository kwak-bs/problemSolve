package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2738 {
	// BOJ / 2738�� / ��� ���� / ����, ����/ ��1
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int map1[][] = new int[y][x];
		int map2[][] = new int[y][x];
		int result[][] = new int [y][x];
		
		// map1 �Է�	
		for(int i = 0 ; i<y; i++) {
			st = new StringTokenizer(br.readLine(), " ");				
			for(int j = 0; j<x; j++) {
				map1[i][j] = Integer.parseInt(st.nextToken()); 
			}		
		}
		
		// map2 �Է�
		for(int i =0; i<y; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j<x; j++) {
				map2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ��� ����
		for(int i =0; i<y; i++) {
			for(int j=0; j<x; j++) {
				result[i][j] = map1[i][j] + map2[i][j];
			}
		}
		
		// result ���
		for(int i =0; i<y; i++) {
			for(int j =0; j<x; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
