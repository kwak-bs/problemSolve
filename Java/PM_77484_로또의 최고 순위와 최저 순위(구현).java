package problemSolve5;

public class PM_77484 {
	// PM / 77484�� / �ζ��� �ְ� ������ ���� ���� / ���� / Level1 / 2021 Dev-Matching: �� �鿣�� ����
	public static void main(String[] args) {

		solution(new int[] {44,1,0,0,31,25}, new int[] {31,10,45,1,6,9});
	}
	
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zero = 0;
        // 0 ���� ����
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) {
                zero++;
            } 
        }
        int same = 0;
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) continue;
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    same++;
                }
            }
        }
        // tc:14 �ϳ��� �ȸ°� 0�� ���� ���
        if(same == 0 && zero == 0) {
            same = 1;
        }
        answer[0] = Math.abs(same+zero - 7);
        answer[1] = zero == 6 ? 6 : Math.abs(same - 7); 
        return answer;
    }

}
