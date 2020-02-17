import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 200000;

	public static void main(String[] args) {
		try {
			int V, E, K;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(br.readLine());
			
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
			
			vertices[K].dist = 0;
			
			PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
			priorityQueue.add(vertices[K]);
			/*
			 * for (int i = 1; i <= V; i++) { priorityQueue.add(vertices[i]); }
			 */
						
			/*
			 * for (int i = 1; i <= V; i++) { Vertex vertex = priorityQueue.poll(); for
			 * (Edge edge : vertex.edgeList) { int v1 = edge.startVertex.dist; int v2 =
			 * edge.endVertex.dist; int cost = edge.cost;
			 * 
			 * if(v1 == INF) {
			 * 
			 * }else if(v2 == INF || v1 + cost < v2) { edge.endVertex.dist = v1 + cost; } }
			 * }
			 */
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
			
			for (int i = 1; i <= V; i++) {
				if (vertices[i].dist == INF) {
					System.out.println("INF");
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
