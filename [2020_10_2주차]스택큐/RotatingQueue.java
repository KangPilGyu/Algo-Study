package queue_deque;

import java.util.*;

public class RotatingQueue {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deq = new LinkedList<>();
		int answer = 0;
		int n = in.nextInt();
		int m = in.nextInt();
		
		for (int i = 1; i <= n; i++) {
			deq.push(i);
		}
		
//		System.out.println("deq : " + deq);
		
		for (int i = 0; i < m; i++) {
			int num = in.nextInt();
			ArrayList<Integer> al = new ArrayList<>();
			al.addAll(deq);
			
			if (al.indexOf(num)+1 > deq.size()/2) {
				int p = deq.pollLast();
				while (p != num) {
					deq.push(p);
					p = deq.pollLast();
					answer++;
				}
//				System.out.println("pollLast ÈÄ deq : " + deq);
//				System.out.println("answer : " + answer);
			}
			
			else {
				int p = deq.poll();
				while (p != num) {
					deq.addLast(p);
					p = deq.poll();
					answer++;
				}
				answer++;
//				System.out.println("poll ÈÄ deq : " + deq);
//				System.out.println("answer : " + answer);
			}
		}
		
		System.out.println(answer);
	}
}