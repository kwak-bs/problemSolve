package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068 {
	// BOJ / 1068�� / Ʈ�� / Ʈ�� / ��1
	
	static int n;
	static int[][] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		tree = new int [n][2]; // [n][0] = �θ� ���, [n][1] = �ڽ� ��
		int answer = 0 ;
		
		for(int i=0; i<n; i++) {
			tree[i][0] = Integer.parseInt(stk.nextToken());
		}
		
		int delete = Integer.parseInt(br.readLine());
		
		setChild();
				
		remove(delete);
		
		// ������� �� ��Ʈ ��尡 �ƴ� ���
		if(tree[delete][0] != -1) {
			for(int i=0; i<n; i++) {
				if(tree[i][0] > -2) {
					if(tree[i][1] == 0) {
						answer++;
					}
				}
			}			
		}
		System.out.println(answer);
	}
	
	public static void setChild() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// ���� ���(i)�� �θ� ������ i[1](�ڽ� ��)�� ++�Ѵ�. 
				if(i == tree[j][0]) {
					tree[i][1]++;
				}
			}
		}
	}
	
	public static void remove(int del) {
		
		// ������°� ��Ʈ ���� �׳� return
		if(tree[del][0] == -1) {
			return ;
		}
		
		// ��Ʈ ��尡 �ƴϸ� 
		else {
			// �� �θ��� �ڽ� ���� -1 ���ش�.
			tree[tree[del][0]][1]--;
			
			// ��带 �����Ѵ�.(-2)
			tree[del][0] = -2;
			
			// ���� ������ ��尡 �ڽ��� ���� ���
			if(tree[del][1] > 0) {
				for(int i=0; i<n; i++) {
					if(tree[i][0] == del) {
						// ��͸� ���� �������
						remove(i);
					}
				}
			}
		}
	}
}
