package dFS_BFS;
import java.util.*;
/*
 * πÈ¡ÿ_1260_DFSøÕ BFS
 * 
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * --------
 * 1 2 4 3
 * 1 2 3 4
 * 
 * 5 5 3
 * 5 4
 * 5 2
 * 1 2
 * 3 4
 * 3 1
 * ----------
 * 3 1 2 5 4
 * 3 1 4 2 5
 */
public class baekjoon_1260 {
	static int N;
	static int [][] arr;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		arr = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		list = new ArrayList<>();
		list.add(V);
		for(int i : dfs(V)) System.out.print(i+" ");
		System.out.println();

		Queue<Integer> q = new LinkedList<>();
		list = new ArrayList<>();
		q.add(V);
		for(int i : bfs(V, q)) System.out.print(i+" ");
	}

	public static List<Integer> dfs(int v) {
		if(list.size() == N) {
			return list;
		}

		for(int i=1; i<N+1; i++) {
			if((arr[v][i] == 1) && !list.contains(i)) {
				list.add(i);
				list = dfs(i);
			}
		}

		return list;
	}

	public static List<Integer> bfs(int v, Queue<Integer> q) {
		if(list.size() == N) {
			return list;
		}
		
		while(!q.isEmpty()) {		
			int now = q.poll();
			if(!list.contains(now)) {
				list.add(now);
				for(int i=0; i<N+1; i++) {
					if(arr[now][i] == 1 && !list.contains(i))
						q.offer(i);
				}
			}
		}

		return list;
	}
}