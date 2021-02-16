package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_4375 {
	// BOJ / 4375�� / 1 / ���� / ��3
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		int n;
		
		while((input = br.readLine()) != null) {

			n = Integer.parseInt(input);
			
			int count = 1;
			int one = 1;
			
			while(true) {
				
				if(one % n == 0) {
					break;
				}
				// one�� �������� ������ ��Ÿ�� ���� (NumberFormat)������ ����
				// �̸� ���� 11,111,1111,�� �������� �����´�.
				else {
					one = (one * 10) % n + 1;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
