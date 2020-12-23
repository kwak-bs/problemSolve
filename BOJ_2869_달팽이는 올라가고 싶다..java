package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {
	// BOJ / 2869�� / �����̴� �ö󰡰� �ʹ� / ���� / ��2
	// �ð��ʰ� �����ؾ� �ϴ� ������ for�� ����. ���������� �����ؾ���
	public static void main(String[] args) throws IOException {
		
		long st = System.currentTimeMillis();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(stn.nextToken());
		int b = Integer.parseInt(stn.nextToken());
		int v = Integer.parseInt(stn.nextToken());
		
		int day = 0; // �ö󰡴� ��
		
		day = ( v - b ) / (a - b) ; // ( �� ���� - �������� ����) / ( �ö󰡴� ���� - �������� ����)
		
		if( ( v - b ) % (a - b) != 0 )
			day++;
		
		System.out.println(day);
		
		long et = System.currentTimeMillis();
		long dt = et - st;
		System.out.println("�ɸ� �ð�: " + dt/1000.0 + " ��");
		
	}
}
