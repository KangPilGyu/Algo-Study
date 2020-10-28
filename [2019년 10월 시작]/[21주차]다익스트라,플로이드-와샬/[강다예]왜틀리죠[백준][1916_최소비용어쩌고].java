import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 
그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

4
*/
public class Main{
	static int N, M;
	static ArrayList<Bus>[] list;
	static int[] dist;
	static final int max = 100000;
	static boolean[] vst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		vst = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Bus>();
		}

		dist = new int[N + 1];
		Arrays.fill(dist, max);

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[v1].add(new Bus(v2, cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		solve(start, dest);

	}

	static void solve(int start, int dest) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		// 자기자신은 0
		dist[start] = 0;		
		pq.add(new Bus(start, dist[start]));

		while (!pq.isEmpty()) {
			Bus bs = pq.poll();
			int current = bs.end;
			if (vst[current]) {
				continue;
			}
			// 방문완료
			vst[current] = true;
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i).end;
				int cost = list[current].get(i).cost;

				if (!vst[next] && dist[next] > dist[current] + cost) {
					dist[next] = dist[current] + cost;
					pq.add(new Bus(next, dist[next]));
				}
			}
		}

		System.out.println(dist[dest]);
	}

}

class Bus implements Comparable<Bus> {
	int end;
	int cost;

	public Bus(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Bus o) {
		return this.cost > o.cost ? 1 : -1;
	}
}
