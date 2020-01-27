package inputoutput;

import java.util.Arrays;
import java.util.Comparator;

public class Program_islandconnection {
	static int[] parent;
	static int n = 4;
	static int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };

	public static void main(String[] args) {
		System.out.println(solution(n, costs));
	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		parent = new int[n + 1];
		// 사이클테이블
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		// 오름차순 정렬
		Arrays.sort(costs, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[2] - o1[2];
			}

		});
		// 모든 간선 검사
		for (int i = 0; i < costs.length; i++) {
			int root1 = find(costs[i][0]);
			int root2 = find(costs[i][1]);

			if (root1 == root2) {
				continue;
			} else {
				union(root1, root2);
				answer += costs[i][2];
			}
		}

		return answer;
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}

	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}
}
