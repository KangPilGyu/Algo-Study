package d0210_BellmanFord_P11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
문제
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 버스가 M개 있다. 각 버스는 A, B, C로 나타낼 수 있는데, A는 시작도시, B는 도착도시, C는 버스를 타고 이동하는데 걸리는 시간이다. 시간 C가 양수가 아닌 경우가 있다. C = 0인 경우는 순간 이동을 하는 경우, C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.

1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 도시의 개수 N (1 ≤ N ≤ 500), 버스 노선의 개수 M (1 ≤ M ≤ 6,000)이 주어진다. 둘째 줄부터 M개의 줄에는 버스 노선의 정보 A, B, C (1 ≤ A, B ≤ N, -10,000 ≤ C ≤ 10,000)가 주어진다. 

출력
만약 1번 도시에서 출발해 어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면 첫째 줄에 -1을 출력한다. 그렇지 않다면 N-1개 줄에 걸쳐 각 줄에 1번 도시에서 출발해 2번 도시, 3번 도시, ..., N번 도시로 가는 가장 빠른 시간을 순서대로 출력한다. 만약 해당 도시로 가는 경로가 없다면 대신 -1을 출력한다.

예제입력1
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2

예제출력1
4
3

예제입력2
3 4
1 2 4
1 3 3
2 3 -4
3 1 -2

예제출력2
-1

예제입력3
3 2
1 2 4
1 2 3

예제출력3
3
-1
 */

public class Main {
	public static final int INF = 500000000;

	public static void main(String[] args) {
		try {
			int V, E;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			Vertex[] vertices = new Vertex[V+1];
			for (int i = 1; i <= V; i++) {
				vertices[i] = new Vertex();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				Edge edge = new Edge(vertices[end], cost);
				
				vertices[start].addEdgeTovertex(edge);
			}
			
			vertices[1].dist = 0;
			
			for (int i = 1; i < V; i++) {
				for (int j = i; j <= V; j++) {
					Vertex v1= vertices[j];
					for (Edge edge : v1.edgeList) {
						Vertex v2 = edge.endVertex;
						int cost = edge.cost;
						if(v1.dist +cost < v2.dist) {
							v2.dist = v1.dist + cost;
						}
					}
				}
				
				for (int j = 1; j < i; j++) {
					Vertex v1= vertices[j];
					for (Edge edge : v1.edgeList) {
						Vertex v2 = edge.endVertex;
						int cost = edge.cost;
						if(v1.dist +cost < v2.dist) {
							v2.dist = v1.dist + cost;
						}
					}
				}
			}

			for(int i = 1; i <= V; i++) {
				Vertex v1 = vertices[i];
				for (Edge edge : v1.edgeList) {
					Vertex v2 = edge.endVertex;
					int cost = edge.cost;
					if(v1.dist + cost < v2.dist) {
						System.out.println("-1");
						br.close();
						return;
					}
				}
			}
			
			
			for (int i = 2; i <= V; i++) {
				if (vertices[i].dist == INF) {
					System.out.println("-1");
				} else {
					System.out.println(vertices[i].dist);
				}
			}
			
			
			
			br.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Vertex implements Comparable<Vertex>{
	public int dist;
	public List<Edge> edgeList;
	
	public Vertex() {
		dist = Main.INF;
		edgeList = new ArrayList<Edge>();
	}
	
	public void addEdgeTovertex(Edge edge) {
		this.edgeList.add(edge);
	}

	@Override
	public int compareTo(Vertex target) {
		return this.dist > target.dist ? 1 : -1;
	}
}

class Edge{
	public Vertex endVertex;
	public int cost;
	
	public Edge(Vertex endVertex, int cost) {
		this.endVertex = endVertex;
		this.cost = cost;
	}
}
