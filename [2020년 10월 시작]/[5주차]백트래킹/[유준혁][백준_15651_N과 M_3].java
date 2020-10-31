package baekjoon_backtracking;
import java.util.*;
public class baekjoon_15651 {
	static int n, m;
	static StringBuffer sb = new StringBuffer();
	static void func(int cnt, String s) {
		if(cnt == m) {
			sb.append(s.trim()+"\n");
			return;
		}
		for(int i = 1; i <= n; i++) {
			func(cnt + 1, s + i + " ");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		func(0, "");
		System.out.print(sb);
	}
}
