import java.util.*;
class Main{
	public static void main(String[] ar){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int[] dp = new int[100001], coins = new int[n];
		for(int i = 1; i < 100001; i++) dp[i] = 1 << 30;
		for(int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
			dp[coins[i]] = 1;
		}
		Arrays.sort(coins);
		
		for(int i = 0; i < n; i++){
			for(int j = coins[i]; j <= m; j++){
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
		}
		System.out.print(dp[m] == (1 << 30) ? -1 : dp[m]);
	}
}
