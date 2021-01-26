package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4256 {
	// BOJ / 4256�� / Ʈ�� / Ʈ�� / ��5
	static int in[], pre[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			pre = new int[n+1];
			in = new int[n+1];
			
			// ���� �Է�
			stk = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=n; i++) {
				pre[i] = Integer.parseInt(stk.nextToken()); 
			}
			// ���� �Է�
			stk = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=n; i++) {
				in[i] = Integer.parseInt(stk.nextToken()); 
			}
			
			postOrder(1, n, 1);
			System.out.println();
		}
	}
	
	// �� �� ��(���) 
	public static void postOrder(int start, int end, int root) {
		
		for(int i=start; i<=end; i++) {
			if(in[i] == pre[root]) {
				//��, ���� ���� Ʈ���� pre�迭���� root(index) + 1 
				postOrder(start, i-1, root+1);
				
				//��, ������ ���� Ʈ���� pre�迭 root(index) + in�迭 ���� ���� Ʈ���� ũ��(i) + 1
				//���� �ʱ� start ���ָ��
				postOrder(i+1, end, root + i + 1 - start );
				
				//���
				System.out.print(pre[root]+" ");
			}
		}
	}
}
