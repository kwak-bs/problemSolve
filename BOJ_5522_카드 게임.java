package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5522 {
	// BOJ / 4963�� / ī�� ���� / ����, ��Ģ���� / ��5
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			int num = Integer.parseInt(br.readLine());
			
			sum += num;
		}
		
		System.out.println(sum);
	}
}
