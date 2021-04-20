package problemSolve4;

import java.util.Arrays;

public class PM_43238 {
	// PM / 43238�� / �Ա� �ɻ� / �̺� Ž��  / Level3
	public static void main(String[] args) {
		solution(6, new int[] {7,10});
	}
	
    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        // �ð� ������ ����
        Arrays.sort(times);
        
        long start,mid,end;
        start = 0;
        end = Long.MAX_VALUE;
        
        while(start <= end) {
            // mid�� �ɻ縦 �޴� �ð��̴�. 
            mid = (end +start) / 2;
            long sum = 0;
            for(int i=0; i<times.length; i++) {
                // �־��� �ð� ���� �ɻ縦 �� �� ���� �� �ִ� ����. 
                sum += mid / times[i];
                if(sum >= n) break;
            }
            
            // ��� ����� �ɻ� �� �� ������(�ð��� ���ڸ���) 
            if(sum < n) {
                start = mid + 1;
            }
            // ��� ����� �ɻ� �� �� ������(�ð��� ���ų� ������)
            else {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }

}
