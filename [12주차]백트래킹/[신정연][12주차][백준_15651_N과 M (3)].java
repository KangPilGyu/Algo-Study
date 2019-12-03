package week12;

import java.util.*;

/*
 * 백준_15649_N과 M(3)
 */
public class Problem_15651 {
	static int N;
	static int M;
	static StringBuffer result = new StringBuffer();

	static void select(int cnt, StringBuffer sb) {
		if(cnt == M) {
//        	System.out.println(sb);  // 조건 만족할 때마다 하나하나 출력하면 오래 걸림. -> 시간초과..ㅜㅜ
			result.append(sb.append("\n"));
			return;
		}
		for(int i=1; i<=N; i++) { // 중복을 허용하기 때문에 vst검사하지 않음.
			select(cnt + 1, new StringBuffer(sb).append(i + " "));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		select(0, new StringBuffer());
		System.out.println(result);
	}
}
