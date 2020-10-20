package baekjoon_bruteforce;
import java.util.*;
public class baekjoon_14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int [17][2]; int[]dp = new int [17];
		for(int i=0; i<n*2; i++) arr[i/2][i%2] = sc.nextInt();
		int rst = 0;
		for(int i=0; i<n+1; i++) {
			int j = i + arr[i][0];
			if(j <= n) {
				rst = Math.max(rst, dp[j] = Math.max(dp[j], dp[i] + arr[i][1]));
			}
			
			rst = Math.max(rst, dp[i+1] = Math.max(dp[i+1], dp[i]));
		}
		
		System.out.println(rst);
	}
}
