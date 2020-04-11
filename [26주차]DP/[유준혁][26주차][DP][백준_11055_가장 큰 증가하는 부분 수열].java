package baekjoon_lis;
// https://www.acmicpc.net/problem/11055
// 가장 큰 증가하는 부분 수열
import java.util.*;
public class baekjoon_11055 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int [n], dp = new int [n+1];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		for(int i=0; i<n; i++) {
			dp[i] = arr[i];
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
	                dp[i] = dp[j] + arr[i];
	            }
			}
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}
