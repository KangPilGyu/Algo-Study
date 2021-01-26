package baekjoon_DP;

import java.util.*;
public class baekjoon_1890 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		long[][] dp = new long[n][n];
		dp[0][0] = 1;
		for(int i = 0; i < n * n; i++) arr[i/n][i%n] = sc.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(dp[i][j] > 0 && arr[i][j] != 0) {
					int a = i + arr[i][j], b = j, c = i, d = j + arr[i][j];
					if(0 <= a && 0 <= b && a < n && b < n) dp[a][b] += dp[i][j];
					if(0 <= c && 0 <= d && c < n && d < n) dp[c][d] += dp[i][j];
				}
			}
		}
		System.out.println(dp[n-1][n-1]);
	}
}
