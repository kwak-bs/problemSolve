package problemSolve4;

import java.util.Arrays;
import java.util.HashSet;

public class PM_64065 {
	// PM / 64065�� / Ʃ�� / ����, ���ڿ� / Level2 / 2019 īī�� ������ �ܿ� ���Ͻ� 
	public static void main(String[] args) {
		
		solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
	}

    public static int[] solution(String s) {
        
        // �� �� �߰�ȣ ����
        s = s.substring(1,s.length()-1);
        
        // '{' -> '}' ġȯ
        s = s.replace('{', '}');
        // '{', '}'���� ��� " "�� �ٲ��ش�.
        s = s.replaceAll("[{}]"," ");
        // �� �� ���� ����
        s = s.trim();

        String str[] = s.split(" ,");
        for(int i=0; i<str.length; i++) {
            str[i] = str[i].trim(); // �� ���� ���� ���� 
        }
     
        int[] answer = new int[str.length];
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(str, (o1, o2) -> (o1.length() - o2.length()));
        
        int i =0;
        for(String st : str) {
            String[] tmp = st.split(",");
            for(String tp : tmp) {
                if(!set.contains(Integer.parseInt(tp))) {
                    set.add(Integer.parseInt(tp));
                    answer[i++] = Integer.parseInt(tp);
                }
            }
            
        } 
        return answer;
    }
}
