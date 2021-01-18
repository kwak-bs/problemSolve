package problemSolve;

import java.util.ArrayList;

public class PM_68935 {
	//PM(���α׷��ӽ�) / 68935�� / 3���� ������ 
	public static void main(String[] args) {

	      int n = 45;
	      
	      PM_68935 c = new PM_68935();
	      

	      c.solution(n);
	}
	
    public int solution(int n) {
        int answer = 0;
     
        ArrayList<Integer> al = new ArrayList<>();
       
        // �յ� ���� (3����) �ѹ��� ǥ��
        while(n >= 3 ) {
        	int tmp = n % 3 ;
        	al.add(tmp);
        	n /= 3;
        }
        // ������ ����� �־��ֱ�
        al.add(n);
        
        
        // 10�������� ǥ��
        for(int i=0; i<al.size(); i++) {
        	answer += al.get(i) * Math.pow(3, al.size()-i-1);
        }
        
        System.out.println(answer);
        return answer;
    }
}
