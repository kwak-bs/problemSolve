package problemSolve5;

public class PM_17687 {
	// PM / 17687�� / n���� ���� / ���� / Level2 / 2018 īī�� ����ε� ä��
	public static void main(String[] args) {
		solution(2,4,2,1);
	}
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        sb.append(0); // 0���� ���� 
        int i = 1; // ����Ǵ� ���� ���� 
        
        // ���ؾ��ϴ� ��� ����(��� �ο� ����)
        while(sb.length() < m*t) {
            sb.append(notation(i++, n));
        }
        
        // Ʃ�� ���ʸ��� answer�� �߰�
        for(int j=p; j<=t*m; j+=m) {
            answer += sb.charAt(j-1);
        }
        return answer;
    }
    
    // ���� ��ȯ.
    private static String notation(int num, int n) {
        String s = "";
        while(num != 0) {
            if(num % n < 10) {
                s = num%n + s;
            }
            else {
                s = String.valueOf((char)(num%n + 55)) + s;
            }
            num /= n;
        }
        
        return s;
    }
}
