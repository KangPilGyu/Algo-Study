package baekjoon_queue;

import java.util.*;
public class baekjoon_1021_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), idx = 0, cnt = 0;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) arr[i] = i + 1;
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt(), left = 0, right = 0, lc = 0, rc = 0;
			while(arr[(idx + n - left) % n] != x) lc += arr[(idx + n - left++) % n] == 0 ? 1 : 0;
			while(arr[(idx + right) % n] != x) rc += arr[(idx + right++) % n] == 0 ? 1 : 0;
			boolean isLeft = left - lc < right - rc;
			cnt += isLeft ? left - lc : right - rc;
			idx = (isLeft ? idx + n - left : idx + right) % n;
			arr[idx] = 0;
			while(i < n - 1 && arr[idx] == 0) idx = (idx + 1) % n;
		}
		System.out.print(cnt);
	}
}
