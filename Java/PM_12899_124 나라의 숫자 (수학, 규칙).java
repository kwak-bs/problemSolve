package problemSolve4;

public class PM_12899 {
	// PM / 12899�� / 124 ������ ���� / ����  / Level2 
	public static void main(String[] args) {

		solution(4);
	}
    public static String solution(int n) {
        String answer = "";
        // ���ڰ� �� 3�� �̹Ƿ� 3���� ������ ���� ������ ���� �ε����� �ϰ� �ش� �ε����� ����ϴ� ���ڸ� �����Ѵ�.
        String nums [] = {"4","1","2"};
        
        while(n > 0) {
            answer = nums[n % 3] + answer;
            // ������ �������� ������ �ڸ����� ���� ���� -1�� ����� �ϹǷ� -1�� ���ؼ� ���� �ڸ����� �̸� �̵�.
            n = (n-1) / 3;
        }
        
        return answer;
    }

}
