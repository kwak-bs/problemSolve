package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458 {
	//BOJ / 13458�� /  ���� ���� / ���� / ��2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // �Է� 
		int [] stu = new int[n];  // �� ������ ���� ������ ���� �л��� 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<stu.length; i++) {
			int input = Integer.parseInt(st.nextToken());
			stu[i] = input;
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int b = Integer.parseInt(st2.nextToken()); // �� ������
		int c = Integer.parseInt(st2.nextToken()); // �� ������
		
		long ans = 0; 

		
		for(int i=0; i<stu.length; i++) {
			stu[i] -= b; // �� �������� ������ 1�� ���;��Ѵ�.
			ans++;
			
			if(stu[i] > 0) { 
				ans += stu[i] / c; //�� �������� �� ���ϱ�
				
					if(stu[i] % c != 0) { // 0���� �������� ������ �Ѹ� �߰�
						ans++;
					}
			}
		}
		System.out.println(ans);
	}
}
