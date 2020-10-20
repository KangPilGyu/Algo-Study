package stackdeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class j2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		//123456
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 1; i <=n; i++) {
			que.add(i);
		}
		
		while (que.size() != 1) {
			que.poll();
			int a = que.peek();
			que.poll();
			que.add(a);			
		}
		
		System.out.println(que.peek());
	}
}
