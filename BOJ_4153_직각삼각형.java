package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4153 {
	// BOJ / 4153�� / �����ﰢ�� / ����, ������ / ��3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			//�Է�
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 0,0,0 �̸� break;
			if(a == 0 && b ==0 && c == 0) {
				break;
			}
			
			Pythagoras(a,b,c);
		}
	}
	
	public static void Pythagoras(int a, int b, int c) {
		// ��� �Է��� ���� �� ������ �𸣱� ������ ��� �Է¿� ���ؼ� ó��������Ѵ�.
		if(a*a + b*b == c*c) {
			System.out.println("right");
		} else if(a*a + c*c == b*b){
			System.out.println("right");
		} else if(b*b + c*c == a*a){
			System.out.println("right");
		} else {
			System.out.println("wrong");
		}
	}
}
