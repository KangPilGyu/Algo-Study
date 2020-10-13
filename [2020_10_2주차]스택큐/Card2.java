package queue_deque;

import java.util.*;

public class Card2 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Queue<Integer> q = new LinkedList<>();
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		while (q.size() > 1) {
			q.poll();
			q.add(q.poll());
		}
		
		answer = q.peek();
		
		System.out.println(answer);
	}
}