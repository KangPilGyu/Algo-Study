import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PlanetTunnel {

	static final int INF = 200000;
	public static void main(String[] args) {
		try {
			int V, E, K;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(br.readLine());
			
			Vertex[] vertices = new Vertex[V+1];
			String[] edges = new String[V+1];
						
			for (int i = 1; i <= V; i++) {
				vertices[i] = new Vertex();
				vertices[i].dist = INF;
				vertices[i].name = i;
				edges[i] = "";
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edges[Integer.parseInt(st.nextToken())] += st.nextToken() + " " + st.nextToken() + " ";
			}		
			
			vertices[K].dist = 0;
			
			PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>();
			
			for (int i = 1; i <= V; i++) {
				priorityQueue.add(vertices[i]);
			}
			
			for (int i = 1; i <= V; i++) {
				Vertex v1 = priorityQueue.poll();
				st = new StringTokenizer(edges[v1.name]);
				
				for (int j = 0; j < ( st.countTokens() / 2 ); j++) {
					Vertex v2 = vertices[Integer.parseInt(st.nextToken())];
					int cost = Integer.parseInt(st.nextToken());
					
					if(v2.dist == INF || (v1.dist + cost) < v2.dist) {
						v2.dist = (v1.dist + cost);
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
	int dist, name;

	@Override
	public int compareTo(Vertex target) {
		return this.dist > target.dist ? 1 : -1;
	}
	
	
}