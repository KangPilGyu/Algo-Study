package baekjoon_DFS_BFS;

import java.util.*;
public class baekjoon_2644_bfs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), m = sc.nextInt(), c = 0, r = -1;
		int[] vst = new int[101];
		int[][] arr = new int[101][101];
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			arr[y][x] = arr[x][y] = 1;
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a, 0});
		while(!q.isEmpty()) {
			int[] p = q.poll();
			if(p[0] == b) r = p[1];
			for(int i = 1; i <= n; i++) {
				if(vst[i] == 0 && arr[p[0]][i] == 1) {
					vst[i] = 1;
					q.add(new int[] {i, p[1] + 1});
				}
			}
		}
		System.out.print(r);
	}
}
