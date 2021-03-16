package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055 {
	// BOJ / 20055�� / �����̾� ��Ʈ ���� �κ� / ����, �ùķ��̼� / �ǹ�2
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int a[] = new int[2*n];
		int r[] = new int[2*n];
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<a.length; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		int zero = 0;
		int ans = 0;
		while(true) {
			ans++;
			// 1. ��Ʈ ��ĭ ȸ��
			rotate(a);
			rotate(r); // �κ� ���� �迭�� ȸ�� 
			
			// �������� ��ġ�� ������ �κ� ����
			if(r[n-1] == 1) {
				r[n-1] = 0;
			}
			
			// 2. ���� ���� ��Ʈ�� �ö� �κ�����, ��Ʈ�� ȸ���ϴ� �������� �� ĭ �̵��� �� �ִٸ� �̵��Ѵ�. �̵� �ȵǸ� ���� �ִ´�.
			// ������ �迭�� n-1 �̴� n-2���� Ž���Ѵ�.
			for(int i=n-2; i>=0; i--) {		
				// �κ��� ������ 
				if(r[i] == 1) {
					// ���� ĭ�� �κ��� ���� �������� 1�̻��̸�
					if(r[i+1] == 0 && a[i+1] >= 1) {
						r[i+1] = 1;
						a[i+1]--;
						r[i] = 0;
						
						// �߿�����Ʈ! �������� 0�� �� ���� �ٷιٷ� üũ������Ѵ�. 
						// ó���� ��� ������ �� ��ġ�� ������ 0�� ��츦 �ѹ��� ó������ٰ� �ָ���.
						if(a[i+1] == 0) {
							zero++;
						}
					}
				}
			}
			// �������� ��ġ�� ������ �κ� ����
			if(r[n-1] == 1) {
				r[n-1] = 0;
			}
			
			// 3. �ö󰡴� ��ġ�� �κ��� ���ٸ� �κ��� �ϳ� �ø���.
			if(a[0] > 0) {
				r[0] = 1;
				a[0]--;
				
				if(a[0] == 0) {
					zero++;
				}
			}
			
			// 4. ������ üũ
			if(zero >= k) {
				System.out.println(ans);
				break;
			}
		}
	}
	
	public static void rotate(int[] a) {
		int temp = a[a.length-1];
		
		for(int i=a.length-1; i>0; i--) {
			a[i] = a[i-1];
		}
		a[0] = temp;
	}
}
