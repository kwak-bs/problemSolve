package problemSolve5;

import java.util.ArrayList;

public class PM_17677 {
	// PM / 17677�� / ���� Ŭ�����͸� / ���ڿ�, �ڷᱸ��  / Level2 / 2018 īī�� ����ε� ä��
	public static void main(String[] args) {
		
		solution("FRANCE", "french");
	}
	
    public static int solution(String str1, String str2) {
        int answer = 0;
        
        int cnt = 0;
        ArrayList<String> al1 = new ArrayList<>();
        ArrayList<String> al2 = new ArrayList<>();
        String s = "";
        
        //al1 ����Ʈ�� �� ���ھ� ��� ���� �����
        for(int i=0; i<str1.length(); i++) {
            char ch = str1.charAt(i);
            if((ch >= 'a' && ch <= 'z') || ch >= 'A' && ch <= 'Z') {
                if(ch >= 'A' && ch <= 'Z') {
                    ch = Character.toLowerCase(ch);
                }
                s += (ch + "");
                cnt++;
            }
            else {
                s="";
                cnt = 0;
                continue;
            }
            if(cnt == 2) {
                al1.add(s);
                cnt = 0;
                s = "";
                // �ι�° ���ڸ� �ѹ��� �־�����ϹǷ� 
                i--;
            }
        }
        s = "";
        cnt = 0;
        //al2 ����Ʈ�� �� ���ھ� ��� ���� �����
        for(int i=0; i<str2.length(); i++) {
            char ch = str2.charAt(i);
            if((ch >= 'a' && ch <= 'z') || ch >= 'A' && ch <= 'Z') {
                if(ch >= 'A' && ch <= 'Z') {
                    ch = Character.toLowerCase(ch);
                }
                s += (ch + "");
                cnt++;
            }
            else {
                s="";
                cnt = 0;
                continue;
            }
            if(cnt == 2) {
                al2.add(s);
                cnt = 0;
                s = "";
                // �ι�° ���ڸ� �ѹ��� �־�����ϹǷ� 
                i--;
            }
        }

        // ������ ����� (al3)
        ArrayList<String> al2_t = new ArrayList<>();
        al2_t.addAll(al2);
        ArrayList<String> al3 = new ArrayList<>();
        for(int i=0; i<al1.size(); i++) {
            String tmp = al1.get(i);
            if(al2_t.contains(tmp)) {
                al3.add(tmp);
                al2_t.remove(tmp);
            }
        }
        
        // ������ ũ��
        double a = (double)al3.size();
        
        // al1���� ������ ����� 
        ArrayList<String> al3_t = new ArrayList<>();
        al3_t.addAll(al3);
        for(int i=0; i<al2.size(); i++) {
            String tmp = al2.get(i);
            if(al3_t.contains(tmp)) {
                al3_t.remove(tmp);
            }
            else {
                al1.add(tmp);
            }
        }
        double b = (double)al1.size();
        if(a == 0 && b == 0) {
            a = 1;
            b = 1;
        }
        answer = (int)((a / b) * 65536);
        
        return answer;
    }

}
