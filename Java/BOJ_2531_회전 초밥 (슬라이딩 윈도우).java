package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2531 {
	// BOJ / 2531�� / ȸ�� �ʹ� / �����̵� ������ / �ǹ�1
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		// ������ ��
		int n = Integer.parseInt(stk.nextToken());
		// �ʹ��� ���� ��
		int d = Integer.parseInt(stk.nextToken());
		// �����ؼ� �Դ� ������ �� 
		int k = Integer.parseInt(stk.nextToken());
		// ���� ��ȣ
		int c = Integer.parseInt(stk.nextToken());
		int v[] = new int[d+1];
		int arr[] = new int[n];
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// ������
		int total = 0;
		for(int i=0; i<k; i++) {
			if(v[arr[i]] == 0) total++;
			v[arr[i]]++;
		}
		// �ִ� ������ �ʱ�ȭ
		int max = total;
		for(int i=1; i<n; i++) {
			if(max <= total) {
				if(v[c] == 0) max = total + 1;
				else max = total;
			}
			// �����̵� ������(���̴� ������)
			// ���� �ֱٿ� ���� ���� ���� ���� ���� ���� �߰�
			v[arr[i-1]]--;
			if(v[arr[i-1]] == 0) total--;
			
			if(v[arr[(i+k-1)%n]] == 0) total++;
			v[arr[(i+k-1)%n]]++;
		}
		System.out.println(max);
	}
}
