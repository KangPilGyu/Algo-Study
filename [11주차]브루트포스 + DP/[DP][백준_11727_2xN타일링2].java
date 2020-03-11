package baekjoon_DP;
// https://www.acmicpc.net/problem/11727
// 2*N 타일링 2
// DP의 대표 문제
public class baekjoon_11727 {
	public static void main(String[] args) {
		int n = new java.util.Scanner(System.in).nextInt();
		int[] dp = new int[1001];
		dp[1] = 1; dp[2] = 3;
		for(int i = 3; i <= n; i++) dp[i] = (dp[i-2] * 2 + dp[i-1]) % 10007;
		System.out.println(dp[n]);
	}
}
