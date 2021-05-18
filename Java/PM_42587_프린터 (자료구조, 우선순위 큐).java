package problemSolve5;

import java.util.Collections;
import java.util.PriorityQueue;

public class PM_42587 {
	// PM / 42587�� / ������ / �ڷᱸ��, �켱���� ť / Level2
	public static void main(String[] args) {
		solution(new int[] {2,1,3,2}, 2);
	}
	
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        // �켱���� ���� 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : priorities) {
            pq.add(p);
        }
        // �켱���� ���� ������ �ݺ����� Ž���Ѵ�. 
        while(!pq.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
                    if(i == location) return answer;
                    else {
                        answer++;
                        pq.poll();
                    }
                }
            }
        }
        return answer;
    }

}
