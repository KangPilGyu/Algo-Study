package baekjoon_DFS_BFS;
import java.util.*;
public class baekjoon_2583 {
	static int[][] wh = new int [][] {{1, 0, -1, 0}, {0, 1, 0, -1}}, arr;
	static int cnt = 0, n, m;
	static void dfs(int a, int b) {
		arr[a][b] = 1;
		cnt++;
		for(int i = 0; i < 4; i++) {
			int x = a + wh[0][i], y = b + wh[1][i];
			if(0 <= x && 0 <= y && x < n && y < m && arr[x][y] == 0) dfs(x, y);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt(); n = sc.nextInt(); int k = sc.nextInt();
		arr = new int[n][m];
		for(int i = 0; i < k; i++) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
			for(int x = a; x < c; x++) {
				for(int y = b; y < d; y++) {
					arr[x][y] = 1;
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					cnt = 0;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		list.sort(null);
		System.out.println(list.size());
		for(int i : list) System.out.print(i + " ");
	}
}
