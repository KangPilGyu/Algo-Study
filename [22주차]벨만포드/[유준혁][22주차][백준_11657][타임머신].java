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
		int[][] route = new int[m][3];
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			route[i][0] = from;
			route[i][1] = to;
			route[i][2] = cost;
			if(from == 0) dist[to] = Math.min(dist[to], cost);
		}
		boolean update = false;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				int[] rte = route[j];
				int f = rte[0], t = rte[1], c = rte[2];
				if(dist[f] != INF && dist[t] > dist[f] + c){
					dist[t] = dist[f] + c;
					if(i == n - 1) update = true;
				}
			}
		}
		if(update) System.out.println(-1);
		else{
			for(int i = 1; i < n; i++){
				System.out.println(dist[i] == INF ? -1 : dist[i]);
			}
		}
	}
}
