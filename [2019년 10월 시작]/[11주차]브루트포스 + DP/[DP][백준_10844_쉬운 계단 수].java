package baekjoon_DP;

// https://www.acmicpc.net/problem/10844
// 쉬운 계단 수
import java.util.*;
public class baekjoon_10844 {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt(), mod = 1000000000;
		int[] arr = new int[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		for(int i = 1; i < n; i++) {
			int[] tmp = new int[10];
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					tmp[0] = arr[1] % mod;
					continue;
				}
				if(j == 9) {
					tmp[9] = arr[8] % mod;
					continue;
				}
				tmp[j] = (arr[j-1] + arr[j+1]) % mod;
			}
			arr = tmp;
		}
		int sum = 0;
		for(int i = 0; i < 10; i++) sum = (sum + arr[i]) % mod;
		System.out.println(sum);
	}
}
