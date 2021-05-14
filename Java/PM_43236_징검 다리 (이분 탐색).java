package problemSolve5;

import java.util.Arrays;

public class PM_43236 {
	// PM / 43263�� / ¡�˴ٸ� / �̺�Ž�� / Level4 
	public static void main(String[] args) {

		solution(25, new int[] {2,14,11,21,17},2);
	}
	
    public static int solution(int distance, int[] rocks, int n) {
        int answer = Integer.MIN_VALUE;
        
        Arrays.sort(rocks);
        
        int start = 0; 
        int end = Integer.MAX_VALUE;
        int mid;
        
        while(start <= end) {
        	// mid�� ���� ������ �Ÿ� 
        	mid = (start + end) / 2;
        	int count = 0;
        	int prev = 0;
        	for(int i=0; i<rocks.length; i++) {
        		// mid���� ������ ���� 
        		if(rocks[i] - prev < mid) {
        			count++;
        		}
        		// mid���� ũ�ų� ������ prev ����
        		else {
        			prev = rocks[i];
        		}
        		if(count > n) break;
        	}
        	// ������ �� 
        	if(distance - prev < mid && count<=n) {
        		count++;
        	}
        	// ������ ������ n������ ũ��  
        	if(count > n) {
        		end = mid - 1;
        	}
        	// ������ ������ n������ �۰ų� ������  
        	// �ִ��� ���ؾ� �ϹǷ� start���� mid ��ȭ
        	else {
        		start = mid + 1;
        		answer = Math.max(answer, mid);
        	}
        	
        }
        System.out.println(answer);
        return answer;
    }
}
