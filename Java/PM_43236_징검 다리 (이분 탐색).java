package problemSolve4;

import java.util.Arrays;

public class PM_43236 {
	// PM / 43236�� / �Ա� �ɻ� / �̺� Ž��  / Level3
	public static void main(String[] args) {
		
		solution(25, new int[] {2,14,11,21,17},2);
	}
	
    public static int solution(int distance, int[] rocks, int n) {
        int answer = Integer.MIN_VALUE;
        Arrays.sort(rocks);
        
        int start = 1;
        int end = distance; 
        int mid;
        
        while(start <= end) {
            // mid�� ���� ������ �ּ� ���� 
            mid = (start + end) / 2;
            int count = 0;
            int prev = 0;
            for(int i=0; i<rocks.length; i++) {
                // ���� ���ؼ� ������ ���� ���� 
                if(rocks[i] - prev < mid) {
                    count++;
                }
                // ũ�ų� ������ prev�� ��������� ����
                else {
                    prev = rocks[i];
                }
                if(count > n ) break;
            }
            // count�� ������ ���������� �������� ��
            if(count <= n && distance - prev < mid) {
                count++;
            }
            
            // ������ ������ ������ n ���� �۰ų� ������ start ��ȭ 
            if(count <= n) {
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
            // ������ ������ ������ n���� ũ�� end ��ȭ 
            else {
                end = mid - 1;
            }
        }
        return answer;
    }
}
