package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250 {
	//BOJ / 10250�� / ACM ȣ�� / ����, ����, ��Ģ���� / ��3
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); //�Է�
			int h = Integer.parseInt(st.nextToken()); // ��
			int w = Integer.parseInt(st.nextToken()); // ��
			int n = Integer.parseInt(st.nextToken()); // ���
			
			int per = 0;
			int floor = 0;
			int room = 1;
			String f = "";
			String r = "";
			
			while(per < n ) { // ����� ���� ���� ����, ���� ������ ������ �ö��� ��� room++
				per++;
				floor++;
				
				if(floor > h) {
					floor = 1;
					room++;
				}
			}
			
			StringBuffer sb = new StringBuffer();
			f = Integer.toString(floor);
			
			if(room < 10) {
				r = "0"+Integer.toString(room);
			}
			else {
				r = Integer.toString(room);
			}
			sb.append(f);
			sb.append(r);
			System.out.println(sb.toString());
			per = 0;
			floor = 0;
			room = 0;
		}
	}
}
