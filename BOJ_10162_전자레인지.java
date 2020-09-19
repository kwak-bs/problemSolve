package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10162 {
	//BOJ / 10162�� / ���ڷ�����/ ����, ��Ģ����, ���� / ��4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		int onem = 60;
		int one_cnt = 0;
		
		int tens = 10;
		int ten_cnt = 0;
		
		int fivem = 300;
		int five_cnt = 0;
		
		while(input > 0) { // input�� 0 �̻� �̸� �ݺ� 
			if(input < 10) { // 10 ���ϸ� break, �ּ� ������ 10�̱� ���� 
				break;
			}
			
			if( input >= fivem) {
				five_cnt++;
				input -= fivem;

			}
			else if( input >= onem) {
				one_cnt++;
				input -= onem;

			}
			else if( input >= tens) {
				ten_cnt++;
				input -= tens;

			}
		}
		if(input != 0 ) {
			System.out.println(-1);
		}
		else {
			System.out.println(five_cnt +" " + one_cnt+ " " + ten_cnt);			
		}
	}

}
