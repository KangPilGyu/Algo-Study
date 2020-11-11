package baekjoon_DFS_BFS;

import java.util.*;
public class baekjoon_1325 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), max = 0;
		List<Integer>[] arr = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) arr[i] = new ArrayList<>();
		int[] cnt = new int[n+1];
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			arr[b].add(a);
		}
		for(int i = 1; i <= n; i++) {
			int tmp = 0;
			int[] vst = new int[n+1];
			vst[i] = 1;
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			while(!q.isEmpty()) {
				int p = q.poll();
				tmp++;
				for(int next : arr[p]) {
					if(vst[next] == 0) {
						vst[next] = 1;
						q.add(next);
					}
				}
			}
			cnt[i] = tmp;
			max = Math.max(max, tmp);
		}
		for(int i = 1; i <= n; i++) {
			if(cnt[i] == max) System.out.print(i + " ");
		}
	}
}
