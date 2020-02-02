package baekjoon_MST;
// https://www.acmicpc.net/problem/2887
// 행성 터널

/*
 * 문제
때는 2040년, 이민혁은 우주에 자신만의 왕국을 만들었다. 
왕국은 N개의 행성으로 이루어져 있다. 
민혁이는 이 행성을 효율적으로 지배하기 위해서 행성을 연결하는 터널을 만들려고 한다.

행성은 3차원 좌표위의 한 점으로 생각하면 된다. 
두 행성 A(xA, yA, zA)와 B(xB, yB, zB)를 터널로 연결할 때 드는 비용은
min(|xA-xB|, |yA-yB|, |zA-zB|)이다.

민혁이는 터널을 총 N-1개 건설해서 모든 행성이 서로 연결되게 하려고 한다. 
이때, 모든 행성을 터널로 연결하는데 필요한 최소 비용을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 행성의 개수 N이 주어진다. 
(1 ≤ N ≤ 100,000) 다음 N개 줄에는 각 행성의 x, y, z좌표가 주어진다. 
좌표는 -109보다 크거나 같고, 109보다 작거나 같은 정수이다. 
한 위치에 행성이 두 개 이상 있는 경우는 없다. 

출력
첫째 줄에 모든 행성을 터널로 연결하는데 필요한 최소 비용을 출력한다.
 */

/*
 * 문제 풀기 전 생각 2020.02.01 23:09
 * ---------------
 * MST와 brute force를 합친 것 같은 문제.
 * 이전에는 입력으로 간선에 대한 정보가 주어졌다면
 * 이번에는 정점에 대한 정보만 주고, 간선에 대한 정보는 직접 만들어야 하는 문제.
 * 그닥 어려울 것 같지는 않다.
 * 각 정점에서 다른 정점으로 연결되는 간선에 대한 정보를 모두 받아 두었다가 크루스칼로 풀면 되지 않을까?
 * 
 * 문제 풀면서 든 생각 2020.02.01 23:26
 * ---------------
 * 아직 제출하기 전이긴 한데.. 행성의 갯수가 10만 까지 들어오는 걸 보면 터질 가능성이 있을 것 같다.
 * 간선에 대한 정보가 대략 50억개가 필요한데... 이게 과연 저장이 될까..?
 * 모르겠다 일단 제출해봄
 * 
 * 제출했더니 역시나 메모리초과 발생.
 * 뭔가 방법이 없을까..
 * 일단 가장 먼저 드는 생각으로는 모든 간선에 대한 정보를 저장할 필요 자체가 없는 것 같다.
 * 적당히 가까운 애들로만 간선의 정보를 저장한다면 모를까.. 애초에 쓰이지도 않을 정보들을 너무 데리고 있는 게 아닐까 한다.
 * 두 점이 충분히 가까운지를 보려면 결국 정렬을 해야한다는 건데.
 * 이건 좀 더 생각을 해봐야겠다.
 * 
 * 재 풀이 전 생각 2020.02.02 22:43
 * ---------------
 * 어제 들었던 생각대로 가까운 두 점을 상대로만 간선을 만드는 게 핵심인 것 같다.
 * 그러기 위해선 정렬이 필요할 것 같고.. 정렬의 조건에 대해선 고민을 좀 더 해봐야겠다.
 * 단순히 x, y, z를 작은 순으로 정렬한다고 치면 x가 같을 때 y, z가 엄청 먼 경우도 생길 수 있을테니까 말이당.
 * 
 * 방법이 생각이 안나서 검색해봤더니 그냥 x, y, z 모두 한 번씩 정렬해서 인접한 노드끼리의 간선만 가져가는 방식이더라.
 * 해봐야징
 * 
 */
import java.util.*;
class Node{
	int x;
	int y;
	int z;
	int idx;
	Node(int x, int y, int z, int idx){
		this.x = x;
		this.y = y;
		this.z = z;
		this.idx = idx;
	}
}
public class baekjoon_2887 {
	static int n;
	static int[] uf;
	static Node[] node;
	static PriorityQueue<int[]> edge = new PriorityQueue<int[]>((a1, a2) -> {return a1[2] - a2[2];});
	static void createEdge(int x) {
		Comparator<Node> comp = (n1, n2) -> n1.x < n2.x ? -1 : 1;
		Arrays.parallelSort(node, comp);
		for(int i = 1; i < n; i++) edge.add(new int[] {node[i - 1].idx, node[i].idx, Math.abs(node[i].x - node[i - 1].x)});
		
		comp = (n1, n2) -> n1.y < n2.y ? -1 : 1;
		Arrays.parallelSort(node, comp);
		for(int i = 1; i < n; i++) edge.add(new int[] {node[i - 1].idx, node[i].idx, Math.abs(node[i].y - node[i - 1].y)});
		
		comp = (n1, n2) -> n1.z < n2.z ? -1 : 1;
		Arrays.parallelSort(node, comp);
		for(int i = 1; i < n; i++) edge.add(new int[] {node[i - 1].idx, node[i].idx, Math.abs(node[i].z - node[i - 1].z)});
	}
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
		n = sc.nextInt();
		uf = new int[n + 1];
		node = new Node[n];
		for(int i = 0; i <= n; i++) uf[i] = i;
		for(int i = 0; i < n; i++) node[i] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
		createEdge(0);
		int sum = 0, cnt = 0;
		while(cnt < n && !edge.isEmpty()) {
			int[] e = edge.poll();
			int a = e[0], b = e[1], cost = e[2];
			if(find(a) != find(b)) {
				union(a, b);
				sum += cost;
				cnt++;
			}
		}
		System.out.println(sum);
	}
}


/*
 * import java.util.*;
class Node{
	int x;
	int y;
	int z;
	Node(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
public class baekjoon_2887 {
	static int n;
	static int[] uf;
	static Node[] node;
	static PriorityQueue<int[]> edge = new PriorityQueue<int[]>((a1, a2) -> {return a1[2] - a2[2];});
	static void createEdge(int x) {
		if(x == n) return;
		Node n1 = node[x];
		for(int i = x + 1; i < n; i++) {
			Node n2 = node[i];
			int min = Math.min(Math.abs(n1.x - n2.x), Math.abs(n1.y - n2.y));
			min = Math.min(min, Math.abs(n1.z - n2.z));
			edge.add(new int[] {x, i, min});
		}
		createEdge(x + 1);
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) uf[b] = a;
	}
	static int find(int a) {
		if(a == uf[a]) return a;
		return uf[a] = find(uf[a]);
	}
	static boolean allSame() {
		int x = uf[1];
		for(int i = 2; i < uf.length; i++) {
			if(x != uf[i]) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		uf = new int[n + 1];
		node = new Node[n];
		for(int i = 0; i <= n; i++) uf[i] = i;
		for(int i = 0; i < n; i++) node[i] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
		createEdge(0);
		int sum = 0;
		while(!(allSame() || edge.isEmpty())) {
			int[] e = edge.poll();
			int a = e[0], b = e[1], cost = e[2];
			if(find(a) != find(b)) {
				union(a, b);
				sum += cost;
			}
		}
		System.out.println(sum);
	}
}
 */
