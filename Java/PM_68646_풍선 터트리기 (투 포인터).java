package problemSolve5;

import java.util.HashSet;

public class PM_68646 {
	// PM / 68646�� / ǳ�� �Ͷ߸��� / �� ������ / Level3
	public static void main(String[] args) {
		
		solution(new int[] {9,-1,5});
	}
	
    public static int solution(int[] a) {
        int answer = 2; // ó���� ���� ������ ����
        
        int l = a[0], r = a[a.length-1];
        
        for(int i=1; i<a.length; i++) { // ��� ǳ���� �ɷ�����.
        	if(l > a[i]) {
        		l = a[i];
        		answer++;
        	}
        	if(r > a[a.length-1-i]) {
        		r = a[a.length-1-i];
        		answer++;
        	}
        }
        
        return l == r ? answer-1 : answer; // l�� r�� ������ �ߺ� �߻�
    }
}
