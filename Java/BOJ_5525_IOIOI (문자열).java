package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525 {
	// BOJ / 5525�� / IOIOI / ���� ���� / �ǹ�2
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		char arr [] = br.readLine().toCharArray();
		
		int count = IOIOI(arr, n, m);
		
		System.out.println(count);
	}
	
	public static int IOIOI(char[] arr, int n, int m) {
		int answer = 0;
		int patternCnt = 0;
		
		for(int i=1; i<m-1; i++) {
			if(arr[i-1] == 'I' && arr[i] == 'O' && arr[i+1] == 'I') {
				patternCnt++;
				
				if(patternCnt == n) {
					answer++;
					patternCnt--; // ���� �ε����� ������ Ȯ�� �� �� �ߺ��ǹǷ� �̸� �ϳ� �������
				}
				
				i++; // 'O'�� �������� ���ؾ��ϱ� ������ �� ĭ�� �ڴ�. 
			}
			// ���ϰ� �ٸ� �� ī��Ʈ�� 0���� ���ش�. 
			else patternCnt = 0;
		}
		return answer;
	}
}
