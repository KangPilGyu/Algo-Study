package baekjoon_backtracking;
import java.util.*;
public class baekjoon_15649 {
	static int n, m;
	static boolean[] vst;
	static StringBuffer sb = new StringBuffer();
	static void BT(String str, int cnt) {
		if(cnt == m) {
			sb.append(str.trim() + "\n");
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(!vst[i]) {
				vst[i] = true;
				BT(str + i + " ", cnt + 1);
				vst[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		vst = new boolean[n + 1];
		BT("", 0);
		System.out.print(sb);
	}
}
