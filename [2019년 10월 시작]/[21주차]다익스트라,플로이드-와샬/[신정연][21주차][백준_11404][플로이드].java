package week22;

import java.io.*;

/*
 * 플로이드 와샬 알고리즘
 * 
 * 백준_11404_플로이드
 */
public class Problem_11404 {
	static final int INF = 1 << 30;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] cost = new int[n+1][n+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i == j) cost[i][j] = 0;
				else cost[i][j] = INF;
			}
		}
		for(int i=0; i<m; i++) {
			String[] input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			if(cost[s][e] != 0) {
				cost[s][e] = Math.min(cost[s][e], c);
			} else {
				cost[s][e] = c;
			}
		}
		
		for(int i=1; i<n+1; i++) {  // 경유
			for(int j=1; j<n+1; j++) {  // 출발
				for(int k=1; k<n+1; k++) {  // 도착
					cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);  // 바로가는 경로와 경유가 있는 경로 중 최소값 저장.
				}
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				System.out.print((cost[i][j] == INF)?0+" ":cost[i][j]+" ");
			}
			System.out.println();
		}
	}
}
