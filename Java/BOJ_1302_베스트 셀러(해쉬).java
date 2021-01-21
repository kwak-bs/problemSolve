package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class BOJ_1302 {
	//BOJ / 1302�� / ����Ʈ ����  / �ؽ� / ��4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String book = br.readLine();
			map.put(book, map.getOrDefault(book, 0) + 1);
		}
		
		Set<String> keySet = map.keySet();
		
		int max = 0;
		// �ִ� ã��.
		for(String key : keySet) {
			if(map.get(key) > max) {
				max = map.get(key);
			}
		}
		// key�� ���������� ����
		ArrayList<String> al = new ArrayList<String>(map.keySet());
		Collections.sort(al);
		
		for(String temp : al) {
			if(map.get(temp) == max) {
				System.out.println(temp);
				break;
			}
		}
	}
}
