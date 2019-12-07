package week12;

import java.util.*;

/*
 * 백준_15649_N과 M(2)
 */
public class Problem_15650 {
	static int N;
	static int M;
	static boolean[] vst;
	static StringBuffer result = new StringBuffer();

	static void select(int cnt, int current, StringBuffer sb) {
		if(cnt == M) {
//          System.out.println(sb);
			result.append(sb.append("\n"));
			return;
		}
		for(int i=current+1; i<=N; i++) {
			if (cnt + N - current + 1 < M) return; // 로또 문제와 같은 조건.
			if (!vst[i]) {
				vst[i] = true;
				select(cnt + 1, i, new StringBuffer(sb).append(i + " "));
				vst[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		vst = new boolean[N + 1];
		select(0, 0, new StringBuffer());
		System.out.println(result);
	}
}
