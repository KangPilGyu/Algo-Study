package baekjoon_bruteforce;
import java.util.*;
public class baekjoon_6603 {
	static void print(int[] lotto, int idx, int cnt, StringBuffer sb) {
		int n = lotto.length;
		if(cnt == 6) {
			System.out.println(sb.toString());
			return;
		}
		for(int i=idx; i < n; i++) {
			if(n - i + cnt + 1 < 6) break;
			print(lotto, i + 1, cnt + 1, new StringBuffer(sb).append(lotto[i] + " "));
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = -1;
		while((n = sc.nextInt()) > 0) {
			int[] lotto = new int [n];
			for(int i=0; i<n; i++) lotto[i] = sc.nextInt();
			print(lotto, 0, 0, new StringBuffer());
			System.out.println();
		}
	}
}
