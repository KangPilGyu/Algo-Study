package baekjoon_backtracking;
import java.util.*;
public class baekjoon_15650 {
	static int n, m;
	static void func(int cnt, String s, int start) {
		if(cnt == m) {
			System.out.println(s.trim());
			return;
		}
		for(int i=start; i<=n - m + cnt + 1; i++) {
			func(cnt + 1, s + i + " ", i + 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		func(0, "", 1);
	}
}
