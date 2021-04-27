package problemSolve4;

import java.util.Stack;

public class PM_12973 {
	// PM / 12973�� / ¦���� �����ϱ� / ����, ���ڿ� / Level2 / 2017 ����Ÿ�� 
	public static void main(String[] args) {
		
		solution("baabaa");
	}

    public static int solution(String s) {
        int answer = 0;
        Stack<Character> st = new Stack<>();
        st.add(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            
            // ������ ������� ������ 
            if(!st.isEmpty()) {
                // �ϴ� pop
                char c = st.pop();

                // ���� ���ڶ� ������ pop�Ѱ� ���� �� i++
                if(c == s.charAt(i)) {
                    continue;
                }
                // ���� ���ڶ� �ٸ��� ���Ŷ� �񱳱��� �Ѵ� push
                else {
                    st.push(c);
                    st.push(s.charAt(i));
                }
            }
            // ������ ��������� ���� ���� push
            else {
                st.push(s.charAt(i));
            }
        }

        // ���� ����� 0�̸� answer = 1 
        if(st.isEmpty()) answer = 1;
        return answer;
    }
}
