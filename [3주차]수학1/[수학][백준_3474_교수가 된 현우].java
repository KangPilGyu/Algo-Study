package baekjoon_basic;
// https://www.acmicpc.net/problem/3474
// 교수가 된 현우
import java.util.*;
public class baekjoon_3474 {
	static int func(int x) {
		int five = 0, f = 5, tmp = x;
		while(f <= x) {
			five += tmp / f;
			f *= 5;
		}
		return five;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) sb.append(func(sc.nextInt()) + "\n");
		System.out.print(sb.toString());
	}
}
