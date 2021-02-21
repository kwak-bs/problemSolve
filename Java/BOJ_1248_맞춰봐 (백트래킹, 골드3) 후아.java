package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1248 {
   // BOJ / 1248�� / ����� / ���Ʈ���� / ��3
   static int n;
   static int print[];
   static int sign[][];
   static boolean end;
   static StringBuffer sb;
   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      String s = br.readLine();

      print = new int [n];
      sign = new int [n][n];
      end = false;
      sb = new StringBuffer();
      int cnt = 0;
      for(int i=0; i<n; i++) {
         for(int j=i; j<n; j++) {
            char x = s.charAt(cnt);
            if (x == '0') {
               sign[i][j] = 0;
            } 
            else if (x == '+') {
                sign[i][j] = 1;
            } 
            else {
                sign[i][j] = -1;
            }
            cnt +=1;
         }
      }
      recursion(0);
      
      System.out.println(sb);
   }
   
   public static void recursion(int depth) {

      if(depth == n) {
         end = true;
         for(int value : print) {
            sb.append(value).append(" ");
         }
         
         return;
      }
      //sign[i][i]�� 0�̸� �׳� 0�־��ָ� �ȴ�.
      if(sign[depth][depth] == 0) {
         print[depth] = 0;
         
         recursion(depth + 1);

         // depth�� 4�� ����.
         if(end) {
        	 return;
         }
      }
      // 0�� ������ 1~10���� ��ȣ�� �°� �����ص� print�� �־��ش�.
      // �׸��� check����.
      for(int i=1; i<=10; i++) {
         print[depth] = sign[depth][depth] * i;
         
         if(check(depth)) {
            recursion(depth + 1);
         }
         // depth�� 4�� ����.
         if(end) {
            return;
         }
      }
   }
   
   // sign[index][i]�� ��ȣ�� �������� sign[0][i]���� ��ȣ�� Ž���ϰ�
   // ���������� print[index]�� �������� print[0]���� Ž��.
   // ���� ��ȣ�� �°� ��.
   public static boolean check(int index) {

      int sum = 0;
      for(int i=index; i>=0; i--) {
         sum +=print[i];
         
         if(sign[i][index] == 0) {
            if(sum != 0) return false; 
         } 
         else if(sign[i][index] < 0) {
            if(sum >= 0) return false;
         }
         else if(sign[i][index] > 0) {
            if(sum <= 0) return false;
         }
      }
      
      return true;
   }
}