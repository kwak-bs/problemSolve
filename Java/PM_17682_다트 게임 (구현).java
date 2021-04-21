package problemSolve4;

import java.util.Stack;

public class PM_17682 {
	// PM / 17682�� / [1��]��Ʈ ���� / ����  / Level1 / 2018 īī�� BLIND
	public static void main(String[] args) {
		solution("1S2D*3T");
	}
	
    public static int solution(String dartResult) {
        int answer = 0;
        
        int num = -1;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<dartResult.length(); i++) {
            char temp = dartResult.charAt(i);
            
            if(temp>='0' && temp <= '9') {
                // 10ó��
                if(num == 1 && temp == '0') {
                    num = 10;
                    continue;
                }
                num = temp - '0';
            }
            else if(temp == 'S') {
                st.push(num);
            }
            else if(temp == 'D') {
                num = (int)Math.pow(num, 2);
                st.push(num);
            }
            else if(temp == 'T') {
                num = (int)Math.pow(num, 3);
                st.push(num);
            }
            else if(temp == '*') {
                int cur = st.pop();
                int prev = 0;
                if(st.size() > 0) {
                    prev = st.pop();
                }
                cur *= 2;
                
                if(prev != 0)  {
                    prev *= 2;
                    st.push(prev); // prev�� ���� �־�� cur�� prev�� �� �� �ִ�.
                }
                st.push(cur);
            }
            else if(temp == '#') {
                int cur = st.pop();
                cur *= -1;
                st.push(cur);
            }
        }
        
        for(int v : st) {
            answer += v;
        }
        return answer;
    }

}
