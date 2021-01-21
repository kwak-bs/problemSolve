package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10816 {
	//BOJ / 10816�� / ���� ī��2  / �ؽ� / ��4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int card [] = new int [20000001]; // ���� ���� ����� �迭 ����
		
		stk = new StringTokenizer(br.readLine(), " ");
		
	
		for(int i=0; i<n; i++) {
			card[Integer.parseInt(stk.nextToken())+10000000]++;
		}
		
		int m = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<m; i++) {
			sb.append(card[Integer.valueOf(stk.nextToken())+10000000] + " ");
		}
		
		System.out.println(sb.toString());
		// map�� ���� �� ���� �迭�� ����� �����ϴ� ���� �� �ð��� ȿ�����̶���. 
		// (�����ÿ� �ð����⵵�� ���ٰ� �ϴ� �Ǵ�.) 
		
	}
}
