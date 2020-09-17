package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2161 {
	// BOJ / 2161�� / ī��1 / ����, �ڷᱸ��, ť, ��, �ùķ��̼� / ��2
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i=1; i<=n; i++) { // ť���ٰ� �� �־���
			q.add(i);
		}
		
		int i = 1;
		
		while(!q.isEmpty()) {
			
			if(i % 2 == 1) { 
				int temp = q.poll();
				ans.add(temp);
				i++;
			}
			
			else if(i % 2 == 0) { 
				int temp = q.poll();
				q.add(temp);
				i++;
			}
		}

		for(int k=0; k<ans.size(); k++) { //���
			System.out.println(ans.get(k));
		}
	}

}
