package baekjoon_tree;
import java.util.*;
public class baekjoon_5567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), cnt = 0;
		int[][] arr = new int[n+1][n+1];
		boolean[] vst = new boolean[n+1];
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 0}); vst[1] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[1] < 2) {
				for(int i = 0; i < n + 1; i++) {
					if(arr[tmp[0]][i] == 1 && !vst[i]) {
						q.add(new int[] {i, tmp[1] + 1});
						vst[i] = true;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
