package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13335 {
	// BOJ / 13335�� / Ʈ�� / �ùķ��̼� / �ǹ�1
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken()); // Ʈ�� �� 
		int w = Integer.parseInt(stk.nextToken()); // �ٸ� ����
		int l = Integer.parseInt(stk.nextToken()); // �ִ� ���� 
		
		ArrayList<Integer> Truck = new ArrayList<>();
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			Truck.add(Integer.parseInt(stk.nextToken()));
		}
		int bridge[] = new int[w];
		
		int time = 0;
		while(true) {
			time++;

			int curBW = 0;
			int InTr = 0;

			// ���� �ٸ��� ��Ȳ�� ���� 
			for(int i=0; i<bridge.length; i++) {
				if(bridge[i] == 0) continue;
				curBW += bridge[i];
				InTr++;
			}

			// ���� �ٸ��� �ִ� Ʈ���� ���� �ű���.
			if(InTr > 0 ) {
				// �ٸ� �� �տ� Ʈ���� ������ ������ ��������. 
				if(bridge[0] != 0) {
					InTr--;
					curBW -= bridge[0];
					bridge[0] = 0;
				}
				// 1���� ���ʴ�� ������ �ű��� 
				for(int i=1; i<bridge.length; i++) {
					bridge[i-1] = bridge[i]; 
					bridge[i] = 0;
				}
			}
			
			// �ٸ� �� �ڰ� ����ٸ� Ʈ���� �־����� 
			if(bridge[bridge.length-1] == 0) {
				// �׷��� ���� �ٸ��� ������ Ȯ������.
				if(Truck.size() > 0) {
					int ww = Truck.get(0);
					
					if(curBW + ww <=l) {
						bridge[bridge.length-1] = ww;
						InTr++;
						Truck.remove(0);
						
					}					
				}
			}

			if(Truck.size() == 0 && InTr == 0) {
				break;
			}
		}
		
		System.out.println(time);
	}
}
