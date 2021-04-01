package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259 {
	// BOJ / 1259�� / �Ӹ���Ҽ� / �� Ʈ��ŷ / �����1
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		while(true) {
			boolean ans = true;
			
			String input = br.readLine();
			
			if(input.equals("0")) break;
			
			for(int i=0; i<input.length()/2; i++) {
				
				if(input.charAt(i) != input.charAt(input.length()-i-1)) {
					ans = false;
					break;
				}
			}
			
			if(ans) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}
