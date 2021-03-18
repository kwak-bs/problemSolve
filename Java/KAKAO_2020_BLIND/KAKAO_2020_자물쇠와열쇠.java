package problemSolve3;

public class KAKAO_2020_�ڹ���Ϳ��� {

	public static void main(String[] args) {
		
		KAKAO_2020_�ڹ���Ϳ��� c = new KAKAO_2020_�ڹ���Ϳ���();
		
		int [][] key = {
				{0,0,0},
				{1,0,0},
				{0,1,1}
		};
		
		int[][] lock = {
				{1,1,1},
				{1,1,0},
				{1,0,1}
		};
		c.solution(key, lock);
	}
	
    public boolean solution(int[][] key, int[][] lock) {
    	int offset = key.length-1;
    	
    	for(int r = 0; r < offset + lock.length; r++) {
    		for(int c = 0; c< offset + lock.length ; c++) {
    			for(int rot =0; rot <4; rot++) {
    				int [][] a = new int[58][58];
    				
    				for(int i = 0; i<lock.length; i++) {
    					for(int j=0; j<lock.length; j++) {
    						a[offset + i][offset + j] = lock[i][j];
    					}
    				}
    				
    				match(a, key, rot ,r ,c );
    				if(check(a, offset, lock.length)) return true;
    			}
    		}
    	}
        
        
        return false;
    }
    
    public static boolean check(int[][] a, int offset, int l) {
    	
    	for(int i=offset; i< offset+l; i++ ) {
    		for(int j=offset ; j<offset+l; j++) {
    			
    			if(a[i][j] != 1) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    public static void match(int[][] a, int[][]key, int rot, int r, int c ) {
    	int n = key.length;
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			// ȸ�� x
    			if(rot == 0) {
    				a[r+i][c+j] += key[i][j];    				
    			}
    			//  �ð� ���� ȸ�� 90
    			else if(rot == 1) {
    				a[r+i][c+j] += key[j][n-1-i];
    			}
    			// �ð� ���� ȸ�� 180
    			else if(rot == 2) {
    				a[r+i][c+j] += key[n-1-i][n-1-j]; 
    			}
    			// �ð� ���� ȸ��  270
    			else if(rot == 3) {
    				a[r+i][c+j] += key[n-1-j][i];
    			}
    			
    			if(a[r+i][c+j] == 2) {
    				return;
    			}
    		}
    	}
    	
    	
    }
}
