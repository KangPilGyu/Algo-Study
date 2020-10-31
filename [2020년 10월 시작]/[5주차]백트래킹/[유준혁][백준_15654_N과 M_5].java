package baekjoon_backtracking;

import java.util.*;
public class baekjoon_15654 {
	static int[] arr, vst;
	static int n, m;
	static StringBuffer sb = new StringBuffer();
	static void BT(int cnt, String s) {
		if(cnt == m) {
			sb.append(s.trim()+"\n");
			return;
		}
		for(int i = 0; i < n; i++) {
			if(vst[i] == 0) {
				vst[i] = 1;
				BT(cnt + 1, s + arr[i] + " ");
				vst[i] = 0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		vst = new int[n];
		for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		BT(0, "");
		System.out.print(sb);
	}
}
