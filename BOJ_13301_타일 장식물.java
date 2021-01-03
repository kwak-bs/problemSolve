package problemSolve;

import java.util.Scanner;

public class BOJ_13301 {
	//BOJ / 13301�� /  Ÿ�� ��Ĺ� / DP / ��1
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// n�� 1���� �Է�
		int n = sc.nextInt();
		
		long dpRound[] = new long[n]; // �ѷ� ����
		
		dpRound[0] = 4;
		
		if(n > 1 ) { // n�� 1 �̻��� �� 
			dpRound[1] = 6;
		}
		
		for(int i=2; i<n; i++) { // dp
			dpRound[i] = dpRound[i-2] + dpRound[i-1];
		}
		
		System.out.println(dpRound[n-1]);
	}
}
