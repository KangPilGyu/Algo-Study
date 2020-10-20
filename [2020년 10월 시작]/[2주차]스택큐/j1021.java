package stackdeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
10 3 
1 2 3
*/
public class j1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 1; i <=n; i++) {
			dq.add(i);
		}

		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		
		for (int i = 0; i < m; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			int idx = 1;
			for(int d : dq) {
				if(a == d) break;
				idx++;
			}
			
			System.out.println("idx:" + idx);
			
			int front = idx;
			int back = dq.size()-idx+1;
			
			if (front < back) {
				if (a == dq.peekFirst()) {
					dq.pollFirst();
				}else {
					int num = dq.peekFirst();
					dq.addLast(num);
					dq.pollFirst();
				}
				
				cnt++;
			}else {
				if( a== dq.peekLast()) {
					dq.pollLast();
				}else {
					int num = dq.peekLast();
					dq.addFirst(num);
					dq.pollLast();
				}
				cnt++;
			}

		}
		
		System.out.println(cnt);

	}
}
