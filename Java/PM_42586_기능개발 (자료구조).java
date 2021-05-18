package problemSolve5;

import java.util.ArrayList;

public class PM_42586 {
	// PM / 42586�� / ��ɰ��� / �ڷᱸ�� / Level2
	public static void main(String[] args) {

		solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> al = new ArrayList<>();
        int index =0;
        int count = 0;
        while(index < speeds.length) {
            count = 0;
            // ���� index(���� ���� �����Ǿ�� �ϴ�)�� �۾��� �� ����������
            if(progresses[index] < 100) {
                for(int i=0; i<speeds.length; i++) {
                    progresses[i] += speeds[i];
                }
            }
            // ���� index�� �۾��� �� �������� 
            else if(progresses[index] >= 100) {
                count = 1;
                index++;
                while(index < speeds.length) {
                    if(progresses[index] >= 100) count++;
                    else break;
                    index++;
                }
                al.add(count);
            }
        }
        
        int[] answer = new int[al.size()];
        for(int i=0; i<al.size(); i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }

}
