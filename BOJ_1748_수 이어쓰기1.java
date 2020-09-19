package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {
	// BOJ / 1748�� / �� �̾��1 / ����, ����, ��Ģ���� / ��3
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		int num = 10;
		int length = 1;
		int ans = 0;
		
		for(long i = 1; i<=input; i++) {
			if(i == num) {
				length++;
				num = num * 10;
			}
			ans += length ;
		}
		System.out.println(ans);
	}
}
