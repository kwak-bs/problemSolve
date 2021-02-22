package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10974 {
	// BOJ / 10974�� / ��� ���� / ���Ʈ���� / ��3
	static int n;
	static int num[];
	static StringBuffer sb;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int [n];
		sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			num[i] = i+1;
		}
		
		do {
			for(int i=0; i<n; i++) {
				sb.append(num[i]).append(" ");
			}
			sb.append("\n");
		}while(next_permutation());
		
		System.out.println(sb);
	}
	public static boolean next_permutation() {
		int i = num.length-1;
		
		// ������ ������ ���������� ������ ����.
		while(i>0 && num[i-1] >= num[i]) {
			i -= 1;
		}
		
		if(i <= 0) {
			return false;
		}
		
		// ���� ���� ��
		int j = num.length-1;
		while(num[j] <= num[i-1]) {
			j -= 1;
		}
		
		// swap
		int temp = num[i-1];
		num[i-1] = num[j];
		num[j] = temp;
		
		// ��������
		j = num.length-1;
		while(i<j) {
			temp = num[i];
			num[i] = num[j];
			num[j] = temp;
			
			i++;
			j--;
		}
		return true;
	}
}
