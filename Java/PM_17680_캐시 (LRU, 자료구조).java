package problemSolve5;

import java.util.LinkedList;

public class PM_17680 {
	// PM / 17680�� / ĳ�� / LRU, �ڷᱸ�� / Level2 / 2018 īī�� ����ε� ä��
	public static void main(String[] args) {

		solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
	}
	
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 0�̸� ���̸�ŭ miss ������ ���ؼ� ��ȯ
        if(cacheSize == 0) return cities.length * 5;
        
        LinkedList<String>cache = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            // hit
            if(cache.remove(city)) {
                cache.addFirst(city);
                answer += 1;
            }
            // miss
            else {
                int curSize = cache.size();
                // ���� ������ ���� ������ ��(��) ����
                if(curSize == cacheSize) {
                    cache.pollLast();
                }
                cache.addFirst(city);
                answer += 5;
            }
        }
        return answer;
    }

}
