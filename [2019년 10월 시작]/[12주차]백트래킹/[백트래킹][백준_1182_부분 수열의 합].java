package baekjoon_backtracking;
// https://www.acmicpc.net/problem/1182
// 부분수열의 합
import java.util.*;
public class baekjoon_1182 {
	static int n, x, cnt = 0;
	static int[] arr;
	static void func(int idx, int sum) {
		if(sum == x) cnt++;
		for(int i = idx + 1; i < n; i++) func(i, sum + arr[i]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt();
		sc.nextLine();
		arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(s->new Integer(s)).toArray();
		for(int i = 0; i < n; i++) func(i, arr[i]);
		System.out.println(cnt);
	}
}
