package problemSolve;

public class PM_12930 {
	//PM(���α׷��ӽ�) / 12930�� / �̻��� ���� ����� 
	public static void main(String[] args) {
		String s = "  try hello world  ";
		
		PM_12930 c = new PM_12930();
		
		c.solution(s);

	}
	
    public String solution(String s) {
        String answer = "";
        
        String [] temp = s.split(" ", -1); // ���⸦ �������� ���� , -1�� ����� �� �� ������� ���Խ�Ŵ. �̰� �������
        
        for(int i=0; i<temp.length; i++) {
        	char tmp = 0;
        	for(int j=0; j<temp[i].length(); j++) {
        		if(j % 2 == 0) {
        			answer += Character.toUpperCase(temp[i].charAt(j));
        		}
        		else{
        			answer += Character.toLowerCase(temp[i].charAt(j));
        		}
        	}
        	if( i == temp.length-1 ) {
        		continue;        			
        	}
        	else {
        		answer+= " ";       		
        	}
        }
        System.out.println(answer);
        
        return answer;
    }
}
