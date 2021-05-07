package problemSolve5;

import java.util.Arrays;
import java.util.Comparator;

public class PM_17686 {
	// PM / 17686�� / ���ϸ� ���� / ���ڿ�, ���� / Level2 / 2018 īī�� ����ε� ä�� 3��
	public static void main(String[] args) {
		solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
	}
	
    public static String[] solution(String[] files) {
        
        Arrays.sort(files, new Comparator<String>(){
           @Override
           public int compare(String s1, String s2) {
               String[] f1 = detach(s1);
               String[] f2 = detach(s2);
               
               String h1 = f1[0];
               String h2 = f2[0];
               
               // HEAD �� ������
               if(h1.equals(h2)) {
                   // NUMBER ���� ����
                   int n1 = Integer.parseInt(f1[1]);
                   int n2 = Integer.parseInt(f2[1]);
                   
                   return n1 - n2;
               }
               // HEAD�� �ٸ��� ���� �� ���� 
               else {
                   return h1.compareTo(h2);
               }
           }
           
           private String[] detach(String str) {
               String head = "";
               String num = "";
               String tail = "";
               
               int idx = 0;
               // HEAD
               for(; idx<str.length(); idx++) {
                   char ch = str.charAt(idx);
                   if(ch >= '0' && ch <= '9') break;
                   head += ch;
               }
               // NUMBER
               for(; idx<str.length(); idx++) {
                   char ch = str.charAt(idx);
                   if(!(ch >= '0' && ch <= '9')) break;
                   num += ch;
               }
               
               // TAIL
               for(; idx < str.length(); idx++) {
                   char ch = str.charAt(idx);
                   tail += ch;
               }
               
               
               String [] file= {head.toLowerCase(), num, tail};
               return file;
           }
       });
       return files;
   }

}
