package baekjoon_DFS_BFS;
import java.util.*;
public class baekjoon_1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		if(n >= k) {
			System.out.println(n-k);
			return;
		}
		boolean [] visit = new boolean [100001];
		Queue<int []> que = new LinkedList<int[]>();
		que.add(new int [] {n, 0});
		while(!que.isEmpty()) {
			int x = que.peek()[0];
			int y = que.peek()[1];
			if(x == k)break;
			que.poll();
			visit[x] = true;
			if(x<100000 && !visit[x+1]) que.add(new int [] {x+1, y+1});
			if(1 < x && !visit[x-1]) que.add(new int [] {x-1, y+1});
			if(x*2 < 100001 && !visit[x*2]) que.add(new int [] {x*2, y+1});
		}
		System.out.println(que.poll()[1]);
	}
}
