package problemSolve;

import java.util.Arrays;
import java.util.Comparator;

public class PM_12915 {
	//PM(���α׷��ӽ�) / 12915�� / ���ڿ� �� ������� �����ϱ� 
	public static void main(String[] args) {
	      
	      String[] strings = {"sun","bed","car"};
	      int n = 1;
	      
	      PM_12915 c = new PM_12915();
	      

	      c.solution(strings, n);

	}
	
    public String[] solution(String[] strings, int n) {
    	
    	Arrays.sort(strings, new Comparator<String>() {
    		@Override
    		public int compare(String s1, String s2) {
    			if(s1.charAt(n) == s2.charAt(n)) {
    				return s1.compareTo(s2);
    			}
    	  		return s1.charAt(n) - s2.charAt(n);	  		
    		}
    	});

    	for(int i=0; i<strings.length; i++) {
    		System.out.println(strings[i]);
    	}
        return strings;
    }
}
