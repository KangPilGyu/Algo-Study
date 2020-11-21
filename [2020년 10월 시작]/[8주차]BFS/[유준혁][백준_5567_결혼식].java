package baekjoon_DFS_BFS;

import java.util.*;
import java.io.*;
public class baekjoon_5567{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()) + 1;
		int m = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][n+1];
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		Queue<int[]> q = new LinkedList<>();
		boolean[] vst = new boolean[n];
		int cnt = 0;
		q.add(new int[] {1, 0});
		vst[1] = true;
		while(!q.isEmpty()){
			int[] poll = q.poll();
			int idx = poll[0], link = poll[1];
			if(link < 2) {
				for(int i = 1; i < n; i++) {
					if(arr[idx][i] == 1 && !vst[i]) {
						q.add(new int[] {i, link + 1});
						cnt++;
						vst[i] = true;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}