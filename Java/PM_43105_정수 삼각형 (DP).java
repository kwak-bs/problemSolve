package problemSolve4;

public class PM_43105 {
	// PM / 43105�� / ���� �ﰢ�� / DP  / Level3
	public static void main(String[] args) {
		solution( new int[][] {
			{7},
			{3,8},
			{8,1,0},
			{2,7,4,4},
			{4,5,2,6,5}
		});
	}
	
    public static  int solution(int[][] triangle) {
        int n = triangle.length;
        int [][] dp = new int[n][n];
        
        dp[0][0] = triangle[0][0];
        int max = Integer.MIN_VALUE;
        for(int i=1; i<n; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                // �� ����.
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                
                // �� ������ 
                else if(j==triangle[i].length-1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                
                // ��� 
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j]+triangle[i][j]);
                }
                // �ִ��� �Ź� �ʱ�ȭ ���ش�. 
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max;
    }
}
