package problemSolve5;

public class PM_77884 {
	// PM / 77884�� / ����� ������ ���� / ����, ����  / Level1 / ���� �ڵ� ç���� ����2
	public static void main(String[] args) {
		solution(1,2);
	}
	
    public static int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
        	
        	int num = i;
        	int count=0;
        	for(int j=1; j<=num; j++) {
        		if(num % j == 0) {
        			count++;
        		}
        	}
        	// ¦���� 
        	if(count % 2 == 0) {
        		answer += num;
        	}
        	else {
        		answer -= num;
        	}
        }
        return answer;
    }
}
