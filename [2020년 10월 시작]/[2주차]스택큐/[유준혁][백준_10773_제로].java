package baekjoon_stack;

import java.util.*;
public class baekjoon_10773_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), idx = 0, sum = 0;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			idx += x == 0 ? -1 : 0;
			arr[idx] = x;
			idx += x == 0 ? 0 : 1;
		}
		for(int i : arr) sum += i;
		System.out.print(sum);
	}
}
