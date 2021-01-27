package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1790 {
	// BOJ / 1790�� / �� �̾� ���� 2 / ����, ���� / ��1
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		long n = Integer.parseInt(stk.nextToken());
		long k = Integer.parseInt(stk.nextToken());
		
		long temp = k;
		long nCount = 9;
		long nLength = 1;
		long num = 0;
		
		while(temp > nCount * nLength) {
			temp -= nCount * nLength;
			
			num += nCount;
			
			nCount *= 10;
			nLength += 1;
			
		}
		
		// ���������� num���� ���ڰ� ���δ�. 
		// k�� 1���� �����ϱ� ������ 0���� �����ϴ� �迭�� �°� -1 ���ش�.
		num = (num + 1) + (temp-1) / nLength ;
		
		if(num > n) {
			System.out.println(-1);
		}
		else {
			int index = (int)((temp-1) % nLength);
			System.out.println(Long.toString(num).charAt(index));
		}
	}
}
