package problemSolve;

import java.util.Scanner;

public class BOJ_1789 {
	// BOJ / 1789�� / ������ �� / �̺� Ž�� / ��5
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong(); // n�̶� ���� �ٸ� n���� �ڿ����� ������ �ǹ��Ѵ�. ��, �տ� ���Ǵ� �ڿ����� �ִ� �����̴�.
		long sum = 0;
		long num = 0;
		
		while(sum <= n) { // n�� �ѱ�� break;
			num++;
			sum += num;
		}
		
		System.out.println(num-1);
	}
}
