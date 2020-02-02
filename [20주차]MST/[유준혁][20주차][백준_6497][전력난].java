package baekjoon_MST;
// https://www.acmicpc.net/problem/6497
// 전력난

/*
 * 문제
성진이는 한 도시의 시장인데 거지라서 전력난에 끙끙댄다. 
그래서 원래 모든 길마다 켜져 있던 가로등 중 일부를 소등하기로 하였다. 
길의 가로등을 켜 두면 하루에 길의 미터 수만큼 돈이 들어가는데, 일부를 소등하여 그만큼의 돈을 절약할 수 있다.

그러나 만약 어떤 두 집을 왕래할 때, 불이 켜져 있지 않은 길을 반드시 지나야 한다면 위험하다. 
그래서 도시에 있는 모든 두 집 쌍에 대해, 불이 켜진 길만으로 서로를 왕래할 수 있어야 한다.

위 조건을 지키면서 절약할 수 있는 최대 액수를 구하시오.

입력
입력은 여러 개의 테스트 케이스로 구분되어 있다.

각 테스트 케이스의 첫째 줄에는 집의 수 m과 길의 수 n이 주어진다. (1 ≤ m ≤ 200000, m-1 ≤ n ≤ 200000)

이어서 n개의 줄에 각 길에 대한 정보 x, y, z가 주어지는데, 
이는 x번 집과 y번 집 사이에 양방향 도로가 있으며 그 거리가 z미터라는 뜻이다. (0 ≤ x, y < m, x ≠ y)

도시는 항상 연결 그래프의 형태이고(즉, 어떤 두 집을 골라도 서로 왕래할 수 있는 경로가 있다), 
도시상의 모든 길의 거리 합은 2의 31승 미터보다 작다.

입력의 끝에서는 첫 줄에 0이 2개 주어진다.

출력
각 테스트 케이스마다 한 줄에 걸쳐 절약할 수 있는 최대 비용을 출력한다.
 */

/*
 * 문제 풀기 전 생각 2020.02.02 23:27
 * -------------
 * 그냥 일반적인 MST인듯.
 * 대신 절약할 수 있는 비용을 출력해야 함.
 * 
 * 문제 풀고 난 후 생각 2020.02.02 23:35
 * -------------
 * 딱히 어려운 건 없었으나 메모리랑 시간이 좀 맘에 안들긴 한다.
 * 슬슬 코드의 길이보단 보기 쉽고 효율적인 코드를 짜야할 시기가 오는듯?
 * 그치만 바꾸긴 귀찮으니 이대로 해야징
 */
import java.util.*;
public class baekjoon_6497 {
	static int[] uf;
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) uf[b] = a;
	}
	static int find(int a) {
		if(a == uf[a]) return a;
		return uf[a] = find(uf[a]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0, m = 0;
		while((n = sc.nextInt()) != 0 && (m = sc.nextInt()) != 0) {
			int sum = 0, cnt = 0;
			uf = new int[n];
			for(int i = 1; i < n; i++) uf[i] = i;
			PriorityQueue<int[]> pq = new PriorityQueue<int[]>((i1, i2) -> {return i1[2] - i2[2];});
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
				pq.add(new int[] {a, b, c});
				sum += c;
			}
			while(cnt < n - 1 && !pq.isEmpty()) {
				int[] arr = pq.poll();
				int a = arr[0], b = arr[1], c = arr[2];
				if(find(a) != find(b)) {
					union(a, b);
					sum -= c;
				}
			}
			System.out.println(sum);
		}
	}
}
