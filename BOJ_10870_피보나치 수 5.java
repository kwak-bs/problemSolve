package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870 {
	//BOJ / 10870�� / �Ǻ���ġ �� 5 / ����, DP / ��2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n == 0) { // 0 ����ó��. ���ϸ� ��Ÿ�� ������ 
			System.out.println(0);
			return;
		}
		
		int f[] = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		
		for(int i=2; i<f.length; i++) {
			f[i] = f[i-2]+f[i-1];
		}

		if(n == 1) {
			System.out.println(1);
		} else {
			System.out.println(f[n]);			
		}
	}
}
