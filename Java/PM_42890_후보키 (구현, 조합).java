package problemSolve5;

import java.util.ArrayList;
import java.util.HashSet;

public class PM_42890 {
	// PM / 42890�� / �ĺ�Ű / ����,���� / Level2 / 2019 īī�� ����ε� ä��
    static ArrayList<HashSet<Integer>> cdKey;
    static String map[][];
    static int answer, len;
	public static void main(String[] args) {
		
		solution(new String[][] {
			{"100","ryan","music","2"},
			{"200","apeach","math","2"},
			{"300","tube","computer","3"},
			{"400","con","computer","4"},
			{"500","muzi","music","3"},
			{"600","apeach","music","2"}
		});
	}

    public static int solution(String[][] relation) {
        answer = 0;
        cdKey = new ArrayList<>();
        map = relation;
        len = relation[0].length;
        // �Ӽ� ������ŭ Ž�� 
        for(int i=1; i<=len; i++) {
            makeSet(-1, i, 0, new HashSet<Integer>());
        }
        
        return answer;
    }
    public static void makeSet(int index, int target, int count, HashSet<Integer> set) {
        
        if(count == target) {
            // ���ϼ��� �����ϴ���
            if(!isUnique(set)) {
                return;
            }
            // �ּҼ��� �����ϴ��� 
            for(HashSet<Integer> key : cdKey) {
                //set�� key�� ���ҵ��� ��� �����Ѵ�.
                if(set.containsAll(key)) {
                    return;
                }
            }
            cdKey.add(set);
            answer++;
            return;
        }
        
        for(int i=index+1; i<len; i++) {
            // ()�ȿ� set�� �־���� ������ newSet�� set�� ���� �̹� �����ִ�.
            HashSet<Integer> newSet = new HashSet<Integer>(set);
            newSet.add(i);
            makeSet(i, target, count + 1, newSet);
        }
    }
    public static boolean isUnique(HashSet<Integer> set) {
        
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<map.length; i++) {
            String temp = "";
            for(int index : set) {
                temp+= map[i][index];
            }
            if(!list.contains(temp)) {
                list.add(temp);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
