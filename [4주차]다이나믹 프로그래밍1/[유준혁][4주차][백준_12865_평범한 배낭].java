package baekjoon_DP;
import java.util.*;
public class baekjoon_12865 {
	static int [][] items;
	static int [][] dp;
	static int func(int pos, int max) {
		if (pos == items.length) return 0;
		int val = dp[pos][max];
		if(val != -1) return val;
		if(items[pos][0] <= max) {
			val = items[pos][1] + func(pos+1, max - items[pos][0]);
		}
		val = Math.max(val, func(pos+1, max));
		return dp[pos][max]=val;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		items = new int [sc.nextInt()][2];
		int max = sc.nextInt();
		for(int i=0; i<items.length*2; i++) {
			items[i/2][i%2] = sc.nextInt();
		}
		dp = new int [items.length][100001];
		for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
		System.out.println(func(0, max));
	}
}
