package problemSolve5;

import java.util.Arrays;

public class PM_42577 {
	// PM / 42577�� / ��ȭ��ȣ ��� / �ؽ� / Level2
	public static void main(String[] args) {
		solution(new String[] {"119", "97674223", "1195524421"});
	}
	
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
            // ���ڿ� ������ �����ڵ� ���� �������� ���ϱ� ������ ���ڵ��� ��ġ������ ���̰� �ٸ� ���� ���̰� ª�� ���ڿ��� ���� ������ ���� �ȴ�. ����, ���ڿ� �� Ư¡���� ���� �迭[n]�� ���ڿ��� ���ξ�� �����ϴ� ���ڿ��� �迭[n+1]�� ��ġ�� �� �ְ� �ȴ�. 
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].indexOf(phone_book[i]) == 0) {
                answer = false;
                return answer;
            }
        }
        return answer;
    }

}
