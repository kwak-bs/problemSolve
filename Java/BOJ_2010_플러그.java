package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2010 {
	// BOJ / 2010�� / �÷��� / ����, ����, ��Ģ���� / ��3
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		for(int i=0; i<tc; i++) {
			int input = Integer.parseInt(br.readLine());
			
			ans += input;
		}
		System.out.println(ans-(tc-1));  // ��Ģ ã���� ���� 
	}
}
