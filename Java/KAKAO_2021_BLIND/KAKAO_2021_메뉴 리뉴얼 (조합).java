package problemSolve2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class PM_KAKAO_2021_2 {
	//KAKAO 2021/ 2�� / �޴� ������  
	
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		
		String orders[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int course[] = {2,3,4};

		PM_KAKAO_2021_2 c = new PM_KAKAO_2021_2();
		
		c.solution(orders, course);
	}
	
	
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        ArrayList<String> al = new ArrayList<>();
		int lenArr[] = new int [course[course.length-1] +1];
		
        for(int i=0; i<orders.length; i++) {
        	char ch[] = orders[i].toCharArray();
        	Arrays.sort(ch);
        	
        	for(int j=0; j<course.length; j++) {
        		nCr(ch, orders[i].length(), course[j],0 , "");
        	}
        }
        Set<String> keyset = map.keySet();
        
        // ������ ���� ���� �ִ� ����.
        for(String key : keyset) {
        	if(map.get(key) >= 2) {
        		if(lenArr[key.length()] < map.get(key)) {
        			lenArr[key.length()] = map.get(key);
        		}
        	}
        }
        
        // ������ ���� ���� �ִ񰪰� ���ؼ� ������ ����Ʈ�� �߰�.
        for(String key : keyset) {
        	if(lenArr[key.length()] == map.get(key)) {
        		al.add(key);
        	}
        }
        Collections.sort(al);
        answer = new String[al.size()];
        
        for(int i=0; i<al.size(); i++) {
        	answer[i] = al.get(i);
        }
        
        return answer;
    }
    
    // ����
    public static void nCr(char[] ch, int n, int r, int start, String result) {
    	 
    	if(r == 0) {
    		map.put(result, map.getOrDefault(result, 0) +1);
    		return;
    	}
    	else {
    		for(int i=start; i<ch.length; i++) {
    			nCr(ch, n, r-1, i+1, result+ch[i]);
    		}
    	}
    }
}
