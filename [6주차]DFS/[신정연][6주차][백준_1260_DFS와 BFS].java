package week6;

import java.util.*;

/*
 * 백준_1260_DFS와 BFS
 * 
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * --------
 * 1 2 4 3
 * 1 2 3 4
 * 
 * 5 5 3
 * 5 4
 * 5 2
 * 1 2
 * 3 4
 * 3 1
 * ----------
 * 3 1 2 5 4
 * 3 1 4 2 5
 */
public class Problem_1260 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 정점 수
		int M = sc.nextInt();	// 간선 수
		int V = sc.nextInt();	// 시작점
		
		int[][] arr = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		List<Integer> list = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		list.add(V);
		
		result = dfs(V, arr, list);
		for(int i=0; i<result.size(); i++ ) {
			System.out.print((i!=result.size()-1)?result.get(i)+" ":result.get(i));
		}
		
		System.out.println();
		
		Queue<Integer> q = new LinkedList<>();  // 발견한 정점을 순서대로 저장하고 꺼낼 queue
		list = new ArrayList<>();  // 결과 저장 list
		list.add(V);  // 시작 정점 저장.
		result = bfs(V, arr, list, q);  // 시작점, 그래프 구조, 결과, 큐
		for(int i=0; i<result.size(); i++ ) {
			System.out.print((i!=result.size()-1)?result.get(i)+" ":result.get(i));
		}
	}
	
	public static List<Integer> dfs(int v, int[][] arr, List<Integer> list) {
		if(list.size() == N) {
			return list;
		}
		
		for(int i=1; i<arr.length; i++) {
			if((arr[v][i] == 1) && !list.contains(i)) {
				list.add(i);
				return dfs(i, arr, list);
			}
		}
		
		return list;
	}
	
	public static List<Integer> bfs(int v, int[][] arr, List<Integer> list, Queue<Integer> q) {
		if(list.size() == N) {
			return list;
		}
		
		for(int i=1; i<arr[v].length; i++) {
			if(arr[v][i] == 1) {
				if(!q.contains(i) && !list.contains(i)) {
					q.offer(i);  // 인접 정점 일단 다 큐에 저장.		
				}
			}
		}
		
		while(!q.isEmpty()) {		
			int now = q.poll();
			if(!list.contains(now)) {
				list.add(now);
				return bfs(now, arr, list, q);
			}
		}
		
		return list;
	}
}
