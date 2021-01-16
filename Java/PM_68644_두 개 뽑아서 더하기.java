package problemSolve;

import java.util.ArrayList;
import java.util.Collections;

public class PM_68644 {
	//PM(���α׷��ӽ�) / 68644�� / �� �� �̾Ƽ� ���ϱ� 
	public static void main(String[] args) {
		
		int [] numbers = {5,0,2,7};
		PM_68644 c = new PM_68644();
		
		c.solution(numbers);
	}
	
    public int[] solution(int[] numbers) {
        
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++) {
        	for(int j= i+1; j<numbers.length; j++) {
        		int sum = numbers[i] + numbers[j]; // �ݺ����� ���鼭 �����ش�. 
        		
        		// sum�� al�� ���ԵǾ� ���� ������ �߰�. �ߺ��� ���� ���� �ʴ´�. 
        		if(al.contains(sum)) {
        			continue;
        		}
        		else {
        			al.add(sum);        			
        		}
        	}
        }        
        int[] answer = new int[al.size()];
        Collections.sort(al); // al�� �������� �����Ѵ�.
        
        for(int i=0; i<al.size(); i++) {
        	answer[i] = al.get(i);
        	System.out.println(answer[i]);
        }
        return answer;
    }
}
