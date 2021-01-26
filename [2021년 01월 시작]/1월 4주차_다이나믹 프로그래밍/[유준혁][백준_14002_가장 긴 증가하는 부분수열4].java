package baekjoon_DP;

import java.util.*;
public class baekjoon_14002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int [n], dp = new int [n+1], idx = new int[n+1];
		for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			idx[i] = -1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
	                dp[i] = dp[j] + 1;
	                idx[i] = j;
	            }
			}
		}
		List<Integer> list = new ArrayList<>();
		int m = 0, max = Arrays.stream(dp).max().getAsInt();
		for(int i = 0; i < n; i++) m = max == dp[i] ? i : m;
		while(idx[m] != -1) {
			list.add(arr[m]);
			m = idx[m];
		}
		list.add(arr[m]);
		list.sort((a, b) -> -1);
		System.out.println(max);
		for(int i : list) System.out.print(i + " ");
	}
}
