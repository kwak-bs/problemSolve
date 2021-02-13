package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_1406 {
	// BOJ / 1406�� / ������ / �ڷᱸ�� / ��3
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String str = br.readLine();
		
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Character> ll = new LinkedList<>();
		
		for(int i=0; i<str.length(); i++) {
			ll.add(str.charAt(i));
		}
		// �׳� LinkedList�� Ǯ�� �ð��ʰ���. ListIterator �������̽��� �̿�����.
		ListIterator<Character> iter = ll.listIterator();
		
		// �ʱ� Ŀ���� �� ��. 
		// next() : ����Ʈ�� ���� ��Ҹ� ��ȯ�ϰ�, Ŀ��(cursor)�� ��ġ�� ���������� �̵���Ŵ.
		while(iter.hasNext()) {
			iter.next();
		}
		
		while(n-- > 0) {
			String command = br.readLine();
			char c [] = command.toCharArray();
			
			switch(c[0]) {
				case 'L' : 
					// �� ����Ʈ�� �ݺ��ڰ� �ش� ����Ʈ�� ���������� ��ȸ�� �� ���� ��Ҹ� ������ ������
					// true�� ��ȯ, �� �̻� ���� ��Ҹ� ������ ���� ������ false�� ��ȯ.
					if(iter.hasPrevious()) {
						// ����Ʈ�� ���� ��Ҹ� ��ȯ�ϰ�, Ŀ�� ��ġ�� ���������� �̵�.
						iter.previous();
					}
					break;
					
				case 'D' :
					if(iter.hasNext()) {
						iter.next();
					}
					break;
					
				case 'B' :
					if(iter.hasPrevious()) {
						iter.previous();
						// remove()�� next() Ȥ�� previous()�� ���� ��ȯ��
						// ���� ������ ��Ҹ� ����Ʈ���� ������
						iter.remove();
					}
					break;
					
				case 'P' : 
					char subC = c[2];
					iter.add(subC);
					break;
			}
		}
		
		for(Character ans : ll) {
			sb.append(ans);
		}
		System.out.println(sb);
	}
}
