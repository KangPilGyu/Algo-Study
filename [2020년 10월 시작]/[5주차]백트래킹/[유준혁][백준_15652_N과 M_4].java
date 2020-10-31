package baekjoon_backtracking;
import java.util.*;
public class baekjoon_15652 {
	static int n, m;
	static StringBuffer sb = new StringBuffer();
	static void BT(int cnt, String s, int i) {
		if(cnt == m) {
			sb.append(s.trim()+"\n");
			return;
		}
		for(; i <= n; i++) {
			BT(cnt + 1, s + i + " ", i);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		BT(0, "", 1);
		System.out.print(sb);
	}
}
