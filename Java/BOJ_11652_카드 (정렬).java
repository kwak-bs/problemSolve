package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_11652 {
	// BOJ / 11652�� / ī�� / ���� / �ǹ� 4
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		long card [] = new long[n];
		
		for(int i=0; i<n; i++) {
			card[i] = Long.parseLong(br.readLine());
		}
		// �������� �����̹Ƿ�, ���� ������ ���� ī���� ������ ���� ���� answer�� ������.
		Arrays.sort(card);
		
		int count = 1; // �ּ� 1���� �����ϱ� ����
		int max = 1; 
		
		// ó���� 0���� �ʱ�ȭ ���ٶ�� �ߴٰ� �����غ��� 
		// ��� ī����� 1�徿 �ۿ� ������ 0�� ��µ� �׷��� 
		// ù ��° �ε����� �ʱ�ȭ
		long answer = card[0];
		
		for(int i=1; i<n; i++) {
			// �� ���� ī��� ���� ī��� count ����
			if(card[i] == card[i-1]) {
				count++;
			} else {
				// �ƴϸ� �ٽ� 1�� �ʱ�ȭ.
				count = 1;
			}
			
			if(max < count ) {
				max = count;
				answer = card[i];
			}
		}
		
		System.out.println(answer);
	}
}

