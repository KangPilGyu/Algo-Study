import java.util.*;
public class Main {
	static int n;
	static int[] parent; // 해당 노드의 부모의 노드가 몇번인지
	static List<Integer>[] map;
	static void dfs(int node) {
		//node와 연결된 다른 노드 중
		for(int i : map[node]) {
			//node랑 연결된 다른 노드의 번호를 i가 가지고 있음
			//parent에 대한 정보가 없는 노드를 발견했다면
			if(parent[i] == 0) {
				//그 노드의 부모는 내가 된다.
				parent[i] = node;
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 노드의 개수
		// 다음 n개의 줄에 입력이 들어옴.
		// 일차원 리스트 생성 및 초기화
		map = new List[n + 1];
		parent = new int[n + 1];
		parent[1] = 1;
		// 초기화 블록
		for(int i = 0; i < n + 1; i++) map[i] = new ArrayList<>();
		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			map[a].add(b);
			map[b].add(a);
		}
		dfs(1);
		StringBuffer sb = new StringBuffer();
		for(int i = 2; i <= n; i++) sb.append(parent[i] + "\n");
		System.out.print(sb);
	}
}