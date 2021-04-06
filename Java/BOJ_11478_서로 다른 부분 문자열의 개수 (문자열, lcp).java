package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;


public class BOJ_11478 {
	// BOJ / 11478�� / ���� �ٸ� �κ� ���ڿ��� ���� / ���ڿ� / �ǹ�3


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String[] str = new String[s.length()];
		int answer = 0;
		for(int i=0; i<s.length(); i++) {
			str[i] = s.substring(i);
		}
		Arrays.sort(str);
		// �־��� String�� ���� �� �ִ� ��� �κ� ���ڿ��� �������� 
		// lcp(�ִ� ���� ���λ��� ����)�� �� ���� ����.
		answer += str[0].length();
		// 1. � �κ� ���ڿ��� � ���̻��� ���λ��̴�. 
		// 2. � �� ���̻糢�� ���� ���� �κ��� �ִٸ� �� �κ��� �κй��ڿ��� ������� ���� ���ڿ��̴�. 
		// 3. ���� �� �κ� ���ڿ��� �������� ������� ���� ���ڿ�(lcp)�� ��� ������ ����. 
		for(int i=1; i<str.length; i++)  {
			answer += (str[i].length() - getCommon(str[i-1], str[i]));
		}
		System.out.println(answer);
	}
	public static int getCommon (String s1, String s2) {
		int result = 0; 
		
		for(int i=0; i<s1.length(); i++) {
			if(i >= s2.length()) break;
			if(s1.charAt(i) == s2.charAt(i)) result++;
			else break;
		}
		return result;
	}
}
