package problemSolve4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KAKAO_2019_������ {

	public static void main(String[] args) {
		
		KAKAO_2019_������  c = new KAKAO_2019_������();
		
		int N = 5 ;
		int[] stages = {2,1,2,6,2,4,3,3};
		c.solution(N, stages);
	}
	
	class Fail {
		int stage;
		double rate;
		
		Fail(int stage, double rate) {
			this.stage = stage;
			this.rate = rate;
		}
	}
	
	Comparator<Fail> comp = new Comparator<Fail>() { // ������ ���� ���� , ������ stage �������� 
		public int compare(Fail a, Fail b ) {
			if(a.rate < b.rate) return 1;
			else if (a.rate > b.rate ) return -1;
			else {
				if(a.stage > b.stage) return 1;
				else if (a.stage < b.stage) return -1;
				else return 0;
			}
		}
	};
	
    public int[] solution(int N, int[] stages) {
     	
        int[] answer = new int[N];
        List<Fail> fails = new ArrayList<Fail>();
        int total = stages.length;
        
        int[] users = new int[N+1]; // �� stage�� Ŭ�������� ���� ����� ��
        for(int s : stages) {
        	users[s-1]++;
        }
        
        for(int i=0; i<N; i++) {
        	if(users[i] == 0) {
        		fails.add(new Fail(i+1, 0));
        	}
        	else {
        		fails.add(new Fail(i+1, (double)users[i]/total ));
        		total -= users[i];
        	}
        }
        
        Collections.sort(fails, comp);
        
        for(int i=0; i<answer.length; i++) {
        	answer[i] = fails.get(i).stage;
        }
        return answer;
    }
}
