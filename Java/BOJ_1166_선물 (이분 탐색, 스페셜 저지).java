package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1166 {
	// BOJ / 1166�� / ���� / �̺� Ž�� / �ǹ�3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		long n = Integer.parseInt(stk.nextToken());
		long l = Integer.parseInt(stk.nextToken());
		long w = Integer.parseInt(stk.nextToken());
		long h = Integer.parseInt(stk.nextToken());
		
		double left = 0;
		// ���簢���� �� ���� ���簢���� ���� ���� ������ Ŭ �� ����. 
		double right = Math.min(l, Math.min(w, h));
		double answer = Double.MIN_VALUE;
		
		// ���� 50000�� �ȿ��� �� ���̶� �Ǵ��ϰ� �׽�Ʈ�غôµ� ����ƴ�.
		int time = 50000;
		
		while(time-- > 0) {
			// mid�� ���簢���� �� �� 
			double mid = (left + right) / 2;
			
			long total = (long)(l / mid) * (long)(w / mid) * (long)(h / mid);
			
			// ���簢���� ������ n���� ���ų� ������ left = mid�̴�. 
			// mid�� �ڷ����� int�� �ƴ� double���̶� �Ϲ����� +1,-1�� �� �� ���� while���� ���� ���� �Ժη� �ɾ��� �� ����. 
			if(total >= n) {
				left = mid;
				answer = Math.max(mid, answer);
			}
			else {
				right = mid;
			}
		}
		System.out.println(answer);
	}
}
