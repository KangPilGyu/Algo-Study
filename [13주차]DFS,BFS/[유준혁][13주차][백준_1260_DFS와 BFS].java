package baekjoon_DFSBFS;
import java.util.*;
public class baekjoon_1260 {
	static int[][] map; // 인접 행렬
	static boolean[] vst; // 방문 저장 boolean 배열
	
	static void dfs(int v) { // 재귀적으로 탐색하는 dfs
		vst[v] = true; System.out.print(v + " "); // 방문했다고 저장, 출력
		for(int i = 1; i < map.length; i++) {  // 인접 행렬의 v 행 탐색
			if(!vst[i] && map[v][i] == 1) dfs(i); // 방문하지 않았고, 연결되어 있다면 재귀 실행
		}
	}
	
	static void bfs(int v) { // Queue를 이용하는 bfs
		Queue<Integer> q = new LinkedList<>();
		q.add(v); vst[v] = true; // 시작점을 큐에 넣어둠, 방문 표시
		while(!q.isEmpty()) { // 큐에 원소가 있는동안 계속 탐색
			int a = q.poll(); // 맨 앞 원소 꺼냄
			System.out.print(a+" "); // 출력
			for(int i = 1; i < map.length; i++) { // 인접 행렬의 a행 탐색
				if(!vst[i] && map[a][i] == 1) {
					vst[i] = true;
					q.add(i); // 큐 맨 뒤에 넣어줌
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), v = sc.nextInt();
		map = new int[n+1][n+1];
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			map[a][b] = map[b][a] = 1; // 양방향이므로 a,b b,a 둘 다 1로 만들어줌
		}
		
		vst = new boolean[n+1]; dfs(v);
		System.out.println();
		vst = new boolean[n+1]; bfs(v);
	}
}
