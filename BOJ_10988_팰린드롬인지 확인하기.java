package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {
	//BOJ / 10988�� / �Ӹ�������� Ȯ���ϱ� / ����, ���ڿ� / ��1
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int result = 0;
		if(line.length() == 1) { // �Է� ���̰� 1 �̸� ������ �Ӹ����
			result = 1;
		}
		for(int i=0; i<line.length()/2; i++) { // ���ݱ����� ���Ƶ���
			if(line.charAt(i) == line.charAt(line.length() - i -1)) {
				result = 1;
			}
			else {
				result = 0; // �Ӹ������ �ƴ϶�� �ѹ� �������� �ٷ� break;
				break;
			}
		}
		
		System.out.println(result);
	}
}
