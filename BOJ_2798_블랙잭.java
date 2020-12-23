package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {
	// BOJ / 2798�� / ���� / ���Ʈ���� �˰���/ ��2
	static int m, n;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//�Է�1
		n = Integer.parseInt(st.nextToken());
		m =	Integer.parseInt(st.nextToken());
		
		int [] input = new int [n];
		st = new StringTokenizer(br.readLine(), " ");
		
		//�Է�2
		for(int i=0; i<input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bF(input));
		
	}
	
	public static int bF(int[] input) {
		int sum = 0;
		
		// ī��� �� 3��. ù ��° ī��� 0 ~ length-2, �ι�°  1 ~ length-1, ����° 2 ~ length����
		for(int i=0; i<input.length - 2; i++) {
			for(int j= i+1; j<input.length -1; j++) {
				for(int k=j+1; k<input.length; k++) {
					//�� ���� ī�带 ����
					int temp = input[i] + input[j] + input[k];
					
					// ������ return �� ����.
					if( temp == m) {
						return temp;
					}
					
					// �ٸ��� sum ���� (��, ������ sum���� ũ�� m���� ���� ��� )
					else if(temp > sum && temp < m ){
						sum = temp;
					}
				}
			}
		}
		return sum;
	}
}
