package problemSolve5;
import java.util.*;
public class PM_67257 {
	// PM / 67257�� / ���� �ִ�ȭ / ���ڿ�, ����, ����  / Level2 / 2020 īī�� ���Ͻ�
    static String exp;
    static ArrayList<Long> numList; // ���� ����
    static ArrayList<Character> opList; // ������ ���� 
    static Character op[] = {'+','-', '*'}; // ������ 3�� 
    static Character tmp[] = new Character[3]; // ������ ���� ���(�켱����)
    static boolean v[] = new boolean[3];
    static long answer;
	public static void main(String[] args) {
	
		solution("100-200*300-500+20");
	}
    public static long solution(String expression) {
        answer = Long.MIN_VALUE;
        numList = new ArrayList<>();
        opList = new ArrayList<>();
        exp = expression;
        String n = "";
        
        for(int i=0; i<exp.length(); i++) {
            char ch = exp.charAt(i);
            if(ch== '+' || ch== '*' || ch== '-' ) {
                opList.add(ch);
                numList.add(Long.parseLong(n));
                n = "";
            }
            else {
                n += (ch+"");
            }
        }
        numList.add(Long.parseLong(n));
        
        perm(0, 3);
        
        return answer;
    }
	
    // ������ �켱������ ������ ���ؼ� ���Ѵ�. 
    public static void perm(int depth, int l) {
        
        if(depth == l) {
            solve();
            return;
        }
        
        for(int i=0; i<op.length; i++) {
            if(!v[i]) {
                v[i] = true;
                tmp[depth] = op[i];
                perm(depth+1, l);
                v[i] = false;
            }
        }
    }
	
    // �켱������ �������� �� ������ answer�� ���� (�ִ��� ���ö� ����)
    public static void solve() {
        
        ArrayList<Character> opT = new ArrayList<>();
        opT.addAll(opList);
        
        ArrayList<Long> numT = new ArrayList<>();
        numT.addAll(numList);
        
        for(int i=0; i<tmp.length; i++) {
            char o = tmp[i];
            
            for(int j=0; j<opT.size(); j++) {
                // ���� �켱������ �����ڿ� ��ġ�ϸ�
                if(o == opT.get(j)) {
                    long n1 = numT.get(j);
                    long n2 = numT.get(j+1);
                    // ���
                    long ans = calc(n1,n2, o);
                    // ���� ����
                    numT.remove(j+1); // +1 ���� ������ ��ߵ�
                    numT.remove(j);
                    // ������ ����
                    opT.remove(j);
                    // ��� ��� �ֱ�
                    numT.add(j, ans);
                    
                    // ���������� �ε����� �ϳ� �ٿ��ش�.
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(numT.get(0)));
    }
	
    // ���
    public static long calc(long n1, long n2, Character o) {
        long ans = 0;
        if(o == '+') {
            ans = n1 + n2;
        }
        else if(o == '-') {
            ans = n1 - n2;
        }
        else if(o == '*') {
            ans = n1 * n2;
        }
        return ans;
    }
}
