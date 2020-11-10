package baekjoon_binary_search;

import java.util.*;
public class baekjoon_11561 {
	public static void main(String[] args) {
		Scanner sc = new java.util.Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0) {
			long n = sc.nextLong();
			long l = 1, r = Integer.MAX_VALUE;
			while(l <= r) {
				long mid = (l + r) / 2;
				long an = mid * (mid + 1) / 2, anp = (mid + 1) * (mid + 2) / 2;
				if(an <= n && n < anp) {
					l = mid;
					break;
				} else if(anp <= n) l = mid + 1;
				else r = mid - 1;
			}
			System.out.println(l);
		}
	}
}
