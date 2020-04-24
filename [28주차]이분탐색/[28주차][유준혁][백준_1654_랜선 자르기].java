package baekjoon_binary_search;
// https://www.acmicpc.net/problem/1654
// 랜선 자르기
/*
 * 전형적인 이분 탐색 문제
 */
import java.util.*;
public class baekjoon_1654 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong(), n = sc.nextLong(), max = Integer.MAX_VALUE, min = 1;
		int[] arr = new int[(int)k];
		for(int i = 0; i < k; i++) arr[i] = sc.nextInt();
		while(min <= max) {
			long cnt = 0;
			long x = (max + min) / 2;
			for(int i : arr) cnt += i / x;
			if(cnt < n) max = x - 1;
			else min = x + 1;
		}
		System.out.println(max);
	}
}
