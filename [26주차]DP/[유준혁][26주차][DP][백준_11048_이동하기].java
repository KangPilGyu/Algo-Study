import java.util.*;
import java.io.*;
class Main{
    static int Int(String s) {return Integer.parseInt(s);}
	public static void main(String[] ar) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Int(st.nextToken()), m = Int(st.nextToken());
		int[][] map = new int[n][m], dp = new int[n][m];
		for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) map[i][j] = dp[i][j] = Int(st.nextToken());
		}
		for(int i = 1; i < m; i++) dp[0][i] += dp[0][i-1];
		for(int i = 1; i < n; i++) dp[i][0] += dp[i-1][0];
		for(int i = 1; i < n; i++){
			for(int j = 1; j < m; j++){
				dp[i][j] += Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.print(dp[n-1][m-1]);
	}
}
