import java.util.*;
import java.io.*;
class Main{
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] fy = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) fy[i][j] = 0;
				else fy[i][j] = INF;
			}
		}
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			fy[from][to] = Math.min(fy[from][to], cost);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(fy[j][i] + fy[i][k] < fy[j][k])
						fy[j][k] = fy[j][i] + fy[i][k]; 
				}
			}
		}
		for(int[] a : fy) {
			for(int i : a) sb.append((i == INF ? 0 : i) + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
