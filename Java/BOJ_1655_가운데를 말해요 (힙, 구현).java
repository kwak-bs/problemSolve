package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1655 {
	// BOJ / 1655�� / ����� ���ؿ� / ����, �� / ���2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			// �� ���� ����� ������ maxHeap�� �߰�.
			// �Է� ���� minHeap�� �ּڰ�(peek)���� ũ�� �� ���� swap
			if(minHeap.size() == maxHeap.size()) {
				maxHeap.add(num);
			}
			// �� ���� ����� �ٸ��� minHeap�� �߰� 
			// �Է� ���� maxHeap�� �ִ�(peek)���� ������ �� ���� swap
			else {
				minHeap.add(num);
			}
			if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
				if(minHeap.peek() < maxHeap.peek()) {
					int tmp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(tmp);
				}
			}
			// maxHeap�� top�� ��ġ�� ���� �߰����� �ǰ� �Ѵ�. 
			sb.append(maxHeap.peek()+"\n");
		}
		System.out.println(sb);
	}
}
