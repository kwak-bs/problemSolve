package problemSolve;

import java.util.Scanner;

public class BOJ_2443 {
	//BOJ / 2231�� / �� ��� - 6 / ���� / ��3
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) { // n��ŭ ����
			for(int k=n-i; k<n; k++) { // �տ� ����
				System.out.print(" ");
			}
			for(int j=i; j<2*n-i-1; j++) { // ����� 
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
