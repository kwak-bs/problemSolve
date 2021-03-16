package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20327 {
	// BOJ / 20327�� / �迭 ������6 / ����, �ùķ��̼� / ���5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		int size = (1 << n);
		int a[][] = new int[size][size];
		
		for(int i=0; i<size; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<size; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken()); 
			}
		}
		
		while(r-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(stk.nextToken());
			int l = Integer.parseInt(stk.nextToken());
			
			int sub_size = (1 << l);
			
			if(1<=k && k <= 4) {
				// �κ� ���� ��� ��û
				for(int i=0; i<size; i+= sub_size) {
					for(int j=0; j<size; j+= sub_size) {
						op_1_to_4(a, k, i, j, sub_size);
					}
				}
			}
			else if(k >= 5 && k<= 8) {
				if( k== 5) {
					a = op5(a, l);
				}
				else if(k == 6) {
					a = op6(a,l);
				}
				else if(k == 7) {
					a = op7(a,l);
				}
				else if(k == 8) {
					a = op8(a,l);
				}
			}
		}
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
	}
	
	public static void op_1_to_4(int [][]a, int k, int sy, int sx, int len) {
		
		int b[][] = new int[len][len];
		// �κ� ���� �ʱ�ȭ
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				b[i][j] = a[sy+i][sx+j];
			}
		}
		
		if(k == 1) {
			b = op1(b);
		} else if(k == 2) {
			b = op2(b);
		} else if(k == 3) {
			b = op3(b);
		} else if(k == 4) {
			b = op4(b);
		}
		// �ٲ� �迭 a�� �ٽ� �����
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				a[sy+i][sx+j] = b[i][j];
			}
		}
	}
	// ���� ���� 
	public static int[][] op1 (int [][] a) {
		int n = a.length; 
		int ans[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans[i][j] = a[n-i-1][j];
			}
		}
		return ans;
	}
	
	// �¿� ����
	public static int[][] op2(int [][]a) {
		int n = a.length; 
		int ans[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans[i][j] = a[i][n-j-1];
			}
		}
		
		return ans;
	}
	
	// ������ 90�� ȸ��
	public static int[][] op3(int [][]a) {
		int n = a.length;
		int ans[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans[i][j] = a[n-j-1][i];
			}
		}
		
		return ans;
	}
	// ���� 90�� ȸ��
	public static int[][] op4 (int [][] a) {
		int n = a.length;
		int ans[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans[i][j] = a[j][n-1-i];
			}
		}
		
		return ans;
	}
	
	// �κ� �迭=1ĭ ���� ���� 
	public static int[][] op5 (int [][] a, int l) {
		
		int n = a.length; 
		int ans[][] = new int[n][n];
		int sub_size = (1 << l);
		int sub_cnt = n / sub_size;
		for(int i=0; i<sub_cnt; i++) {
			for(int j=0; j<sub_cnt; j++) {
				// ���� �κ� �迭�� ���� ��� 
				int y1 = i * sub_size;
				int x1 = j * sub_size;
				
				// �ٲ��� �� �迭�� ���� ���
				int y2 = (sub_cnt-i-1) * sub_size;
				int x2 = j * sub_size;
				
				for(int y=0; y<sub_size; y++) {
					for(int x=0; x<sub_size; x++) {
						ans[y1+y][x1+x] = a[y2+y][x2+x];
					}
				}
			}
		}
		return ans;
	}
	
	// �κ� �迭=1ĭ  �¿� ����
	public static int[][] op6 (int [][] a, int l) {
		
		int n = a.length; 
		int ans[][] = new int[n][n];
		int sub_size = (1 << l);
		int sub_cnt = n / sub_size;
		for(int i=0; i<sub_cnt; i++) {
			for(int j=0; j<sub_cnt; j++) {
				// ���� �κ� �迭�� ���� ��� 
				int y1 = i * sub_size;
				int x1 = j * sub_size;
				
				// �ٲ��� �� �迭�� ���� ���
				int y2 = i * sub_size;
				int x2 = (sub_cnt-j-1) * sub_size;
				
				for(int y=0; y<sub_size; y++) {
					for(int x=0; x<sub_size; x++) {
						ans[y1+y][x1+x] = a[y2+y][x2+x];
					}
				}
			}
		}
		return ans;
	}
	
	// �κ� �迭=1ĭ ������ 90�� ȸ��
	public static int[][] op7 (int [][] a, int l) {
		
		int n = a.length; 
		int ans[][] = new int[n][n];
		int sub_size = (1 << l);
		int sub_cnt = n / sub_size;
		for(int i=0; i<sub_cnt; i++) {
			for(int j=0; j<sub_cnt; j++) {
				// ���� �κ� �迭�� ���� ��� 
				int y1 = i * sub_size;
				int x1 = j * sub_size;
				
				// �ٲ��� �� �迭�� ���� ���
				int y2 = (sub_cnt-j-1) * sub_size;
				int x2 = i * sub_size;
				
				for(int y=0; y<sub_size; y++) {
					for(int x=0; x<sub_size; x++) {
						ans[y1+y][x1+x] = a[y2+y][x2+x];
					}
				}
			}
		}
		return ans;
	}
	
	// �κ� �迭=1ĭ  ���� 90�� ȸ��
	public static int[][] op8(int [][] a, int l) {
		
		int n = a.length; 
		int ans[][] = new int[n][n];
		int sub_size = (1 << l);
		int sub_cnt = n / sub_size;
		for(int i=0; i<sub_cnt; i++) {
			for(int j=0; j<sub_cnt; j++) {
				// ���� �κ� �迭�� ���� ��� 
				int y1 = i * sub_size;
				int x1 = j * sub_size;
				
				// �ٲ��� �� �迭�� ���� ���
				int y2 = j * sub_size;
				int x2 = (sub_cnt-i-1) * sub_size;
				
				for(int y=0; y<sub_size; y++) {
					for(int x=0; x<sub_size; x++) {
						ans[y1+y][x1+x] = a[y2+y][x2+x];
					}
				}
			}
		}
		return ans;
	}
}
