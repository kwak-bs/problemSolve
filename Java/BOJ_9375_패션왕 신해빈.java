package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9375 {
	//BOJ / 9375�� / �мǿ� ���غ�  / �ؽ� / ��3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			HashMap<String,Integer> map = new HashMap<>();

			
			for(int i=0; i<n; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				// ù��° ������ �Է��� ������ �ι� ° ������ ���� ������ key�� �־��ش�.
				stk.nextToken();
				String key = stk.nextToken(); 
				map.put( key, 
						map.getOrDefault(key, 0) +1);
			}
			
			Set<String> keySet = map.keySet();
			
			int answer = 1;
			for(String key : keySet) {
				// �԰ų� ���԰ų� ���� ���� ����
				answer *= map.get(key) + 1;
			}
			// �ƿ� ���Դ� ��츦 ���ش�.
			System.out.println(answer - 1);
		}
	}
}
