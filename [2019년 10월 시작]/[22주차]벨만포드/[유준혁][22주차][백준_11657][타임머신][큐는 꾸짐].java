import java.util.*;
import java.io.*;
class Main{
	static int INF = 987654321;
	public static void main(String[] ar) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dist = new int[n];
		for(int i = 1; i < n; i++) dist[i] = INF;
		int[][] route = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i == j) continue;
				route[i][j] = INF;
			}
		}
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			route[from][to] = Math.min(route[from][to], cost);
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		int[] poll;
		int f, cnt;
		while(!queue.isEmpty() && queue.peek()[1] < n){
			poll = queue.poll();
			f = poll[0];
			cnt = poll[1];
			for(int i = 0; i < n; i++){
				if(route[f][i] != INF && dist[i] > dist[f] + route[f][i]){
					dist[i] = dist[f] + route[f][i];
					queue.add(new int[] {i, cnt + 1});
				}
			}
		}
		if(!queue.isEmpty()) System.out.println(-1);
		else{
			for(int i = 1; i < n; i++){
				System.out.println(dist[i] == INF ? -1 : dist[i]);
			}
		}
	}
}
