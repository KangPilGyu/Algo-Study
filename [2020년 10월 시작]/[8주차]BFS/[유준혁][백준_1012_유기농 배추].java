package baekjoon_DFS_BFS;
import java.util.*;
public class baekjoon_1012 {
	static int[][] wh = new int[][] {{1, 0, -1, 0}, {0, 1, 0, -1}};
	public static void bfs(int[][] arr, int i, int j){
		Queue<int[]> q = new LinkedList<>();
		arr[i][j] = 0;
		q.add(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for(int k = 0; k < 4; k++) {
				int a = p[0] + wh[0][k];
				int b = p[1] + wh[1][k];
				if(0 <= a && a < arr.length && 0 <= b && b < arr[0].length) {
					if(arr[a][b] == 1) {
						q.add(new int [] {a, b});
						arr[a][b] = 0;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0) {
			int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt(), cnt = 0;
			int[][] arr = new int[n][m];
			for(int i = 0; i < k; i++) arr[sc.nextInt()][sc.nextInt()] = 1;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(arr[i][j] == 1) {
						cnt++;
						bfs(arr, i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
