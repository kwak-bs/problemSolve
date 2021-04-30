package problemSolve4;

import java.util.Stack;

public class PM_76502 {
	// PM / 76502�� / ��ȣ ȸ���ϱ� / ����, ����  / Level2 / ���� �ڵ� ç���� ����2
	public static void main(String[] args) {
		solution("[](){}");
	}
	
    public static int solution(String s) {
        int answer = 0;
        int len = s.length();
        // ���̸�ŭ �ݺ�
        while(len -- > 0) {
            if(check(s)){
                answer++;
            }
            s = rotate(s);        
        }
        return answer;
    }
	
    // �ùٸ� ��ȣ�� ���� ���ڿ����� �˻�
    public static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            char b = s.charAt(i);
            if(b == '(') {
                st.push(b);
            }
            else if(b == ')') {
                if(st.isEmpty()) return false;
                
                char tmp = st.pop();
                if(tmp == '(') continue;
                else return false;
            }
            else if(b == '{') {
                st.push(b);
            }
            else if(b == '}') {
                if(st.isEmpty()) return false;
                
                char tmp = st.pop();
                if(tmp == '{') continue;
                else return false;
            }
            else if(b == '[') {
                st.push(b);
            }
            else if(b == ']') {
                if(st.isEmpty()) return false;
                
                char tmp = st.pop();
                if(tmp == '[') continue;
                else return false;
            }
        }
        if(st.size() == 0) {
            return true;
        }
        return false;
    }
	
    // �������� ȸ�� 
    public static String rotate(String s) {
        char tmp = s.charAt(0);
        StringBuffer sb = new StringBuffer();
        
        for(int i=1; i<s.length(); i++) {
            sb.append(s.charAt(i));   
        }
        sb.append(tmp);
        return sb.toString();
    }
}
