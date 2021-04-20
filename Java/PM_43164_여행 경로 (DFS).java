package problemSolve4;

import java.util.ArrayList;
import java.util.Collections;

public class PM_43164 {
	// PM / 43164�� / ���� ��� / DFS  / Level3
	
    static ArrayList<String> answers;
    static boolean v[];
	public static void main(String[] args) {
		
		solution(new String[][] {
			{"ICN", "JFK"},
			{"HND", "IAD"},
			{"JFK", "HND"},
		});
	}
	
    public static String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        v = new boolean[tickets.length];
        
        // �����, ���� String �ѱ��. 
        dfs(tickets, "ICN", "ICN", 0);
        
        // ���ĺ� ������ ���� 
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return answer;
    }
    
    public static void dfs(String[][] tickets, String start, String answer, int count) {
      
        if(count == tickets.length) {
            answers.add(answer);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!v[i] && start.equals(tickets[i][0])) {
                v[i] = true;
                dfs(tickets, tickets[i][1], answer+" "+tickets[i][1], count + 1);
                v[i] = false;
            }
        }
    }
}
