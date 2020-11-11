package baekjoon_DFS_BFS;

import java.util.*;
public class baekjoon_2210 {
	static int[][] arr = new int[5][5], wh = {{0, 1, 0, -1}, {1, 0, -1, 0}};
	static Set<Integer> set = new HashSet<>();
	static void dfs(int x, int y, int cnt, int n) {
		if(cnt == 6) set.add(n);
		else {
			for(int i = 0; i < 4; i++) {
				int a = x + wh[0][i], b = y + wh[1][i];
				if(0 <= a && 0 <= b && a < 5 && b < 5) {
					dfs(a, b, cnt + 1, n * 10 + arr[a][b]);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 25; i++) arr[i/5][i%5] = sc.nextInt();
		for(int i = 0; i < 25; i++) dfs(i/5, i%5, 0, 0);
		System.out.print(set.size());
	}
}
