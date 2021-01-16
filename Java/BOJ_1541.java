package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1541 {
	// BOJ / 1541�� / �Ҿ���� ��ȣ / ����, �׸��� �˰���, ���ڿ�, �Ľ�/ �ǹ� 2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//���� �Է¹޴´�.
		String exp = br.readLine();
		String [] arr = exp.split("\\-");
		int answer = cal(arr[0]); // ù -�� ������ ������ ���ڵ� +�� �����ϰ� �ִ� ���̵� cal �޼���� ������.

		for(int i=1; i<arr.length; i++) {
			answer -= cal(arr[i]); // arr[0]�� ������ �迭�� ���� - �������̱� ������ ���ش�.
		}
		System.out.println(answer);
	}
	
	public static int cal(String exp) { // + ���
		String [] temp = exp.split("\\+");
		int result = 0;
		
		for(int i=0; i<temp.length; i++) {
			result += Integer.parseInt(temp[i]);
		}
		
		return result;
	}
}
