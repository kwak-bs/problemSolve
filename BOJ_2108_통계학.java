package problemSolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2108 {
	// BOJ / 2108�� / ����� / ����, ���� / ��4
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		//�Է�
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 1. ��� ��� ,�Ҽ��� ���� ù° �ڸ����� �ݿø��� ���� ����Ѵ�.
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += arr[i];
		}
		System.out.println((int)Math.round((double)sum / n));
		
		// 2.�߾Ӱ�
		Arrays.sort(arr);
		System.out.println(arr[arr.length/2]);
		
		// 3.�ֺ� , ���� �� ���� ������ �ֺ� �� �� ��°�� ���� ���� ����Ѵ�.
		int [] freq = new int [8001];

		int maxFreq = 0;
		int maxIdx = 0;
		boolean flag = false;
		
		// �� �κп��� �ϳ� ����� ���� for�� (int j =0; j<freq.lenth)�� ������ �� ��û�� �Ǽ�����.
		for(int i=0; i<arr.length; i++) {
			freq[arr[i]+4000]++;
			if(maxFreq < freq[arr[i]+4000]) {
				maxFreq = freq[arr[i]+4000];
			}
		}

		for(int i=0; i<freq.length; i++) {
			if(freq[i] == maxFreq) {
				if(flag) { // true�ϰ�� , �� 2��°�� ���
					maxIdx = i-4000;
					break;
				}
				maxIdx = i-4000; 
				flag = true; // ������ 2��°�� �ִ�󵵰��� �ƴϴ��� if(freq[i] == maxFreq)�� ������ �ʱ� ������ if���� �ٽ� ���� �� ����.
			}
		}
		if(n == 1) {
			System.out.println(arr[0]);
		} else {
			System.out.println(maxIdx);			
		}
		
		// 4. ����
		System.out.println(arr[arr.length-1] - arr[0]);
	}
}
