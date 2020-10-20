package week20;

import java.util.*;

/*
 * 최소 신장 트리 - 크루스칼 알고리즘
 * 백준_9372_상근이의 여행
 */
public class Problem_9372 {
	static int[] Ns;
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			Ns[b] = a;
		}
	}
	public static int find(int a) {
		if(Ns[a] == a) {
			return a;
		} else {
			return Ns[a] = find(Ns[a]);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Ns = new int[N+1];
			for(int j=0; j<N+1; j++) Ns[j] = j;
			int cnt = 0;
			for(int j=0; j<M; j++) {
				int N1 = sc.nextInt();
				int N2 = sc.nextInt();
				if(find(N1) != find(N2)) {
					union(N1, N2);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
