package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {
	// BOJ / 1072�� / ���� / �̺� Ž�� / �ǹ�3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		
		long x = Integer.parseInt(stk.nextToken());
		long y = Integer.parseInt(stk.nextToken());
		
		long z = y*100 / x;
		// �·��� 99�̻��̸� �ƹ��� ������ ���ص� Ȯ���� ������ ����.
		if(z >= 99) {
			System.out.println("-1");
		}
		else {
			long left = 1;
			long right = x; // x�� ���� �� ���� Ȯ���� ������ ������ 
			while(left <= right) {
				// mid�� ���� Ƚ��
				long mid = (left + right) / 2;
				long zz = (y+mid)*100/ (x+mid) ;
				if(zz > z) {
					right = mid - 1;
				}
				
				else {
					left = mid + 1;
				}
			}
			// zz�� ���ų� ������ left�� ����. ���������� ���ҵ� mid(���� Ƚ��)���� +1 �ϸ��. 
			System.out.println(left);			
		}
	}
}
