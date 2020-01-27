import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int V,E;//정점의 개수, 간선의 개수
	static int [] parent;
	static Edged[] edges;
	static int mincost = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V= sc.nextInt();
		E= sc.nextInt();
		
		parent = new int [V+1];
		edges = new Edged[E];
		
		// 각 정점이 포함된 그래프가 어디인지 저장 parent[]
		for (int i =1; i <=V; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			edges[i] = new Edged(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		//오름차순 정렬
		Arrays.sort(edges, new Comparator<Edged>() {

			@Override
			public int compare(Edged o1, Edged o2) {
				return o1.cost - o2.cost;
			}
		});
		
		for (int i = 0; i < E; i++) {
			int root1 = find(edges[i].x);
			int root2 = find(edges[i].y);
			

			if(root1 == root2) { //같으면 넘어가고
				continue;
			}else { // 다르면 union 후, 연결
				union(root1,root2);
				mincost = mincost+edges[i].cost;
			}
		}
		System.out.println(mincost);
	}
	static void union(int a, int b) {
		  a = find(a);
		  b = find(b);
		  
		  if(a!=b) {
			  parent[b] =a;
		  }
		
	}
	static int find(int x) {
		if(x == parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
}

class Edged { // 간선 정보 저장
	
	int x; 
	int y; 
	int cost; // 비용

	public Edged(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

}
