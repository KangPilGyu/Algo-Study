package baekjoon_DFS_BFS;
import java.util.*;
public class baekjoon_2583_bfs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt(), cnt = 0;
		int[][] arr = new int[n][m], wh = new int [][] {{1, 0, -1, 0}, {0, 1, 0, -1}};
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
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i, j});
					arr[i][j] = 1;
					while(!q.isEmpty()) {
						cnt++;
						int[] p = q.poll();
						int x = p[0], y = p[1];
						for(int t = 0; t < 4; t++) {
							int a = x + wh[0][t], b = y + wh[1][t];
							if(0 <= a && 0 <= b && a < n && b < m && arr[a][b] == 0) {
								arr[a][b] = 1;
								q.add(new int[] {a, b});
							}
						}
					}
					list.add(cnt);
				}
			}
		}
		list.sort(null);
		System.out.println(list.size());
		for(int i : list) System.out.print(i + " ");
	}
}
