package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10823 {
	//BOJ / 10823�� / ���ϱ� 2 / ���ڿ� / ��2
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		int sum = 0;
		
		// bufferedReader while������ null�� ���� �Է¹޴� ��� ( EOF ó�� ���� �� �����ϱ� )
		while((line = br.readLine()) != null) { // ctrl + z �� �Էµ� �� ���� �Է� ����( ctrl + z = null��)
			sb.append(line.toString());
		}

		for(String num : sb.toString().split(",")) {
			sum += Integer.parseInt(num);
		}
		System.out.println(sum);
	}
}
