package problemSolve4;

public class PM_12951 {
	// PM / 12951�� / JadenCase ���ڿ� ����� / ����, ���ڿ� / Level2 
	public static void main(String[] args) {
		solution("3people unFollowed me");
	}
	
    public static String solution(String s) {
        StringBuffer answer = new StringBuffer();
        
        String f = s.charAt(0)+"";
        answer.append(f.toUpperCase());

        for(int i=1; i<s.length(); i++) {
            // �����̸� �׳� �־���
            if(s.charAt(i) == ' ') {
                answer.append(" ");
            }
            else {
                String str = s.charAt(i)+"";
                // �� ���ڰ� �����̸� �빮�ڷ� 
                if(s.charAt(i-1) == ' ') {
                    answer.append(str.toUpperCase());
                }
                // �ƴϸ� �ҹ��ڷ� 
                else {
                    answer.append(str.toLowerCase());
                }
            }
        }
        return answer.toString();
    }
}
