package baekjoon_DP;

import java.io.*;
import java.util.*;
public class baekjoon_10942 {
	static int Int(String s) {return Integer.parseInt(s);}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Int(br.readLine());
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) arr[i] = Int(st.nextToken());
		for(int i = 1; i <= n; i++) {
			dp[i][i] = 1;
			if(i + 1 <= n && arr[i] == arr[i+1]) dp[i][i+1] = 1;
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 1; i + j <= n; j++) {
				dp[j][i+j] = arr[j] == arr[j+i] && dp[j+1][i+j-1] == 1 ? 1 : 0;
			}
		}
		int q = Int(br.readLine());
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Int(st.nextToken()), b = Int(st.nextToken());
			bw.write(dp[a][b] + "\n");
		}
		bw.flush();
	}
}
