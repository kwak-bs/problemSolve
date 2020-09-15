package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10886 {
	//BOJ / 10886�� /  0 = not cute / 1 = cute / ����, ����, ��Ģ���� / ��3
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cute = 0;
		int not_cute = 0;
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 1) {
				cute++;
			}
			else if(input == 0) {
				not_cute++;
			}
		}
		
		if(cute > not_cute) {
			System.out.println("Junhee is cute!");
		}
		else {
			System.out.println("Junhee is not cute!");
		}
	}

}
