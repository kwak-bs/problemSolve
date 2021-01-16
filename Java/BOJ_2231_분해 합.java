package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {
	//BOJ / 2231�� / ���� �� / ���Ʈ���� �˰��� / ��2
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int ans = 0; 
		
		// �Է� ������ �� ������ �� ����.(�긣������)
		for(int i = 0; i < input; i++) {
			int num = i;
			int sum = 0;
			
			// num��  0�̻��̸�
			while(num > 0) {
				sum += num % 10; // �� �ڸ����� ���� sum�� �����ش�.
				num /= 10; // ���� ���� (i)�� �Ȱ��� �����ش�.
			}
			
			if( sum + i == input) { // �� �ڸ����� ��(sum)�� ���� ��(i)�� ���� input�� ������
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
