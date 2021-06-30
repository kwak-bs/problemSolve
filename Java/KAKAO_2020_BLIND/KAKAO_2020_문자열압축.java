package problemSolve5;

import java.util.HashMap;

public class KAKAO_2020_���ڿ����� {
	// PM / 1835�� / ��ü���� ��� / ���� / Level2 / 2017 īī�� �ڵ� ����
	public static void main(String[] args) {
		solution(2, new String[] {"N~F=0", "R~T>2"});
	}
	static int position[], count;
	static HashMap<String, Integer> hm;
	static boolean v[];
    public static int solution(int n, String[] data) {
        int answer = 0;
        // �̰� ����ߵ� �����ָ� ���� �� . ������ ����
        count = 0;
        v = new boolean[8];
        position = new int[8];
        hm = new HashMap<>();
        
        // map�� Ȱ���� �̸� �־���
        hm.put("A", 0);
        hm.put("C", 1);
        hm.put("F", 2);
        hm.put("J", 3);
        hm.put("M", 4);
        hm.put("N", 5);
        hm.put("R", 6);
        hm.put("T", 7);
        
        perm(0, data);
        answer = count; 
        System.out.println(answer);
        return answer;
    }
    // ������ �̿��Ͽ� ��� ����� ���� Ž��.
    public static void perm(int depth, String[] data) {
    	
    	if(depth == 8) {
    		if(check(data)) {
    			count++;
    		}
    		return;
    	}
    	
    	for(int i=0; i<8; i++) {
    		if(!v[i]) {
    			v[i] = true;
    			position[depth] = i;
    			perm(depth + 1, data);
    			v[i] = false;
    		}
    	}
    }
    // ���� �Ǻ�
    public static boolean check(String[] data) {
    	
    	for(int i=0; i<data.length; i++) {
    		String temp = data[i];
    		
    		String a = temp.substring(0,1);
    		String b = temp.substring(2,3);
    		String op = temp.substring(3,4);
    		int diff = Integer.parseInt(temp.substring(4, 5));
    		// a,b�� ��ġ (map�� Ȱ��)
    		int ap = position[hm.get(a)];
    		int bp = position[hm.get(b)];

    		// -1�� ����� ������ �Ÿ��� ���� �� �ִ�.
    		if(op.equals(">")) {
    			if(!(Math.abs(ap - bp)-1 > diff)) return false; 
    		}
    		else if(op.equals("<")) {
    			if(!(Math.abs(ap-bp)-1 < diff)) return false;
    		}
    		else if(op.equals("=")) {
    			if(Math.abs(ap-bp)-1 != diff) return false;
    		}
    	}
    	
    	return true;
    }
}
