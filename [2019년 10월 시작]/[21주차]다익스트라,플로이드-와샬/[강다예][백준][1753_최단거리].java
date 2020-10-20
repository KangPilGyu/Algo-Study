import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
첫째 줄에 정점의 개수 V와 간선의 
개수 E가 주어진다. (1≤V≤20,000, 1≤E≤300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 
둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

0
2
3
7
INF
*/
public class Main{
	static int V, E, K; // 정점,간선,시작번호
	static int[] dist;// 시작점부터의 거리를 담음
	static boolean [] vst;
	static ArrayList<Node>[] map; // 노드,간선,거리 정보 담음

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 V = Integer.parseInt(st.nextToken());
		 E = Integer.parseInt(st.nextToken());
		 K = Integer.parseInt(br.readLine());

		map = new ArrayList[V+1];
		vst = new boolean[V+1]; //방문체크용
		for (int i = 0; i <= V; i++) {
			map[i] = new ArrayList<Node>();
		}

		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < E; i++) { // 정보추가
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end =Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[start].add(new Node(end, cost));
		} // for

		solve(K);
		
		for (int i = 1; i <=V; i++) {
			if(vst[i]) System.out.println(dist[i]);
			else System.out.println("INF");
		}
		
	}

	private static void solve(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[K] = 0; // 자기자신과의 거리는 0
		pq.add(new Node(K,dist[K]));
		
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			if(vst[current.end]) {
				continue;
			}
			//방문했기 때문에 true
			vst[current.end] = true;
			for (int i = 0; i <map[current.end].size();  i++) {
				//현재 정점에서 다음 정점을 비교해서 우선순위 큐에 넣어야 한다.
				int next = map[current.end].get(i).end; //다음 정점
				int value = map[current.end].get(i).cost; //현재-다음 간 cost 
				if(!vst[next] && dist[next] > dist[current.end]+value) {//한번도 방문하지 않은 곳은 무조건 dist[next]가 크다.
					dist[next] = dist[current.end]+value;
					pq.add(new Node(next,dist[next]));
				}
			}
		}

	}
}

class Node implements Comparable<Node>{
	public int end;
	public int cost;

	public Node(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		
		return this.cost > o.cost ? 1 : -1;
	}
}