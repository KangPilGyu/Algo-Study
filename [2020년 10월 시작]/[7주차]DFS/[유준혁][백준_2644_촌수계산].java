package baekjoon_DFS_BFS;

import java.util.*;
public class baekjoon_2644 {
	static int n, r = -1;
	static int[] vst = new int[101];
	static int[][] arr = new int[101][101];
	static void dfs(int s, int e, int c) {
		vst[s] = 1;
		if(s == e) r = c;
		else {
			for(int i = 1; i <= n; i++) {
				if(vst[i] == 0 && arr[s][i] == 1) {
					dfs(i, e, c + 1);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int a = sc.nextInt(), b = sc.nextInt(), m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			arr[y][x] = arr[x][y] = 1;
		}
		dfs(a, b, 0);
		System.out.print(r);
	}
}
