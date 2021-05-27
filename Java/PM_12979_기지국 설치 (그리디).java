package problemSolve5;

public class PM_12979 {
	// PM / 12979�� / ������ ��ġ / �׸���  / Level3 / Summer/Winter Coding
	public static void main(String[] args) {
		solution(11, new int[] {4,11}, 1);
	}
	
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int si = 0;
        int position = 1;
        
        while(position <= n) {
        	
        	// ���� ��ġ�� ������ ������ ���Ե� ��ġ��� ������ ��ġ x
        	if(si < stations.length && position >= stations[si] - w) {
        		// �������� ��ġ�� �ִ� ���� ���� ĭ���� �ű�
        		position = stations[si] + w+1;
        		si++;
        	}
        	// ���� ��ġ�� ������ ������ ���Ե��� ���� ��ġ��� ������ ��ġ
        	else {
        		answer++;
        		// �ִ� ������ŭ �ű�
        		position += (2 * w + 1);
        	}
        }
        return answer;
    }

}
