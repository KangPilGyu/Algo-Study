package baekjoon_DFS_BFS;

import java.util.*;
public class baekjoon_2589 {
	static int[][] wh = {{1, 0, -1, 0}, {0, 1, 0, -1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), max = 0;
		char[][] arr = new char[n][];
		for(int i = 0; i < n; i++) arr[i] = sc.next().toCharArray();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 'L') {
					Queue<int[]> q = new LinkedList<>();
					boolean[][] vst = new boolean[n][m];
					q.add(new int[] {i, j, 0});
					vst[i][j] = true;
					while(!q.isEmpty()) {
						int[] poll = q.poll();
						int a = poll[0], b = poll[1], c = poll[2];
						max = Math.max(max, c);
						for(int k = 0; k < 4; k++) {
							int A = a + wh[0][k];
							int B = b + wh[1][k];
							if(0 <= A && 0 <= B && A < n && B < m && arr[A][B] == 'L' && vst[A][B] == false) {
								q.add(new int[] {A, B, c + 1});
								vst[A][B] = true;
							}
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
