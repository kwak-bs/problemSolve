package problemSolve2;

import java.util.ArrayList;

public class PM_KAKAO_2021_1_1 {

	public static void main(String[] args) {
		
		String new_id = "abcdefghijklmn.p";
		
		PM_KAKAO_2021_1_1 c = new PM_KAKAO_2021_1_1();
		
		c.solution(new_id);

	}
    public String solution(String new_id) {
        String answer = "";
        
        // 1�ܰ�, ��� ���ڸ� �ҹ��ڷ�
        String one = new_id.toLowerCase();
        
        // 2�ܰ�, -, _, .�� ������ ��� ���� ����
        for(int i = 0; i<one.length(); i++) {
        	char temp = one.charAt(i);
        	
        	if(temp >= 'a' && temp <= 'z') {
        		answer += Character.toString(temp);
        	}
        	else if (temp >= '0' && temp <= '9') {
        		answer += Character.toString(temp);
        	}
        	else if(temp == '-' || temp == '_' || temp == '.') {
        		answer += Character.toString(temp);
        	}
        	else {
        		continue;
        	}
        }
        
        // 3�ܰ�, .�� 2�� �̻� ���ӵ� �κ��� �ϳ��� .�� ġȯ
        while(answer.indexOf("..") >= 0) {
        	answer = answer.replace("..", ".");
        }
        
        // 4�ܰ�, .�� ó���̳� ���� ��ġ�ϸ� ����
        if(answer.charAt(0) == '.'){
            answer = answer.substring(1, answer.length());
        }
        if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.'){
            answer = answer.substring(0, answer.length()-1);
        }
        
        
        // 5�ܰ�, �� ���ڿ��̸� "a" ����
        if(answer.length() == 0 ) {
        	answer = "a";
        }
        
        // 6�ܰ�, 16�� �̻��̸� ù 15���� ������ ������ ���� ��� ����.
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            // 6.5�ܰ�, �����ߴµ� ������ ���ڰ� .�̸� ���� 
            if(answer.length() > 0 && answer.charAt(14) == '.'){
                answer = answer.substring(0, 14);
            }
        }
        
        // 7�ܰ�, 2�� �����̸�, ������ ���ڸ� 3�� �ɶ����� �ݺ� 
        if(answer.length() <= 2) {
        	char temp = answer.charAt(answer.length() - 1);
        	
        	while(answer.length() != 3) {
        		answer += Character.toString(temp);
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}
