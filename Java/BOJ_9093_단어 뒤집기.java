package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9093 {
	// BOJ / 9093�� / �ܾ� ������ / ���ڿ� / ��1
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// ���� ����ؔf�µ� �ð� �ʰ��� 
		for(int i =0 ; i<n; i++) {
			String input = br.readLine();
			String [] temp = input.split(" ");
			
			for(int j=0; j<temp.length; j++) {
				StringBuffer sf = new StringBuffer(temp[j]);
				System.out.print(sf.reverse()+" ");
			}
			System.out.println();
		}
	}
}
