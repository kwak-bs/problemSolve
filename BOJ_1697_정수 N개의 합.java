package problemSolve;

public class Test {
	//BOJ / 1697�� / ���� N���� �� / ��Ģ����, ����, ���� / ��2
	public static long sum(int[] a) {
		long answer = 0; 
		
		for(int i =0; i<a.length; i++) {
			answer += a[i];
		}
		
		return answer; 
	}
}
