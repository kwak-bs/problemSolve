package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10798 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 5;
		String [] arr = new String[5];
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<n; i++) {  // �Է� 
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			arr[i] = input;
		}
		
		int max_length = 0;
		
		for(int i =0; i<arr.length; i++) {
			max_length = Math.max(arr[i].length(), max_length);
		}
		
		int idx = 0;
		
		//while���� ������ ���� �� �ε����� ���̸� �־��ָ� ��
		while( idx < max_length) {
			
			for(int k=0; k<arr.length; k++) {
				int temp = arr[k].length()-1;
				
				if(idx > temp) {
					continue;
				}
				else {
					if(arr[k].charAt(idx) != 0) {
						sb.append(arr[k].charAt(idx));
					}					
				}

			}
			idx++;
		}
		System.out.println(sb.toString());
	}

}
