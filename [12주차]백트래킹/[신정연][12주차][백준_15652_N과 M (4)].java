package week12;

import java.util.*;

/*
 * 백준_15649_N과 M(4)
 */
public class Problem_15652 {
	static int N;
	static int M;
	static StringBuffer result = new StringBuffer();

	static void select(int cnt, int idx, StringBuffer sb) {
		boolean[] vst = new boolean[N + 1]; // vst를 함수 내에서 검사.
		if (cnt == M) {
//          System.out.println(sb);
			result.append(sb.append("\n"));
			return;
		}
		for(int i=idx; i<=N; i++) {
			if(!vst[i]) {
				vst[i] = true;
				select(cnt + 1, i, new StringBuffer(sb).append(i + " "));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		select(0, 1, new StringBuffer());
		System.out.println(result);
	}
}
