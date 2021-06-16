package problemSolve5;

import java.util.ArrayList;
import java.util.HashMap;

public class PM_42888 {
	// PM / 42888�� / ����ä�ù� / ���� / Level2 / 2019 KAKAO BLIND 
	public static void main(String[] args) {
		solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
	}
	
    public static String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        
        // leave, enter�� ���ؼ� map ������Ʈ 
        for(int i=0; i<record.length; i++) {
        	String str = record[i];
        	String str_arr[] = str.split(" ");
        	
        	String op = str_arr[0];
        	String id = str_arr[1];
        	String name = "";
        	if(!op.equals("Leave")) {
        		name = str_arr[2];
        	}
        	
        	if(op.equals("Enter")) {
        		hm.put(id, name);
        	}
        	else if(op.equals("Change")) {
        		hm.put(id, name);
        	}
        }
        // ��ɾ msg �߰�
        for(int i=0; i<record.length; i++) {
        	String str = record[i];
        	String str_arr[] = str.split(" ");
        	
        	String op = str_arr[0];
        	String id = str_arr[1];
        	
        	if(op.equals("Enter")) {
        		al.add(hm.get(id)+"���� ���Խ��ϴ�.");
        	}
        	else if(op.equals("Leave")) {
        		al.add(hm.get(id)+"���� �������ϴ�.");
        	}
        }
        String answer[] = new String[al.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = al.get(i);
        }
        return answer;
    }
}
