package problemSolve5;

import java.util.HashMap;

public class PM_42578 {
	// PM / 42578�� / ���� / �ؽ�, ���� / Level2
	public static void main(String[] args) {

		solution(new String[][] {
			{"yellowhat", "headgear"},
			{"bluesunglasses", "eyewear"},
			{"green_turban", "headgear"},
		});
	}
	
    public static int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<>();
        // ���� ���� ������ ����.
        for(String[] str : clothes) {
            hm.put(str[1], hm.getOrDefault(str[1],0)+1);
        }
        
        // �� ���� ��츦 �����Ͽ� �� ������ ���Ѵ�.
        for(String str : hm.keySet()) {
            answer *= hm.get(str) + 1;
        }
        // �ƿ� ���Դ� ���� ����
        return answer-1;
    }

}
