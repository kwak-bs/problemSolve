package problemSolve4;

public class KAKAO_2020_����˻� {

	public static void main(String[] args) {
		
		KAKAO_2020_����˻� c = new KAKAO_2020_����˻�();
		
		String [] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String [] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		c.solution(words, queries);
	}
	
	class Trie {
		Trie[] child = new Trie[26];
		int count;
		int aletter = Character.getNumericValue('a');
		
		void insert(String str) {
			Trie curr = this; // ������ ���� ��ü , curr�� root���� �����ϴ°���.
			
			for(char ch : str.toCharArray()) {
				curr.count++;
				int idx = Character.getNumericValue(ch) - aletter;
				if(curr.child[idx] == null) {
					curr.child[idx] = new Trie();
				}
				curr = curr.child[idx];
			}
		}
		
		int search(String str) {
			Trie curr = this;
			for(char ch : str.toCharArray()) {
				if(ch == '?') return curr.count;
				
				curr = curr.child[Character.getNumericValue(ch) - aletter];
				if(curr == null) return 0;
			}
			
			return curr.count; // ������� �̸��� ���� �������� , ? ���ڰ� ���°� ó���� �� ����
		}
	}
	
	Trie[] TrieRoot = new Trie[10000];
	Trie[] RevTrieRoot = new Trie[10000];
	
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int ansIdx = 0;
        
        for(String str : words) {
        	int idx = str.length() - 1;
        	if(TrieRoot[idx] == null) {
        		TrieRoot[idx] = new Trie();
        		RevTrieRoot[idx] = new Trie();
        	}
        	
        	TrieRoot[idx].insert(str);
        	str = new StringBuilder(str).reverse().toString();
        	RevTrieRoot[idx].insert(str);
        }
        
        for(String str : queries) {
        	int idx = str.length() - 1;
        	if(TrieRoot[idx] == null) {
        		answer[ansIdx++] = 0;
        		continue;
        	}
        	// ������ �˻�
        	if(str.charAt(0) != '?') {
        		answer[ansIdx++] = TrieRoot[idx].search(str);
        	}
        	// ������ �˻�
        	else {
        		str = new StringBuilder(str).reverse().toString();
        		answer[ansIdx++] = RevTrieRoot[idx].search(str);
        	}
        }
        
        return answer;
    }
}
