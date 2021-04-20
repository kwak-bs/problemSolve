package problemSolve4;

import java.util.Arrays;

public class PM_49191 {
	// PM / 49191�� / ���� / �÷��̵� �ͼ�  / Level3
    static final int INF = 987654321;
	public static void main(String[] args) {

		solution(5, new int[][] {
			{4,3},
			{4,2},
			{3,2},
			{1,2},
			{2,5},
		});
	}
	
    public static int solution(int n, int[][] results) {
        int answer = 0;
        boolean [][] c = new boolean[n+1][n+1];
        
        for(int i=0; i<results.length; i++) {
            // win -> lose �� ���� �׷��� 
            c[results[i][0]][results[i][1]] = true;
        }
        
        for(int k=1; k<=n; k++) { // ������
            for(int i=1; i<=n; i++) { // ����� 
                for(int j=1; j<=n; j++) { // ������
                    if(i != j && c[i][k] && c[k][j]) {
                        // i ������ ���� j �������� ������� ������ �� �� ����.
                        c[i][j] = true;
                    }
                }
            }
        }
 
        for(int i=1; i<=n; i++) { // i ���� ����
            boolean pass = true;
            for(int j=1; j<=n; j++) { // j ������ (���) Ž��
                // i ���� j �������� ������� ������ �� ���̶� �� �� ���ϸ� i������ ��Ȯ�� ������ �� �� ����, �� i ���� ��� ���鿡 ���� �����ؾ��Ѵ�. 
                if(i != j && !(c[i][j] || c[j][i])) {
                    pass = false;
                    break;
                }
            }
            if(pass) answer++;
        }
        return answer;
    }
}
