package problemSolve;

import java.util.Scanner;

public class BOJ_5554 {
	// BOJ / 5554�� / �ɺθ� ���� �� / ����, ��Ģ����, ���� / ��5
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0; i<4; i++) {
			int seconds = sc.nextInt();
			sum += seconds;
		}
		
		System.out.println(sum / 60);
		System.out.println(sum % 60);
	}
}
