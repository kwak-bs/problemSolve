package problemSolve;

import java.util.HashMap;
import java.util.Set;

public class PM_42578 {
	//PM(���α׷��ӽ�) / 68644�� / ����
	public static void main(String[] args) {
		
		PM_42578 c = new PM_42578();
		
		String clothes [][] = {{"yellow_hat", "headgear"}, 
					{"blue_sunglasses", "eyewear"}, 
					{"green_turban", "headgear"}};
		c.solution(clothes);
	}
	
    public int solution(String[][] clothes) {
        int answer = 1; // ������ ���� 1�� ����
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
        	// �ǻ� ����, ����
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        
        // ����
        Set<String> keySet = map.keySet();
        
        for(String key : keySet) {
        	// �� �������� �� �Դ� ��츦 +1 ���ش�.
        	answer *= map.get(key)+1;
        }
        
         // �ƹ��͵� �� �Դ� ���� ���ֱ�
        return answer-1;
    }
}
