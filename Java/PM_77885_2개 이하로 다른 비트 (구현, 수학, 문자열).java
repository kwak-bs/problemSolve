package problemSolve5;

public class PM_77885 {
   // PM / 77885�� / 2�� ���Ϸ� �ٸ� ��Ʈ / ����, ����, ���ڿ�  / Level2 / ���� �ڵ� ç���� ����2
   public static void main(String[] args) {
      
      solution(new long[] {2,7});
   }
   
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
           answer[i] = solve(numbers[i]);
        }
        return answer;
    }
    
    public static long solve(long number) {
       long result = number;
       
       // ¦���� +1 (�� ������ 0�� 1�� �ٲ��ָ� ��)
       if(number % 2 == 0) {
          result += 1;
       }
       // Ȧ���� 0�� �ִ� ��� -> ���� ���� 0, 1 -> 1, 0
       // 0�� ���� ��� -> +1 �Ѵ��� ���� ���� 10�� ������ 0 -> 1
       else {
          String Binary = Long.toBinaryString(result);
          
          int firstZero = Binary.lastIndexOf("0");
          // 0�� ������
          if(firstZero != -1) {
        	  int lastOne = Binary.indexOf("1", firstZero);
        	  Binary = Binary.substring(0, firstZero) + "1" 
        			  + Binary.substring(firstZero+1, lastOne) + "0"
        			  + Binary.substring(lastOne+1, Binary.length());
          }
          // 0�� ������ 
          else {
        	  result += 1;
        	  Binary = Long.toBinaryString(result);
        	  Binary = Binary.substring(0,2) + Binary.substring(2, Binary.length()).replaceAll("0", "1");
          }
          result = Long.parseLong(Binary, 2);
       }
       return result;
    }
}