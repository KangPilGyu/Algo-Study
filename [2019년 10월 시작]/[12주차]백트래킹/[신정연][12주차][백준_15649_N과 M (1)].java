package week12;

import java.util.*;

/*
 * น้มุ_15649_Nฐ๚ M(1)
 */
public class Problem_15649 {
	static int N;
	static int M;
	static boolean[] vst;
	static StringBuffer result = new StringBuffer();

	static void select(int cnt, StringBuffer sb) {
		if(cnt == M) {
//          System.out.println(sb);
			result.append(sb.append("\n"));
			return;
		}
		for(int i=1; i<N+1; i++) {
			if (!vst[i]) {
				vst[i] = true;
				select(cnt + 1, new StringBuffer(sb).append(i + " "));
				vst[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		vst = new boolean[N + 1];
		select(0, new StringBuffer());
		System.out.println(result);
	}
}
