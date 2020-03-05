import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 알고리즘
// P1753 최단경로

public class Main {
	public static final int INF = 100000000;

	public static void main(String[] args) {
		try {
			int V, E, K;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			V = Integer.parseInt(br.readLine());
			E = Integer.parseInt(br.readLine());
			
			Vertex[] vertices = new Vertex[V+1];
			for (int i = 1; i <= V; i++) {
				vertices[i] = new Vertex();
			}
			
			for (int i = 0; i < E; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				Edge edge = new Edge(vertices[end], cost);
				
				vertices[start].addEdgeTovertex(edge);
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startVertex = Integer.parseInt(st.nextToken());
			int endVertex = Integer.parseInt(st.nextToken());
			
			vertices[startVertex].dist = 0;
			
			PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
			priorityQueue.add(vertices[startVertex]);

			while(priorityQueue.isEmpty() == false) {
				Vertex v1 = priorityQueue.poll();
				for (Edge edge : v1.edgeList) {
					Vertex v2 = edge.endVertex;
					int cost = edge.cost;
					if(v1.dist + cost < v2.dist) {
						v2.dist = v1.dist + cost;
						priorityQueue.add(v2);
					}
				}
			}
			
			System.out.println(vertices[endVertex].dist);
			
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
