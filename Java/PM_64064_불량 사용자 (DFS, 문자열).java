package problemSolve5;

import java.util.Arrays;
import java.util.HashSet;

public class PM_64064 {
	// PM / 64064�� / �ҷ� ����� / dfs, ���ڿ� / Level3 / 2019 īī�� ������ �ܿ� ���Ͻ�
	public static void main(String[] args) {

		solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"},
				new String[] {"*rodo", "*rodo", "******"});
	}
	static HashSet<String> set;
	static boolean[] v;
    public static int solution(String[] user_id, String[] banned_id) {
        
        set = new HashSet<>();
        v = new boolean[user_id.length];
        
        dfs(0, "", user_id, banned_id);
        return set.size();
    }
    // dfs Ž������ ��� �迭�� Ž���Ѵ�. 
    public static void dfs(int idx, String str, String[] user_id, String[] banned_id) {
    	if(idx == banned_id.length) {
    		String sArr[] = str.split(" ");
    		Arrays.sort(sArr);
    		
    		StringBuffer sb = new StringBuffer();
    		for(String s : sArr) {
    			sb.append(s);
    		}
    		set.add(sb.toString());
    		return;
    	}
    	// *�� ���Խ����� ��ȯ�Ѵ�. 
    	String reg = banned_id[idx].replace("*", "[\\w\\d]");
    	for(int i=0; i<user_id.length; i++) {
    		
    		// matches �޼ҵ带 ����Ͽ� �Ǻ�.
    		if(!v[i] && user_id[i].matches(reg)) {
    			v[i] = true;
    			dfs(idx+1, str+" "+user_id[i], user_id, banned_id);
    			v[i] = false;
    		}
    	}
    }
}
