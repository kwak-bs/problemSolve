package problemSolve5;

import java.util.ArrayList;
import java.util.HashMap;

public class PM_17684 {
	// PM / 17684�� / ���� / ���� / Level2 / 2018 īī�� ����ε� ä��
	public static void main(String[] args) {

		solution("KAKAO");
	}
	
    public static ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
     
        HashMap<String, Integer> hm = new HashMap<>();
        char al = 'A';
        // map�� (alphabet, ����) ����
        for(int i=1; i<=26; i++) {
            hm.put(String.valueOf(al), i);
            al += 1;
        }
        int idx = 27;
        for(int i=0; i<msg.length(); i++) {
            int j = 1;
            // ���ڿ��� ���ذ��鼭, �� ���ڵ��� ������ �ִ��� �˻�.
            while(i + j <= msg.length() && hm.containsKey(msg.substring(i, i+j))) {
                j++;
            }
            // ���ڿ��� ������ ��� break;
            if(i + j > msg.length()) {
                list.add(hm.get(msg.substring(i)));
                break;
            }
            // ������ ������ (i+j)���� ������ �־��ְ�
            // (i+j-1)������ list�� �־���
            list.add(hm.get(msg.substring(i, i+j-1)));
            hm.put(msg.substring(i, i+j), idx++);

            if(j > 1) i += j -2;
        }

        return list;
    }
}
