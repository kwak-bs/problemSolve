package problemSolve2;

import java.util.Scanner;

public class BOJ_17427 {
	// BOJ / 17427�� / ����� �� 2  / ���� / ��3
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long gsum = 0;
		
		// n���� ������ ��� ����� ���� 
		// 1���� n������ ���� i�� �����ϸ� 
		// n���� ���� ���� i�� �����ְ� �����ָ� �ȴ�. 
		for(int i=1; i<=n; i++) {
			
			int tmp = n / i;
			
			gsum += (tmp * i);
		}
		System.out.println(gsum);
	}
}
