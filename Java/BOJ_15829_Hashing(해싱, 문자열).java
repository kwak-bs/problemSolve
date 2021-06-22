package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15829 {
	// BOJ / 15829�� / Hashing / ���ڿ�, �ؽ� / �����2
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		long result = 0;
		long r = 1;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			// ������ Ŀ���� �ֱ� ������ �̸� ��ⷯ ������ 
			long hash = ((ch-'a'+1) * r) % 1234567891;
			// ��������
			r = ( r* 31) %1234567891;
			result += hash;
		}
		
		System.out.println(result%1234567891);
	}

}
