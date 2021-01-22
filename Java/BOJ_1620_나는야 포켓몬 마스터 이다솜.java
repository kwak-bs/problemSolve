package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
	//BOJ / 1620�� / ���¾� ���ϸ� ������ �̴ټ�  / �ؽ� / ��4
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		// �Է����� �����°� int���� String���� ������ ��� �ұ� ����Ͽ����� 
		// �׳� �� �� ��Ʈ������ �ֱ�� �Ͽ���.
		for(int i=0; i<n; i++) {
			String temp = br.readLine();
			map.put(temp, Integer.toString(i+1));
			map.put(Integer.toString(i+1), temp);
		}
		
		for(int i=0; i<m; i++) {
			String question = br.readLine();
			System.out.println(map.get(question));
		}
	}
}
