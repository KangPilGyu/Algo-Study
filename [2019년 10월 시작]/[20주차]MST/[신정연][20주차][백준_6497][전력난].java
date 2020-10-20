package week20;

import java.util.*;

/*
 * 최소 신장 트리 - 크루스칼 알고리즘
 * 백준_6497_전력난
 */
public class Problem_6497 {
	static int[] houses;
	public static int find(int a) {
		if(houses[a] != a) {
			return houses[a] = find(houses[a]);
		} else {
			return a;
		}
	}
	public static void union(int a,  int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			houses[b] = a;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		int n;
		while((m = sc.nextInt()) != 0 && (n = sc.nextInt()) != 0) {
			houses = new int[m];
			for(int i=0; i<m; i++) houses[i] = i;
			
			List<int[]> list = new ArrayList<>();
			for(int i=0; i<n; i++) {
				list.add(new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() });
			}
			
			list.sort((o1, o2) -> {return o1[2] - o2[2];});
			int saveCost = 0;
			for(int[] l : list) {
				if(find(l[0]) != find(l[1])) {
					union(l[0], l[1]);
				} else {
					saveCost += l[2];
				}
			}
			System.out.println(saveCost);
		}
	}
}
