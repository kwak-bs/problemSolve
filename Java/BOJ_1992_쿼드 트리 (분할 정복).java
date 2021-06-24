package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
	// BOJ / 1992�� / ����Ʈ�� / ���� ���� / �ǹ�1
	static StringBuilder sb = new StringBuilder();
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
	
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		go(0,0,n);
		System.out.println(sb);
	}
	
	public static void go(int r, int c, int size) {
		
		if(check(r, c, size)) {
			if(map[r][c] == 0) {
				sb.append(map[r][c]);
			}
			else {
				sb.append(map[r][c]);
			}
			
			return;
		}
		int newSize = size / 2;
		// ��� ����, ����
		// �����Ҷ� ��ȣ �����ش�
		sb.append("(");
		go(r, c , newSize);
		go(r, c+newSize, newSize);

		// �ϴ� ����, ����
		go(r+newSize, c, newSize);
		go(r+newSize, c+newSize, newSize);
		// ������ ��ȣ �ݾ���
		sb.append(")");
	}
	
	public static boolean check(int r, int c, int size) {
		
		int color = map[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j] != color) return false;
			}
		}
		return true;
	}
}
