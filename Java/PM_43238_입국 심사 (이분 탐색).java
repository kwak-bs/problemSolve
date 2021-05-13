package problemSolve5;

import java.util.Arrays;

public class PM_43238 {
	// PM / 43238�� / �Ա��ɻ� / �̺� Ž�� / Level3 
	public static void main(String[] args) {

		solution(6, new int[] {7,10});
	}
	
    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        
        long start = 0;
        long end = Long.MAX_VALUE;
        long mid;
        Arrays.sort(times);
        
        while(start <= end) {
        	// m�� �־��� �ð� 
        	mid = (start+end) / 2;
        	
        	long sum = 0;
        	// �־��� �ð� ���� �� �ɻ�뿡�� �� ����� �ɻ� ���� �� �ִ��� ����. 
        	for(int i=0; i<times.length; i++) {
        		sum += (mid / times[i]);
        		if(sum >= n) {
        			break;
        		}
        	}
        	// ��� ����� �־��� �ð� ���� �ɻ縦 �� �� ������ 
        	if(sum < n ) {
        		start = mid+1;
        	}
        	// ��� ����� �־��� �ð� ���� �ɻ縦 �� �� ������ 
        	else {
        		end = mid-1;
        		answer = Math.min(answer, mid);
        	}
        }
        System.out.println(answer);
        return answer;
    }
}
