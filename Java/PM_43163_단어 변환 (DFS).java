package problemSolve4;

public class PM_43163 {
	// PM / 43163�� / �ܾ� ��ȯ / DFS  / Level3
    static int answer;
    static boolean v[];
	public static void main(String[] args) {
		solution("hit", "cog",new String[] {"hot", "dot", "dog", "lot", "log"});
	}
    public static int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        v = new boolean[words.length];

        
        dfs(begin, target, words, 0);
        answer = (answer == Integer.MAX_VALUE) ? 0 : answer; 
        return answer;
    }
    // ��� �ܾ� Ž�� (50���ۿ� ��� Ž�� ����)
    public static void dfs(String begin, String target, String[] words,int count) {
        if(begin.equals(target)) {
            answer = (answer>count) ? count : answer;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(!v[i] && check(begin, words[i])) {
                v[i] = true;
                dfs(words[i], target, words, count+1);
                v[i] = false;
            }
        }
    }
    // ���� �ܾ�(Ž�� �� �ܾ�)�� ��. ���̰� �ϳ��ۿ� �ȳ��� Ž�� ����.
    public static boolean check(String str, String next) {
        int count =0;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) != next.charAt(i)) {
                count++;
            }
        }
        
        return count == 1 ? true : false;
    }
}
