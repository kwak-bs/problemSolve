package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14225 {
	// BOJ / 14225�� / �κм����� �� / ��� / ���5
	
	static int a[];
	static boolean b[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");	
		

		a = new int[n];
		int sum = 0;
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
			sum += a[i];
		}
		// ���� �� �ִ� �ִ�� ���� �� ���� �����ϹǷ� +2 ���ش�. 
		b = new boolean[sum +2];
		
		go(0 ,0);
		
		for(int i=1; i<b.length; i++) {
			if(!b[i]) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static void go(int index, int sum) {
		
		if(index == a.length) {
			b[sum] = true;
			return;
		}
		go(index + 1, sum+ a[index]);
		go(index + 1, sum);
	}
}
