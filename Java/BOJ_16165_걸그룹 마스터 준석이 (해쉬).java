package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_16165 {
	// BOJ / 16165�� / �ɱ׷� ������ �ؼ��� / �ؽ� / ��3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		HashMap<String, Object> teamMap = new HashMap<>(); // map�� value ������ ArrayList�� ����ϱ� ����.
		HashMap<String, String> MemberMap = new HashMap<>();		
		
		for(int i=0; i <n; i++) {
			String team = br.readLine();
			int member = Integer.parseInt(br.readLine());
			
			ArrayList<String> al = new ArrayList<>();
			
			for(int j=0; j<member; j++) {
				// ��� �̸��� �Է� �޾� MemberMap key������ �־��ְ� (������ 1�ϰ�츦 �ذ��ϱ� ����)
				// team���� ������ al�� ��� �̸��� �־��ش�.
				
				String name = br.readLine();
				al.add(name);
				MemberMap.put(name, team);
			}
			
			// team���� map�� ArrayList�� �����Ѵ�.  
			// ���Ⱑ �߿� ����Ʈ.
			teamMap.put(team, al);
		}
		
		Set<String> mapSet = teamMap.keySet();
		Set<String> map2Set = MemberMap.keySet();
		
		for(int i=0; i<m; i++) {
			String temp = br.readLine();
			int prob = Integer.parseInt(br.readLine());
			
			//�� �̸� ������ ��� ��� ������ ���.
			if(prob == 0 ) {
				for(String key : mapSet) {
					//System.out.println(map.get(key).toString().split(",").length);
					if(key.equals(temp)) {
						
						int len = teamMap.get(key).toString().length();

						// �� ���� '[' , ']' �����Ѵ�.
						String[] members = teamMap.get(key).toString().substring(1, len-1).split(", ");
						// ������ ����
						Arrays.sort(members);

						for(int j=0; j<members.length; j++) {
							System.out.println(members[j]);
						}
					}
				}
			}
			
			//��� �̸� ������ ��� �� �̸� ���.
			else if(prob == 1) {
				for(String key : map2Set) {
					if(key.equals(temp)) {
						System.out.println(MemberMap.get(temp));						
					}
				}
			}
		}
	}
}
