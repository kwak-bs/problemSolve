package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_13414 {
	// BOJ / 13414�� / ������û / �ؽ� / ��?
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		// ��ũ���ؽ����� �Է� ������ �����Ѵ�. 
		LinkedHashSet<String> set = new LinkedHashSet<>();
		
		for(int i=0; i<m; i++) {

			String data = br.readLine();
			if(set.contains(data)) {
				//�ߺ��̸� ���� �� �ٽ� �߰�.
				set.remove(data);
				set.add(data);
			}
			else {
				set.add(data);
			}
		}
		int count = 0;
		// set �ݺ�
		for(String data : set) {
			if(count == n) {
				break;
			}
			count++;
			System.out.println(data);
		}
		
	}
}
