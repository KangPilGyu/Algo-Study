package week17;

import java.util.*;

/*
 * 백준_5567_결혼식
 * 
 * 상근이(1)의 친구, 친구의 친구
 * 
 * 6	n : 동기 수
 * 5	m : 행의 수
 * 1 2
 * 1 3
 * 3 4
 * 2 3
 * 4 5
8
8
1 2
1 3
4 1
5 1
2 6
3 7
8 7
2 3
 */
public class Problem_5567 {
	static int n;
	static int m;
	public static void dfs(int[][] list, int friend, int level, boolean[] vst) {
		if(level == 2) return;
		for(int i=0; i<m; i++) {
			if(list[i][0] == friend && vst[list[i][1]] == false) {
				vst[list[i][1]] = true;
				dfs(list, list[i][1], level+1, vst);
			} else if(list[i][1] == friend && vst[list[i][0]] == false) {
				vst[list[i][0]] = true;
				dfs(list, list[i][0], level+1, vst);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] list = new int[m][2];
		for(int i=0; i<m; i++) {
			list[i][0] = sc.nextInt();
			list[i][1] = sc.nextInt();
		}
		
		boolean[] vst = new boolean[n+1];
		vst[1] = true;  // 상근이
		
		for(int i=0; i<m; i++) {
			int level = 0;  // 친구의 친구는 level 2
			if(list[i][0] == 1) {
				vst[list[i][1]] = true;
				dfs(list, list[i][1], level+1, vst);
			} else if(list[i][1] == 1) {
				vst[list[i][0]] = true;
				dfs(list, list[i][0], level+1, vst);
			}
		}
		int invited = -1;
		for(boolean v : vst) invited += (v?1:0);
		
//		Queue<Integer> q = new LinkedList<>();
//		q.add(1);  // 상근이의 학번
//		while(!q.isEmpty()) {
//			int current = q.poll();  // 현채 친구
//			for(int i=0; i<m; i++) {
//				int friend1 = list[i][0];  // 현재 친구의 친구
//				int friend2 = list[i][1];  // 현재 친구의 친구
//				if(list[i][0] == current && vst[friend2] == false) {  // 현재 친구의 친구에 방문하지 않았다면
//					q.add(friend2);
//					vst[friend2] = true;
//					invited++;
//				} else if(list[i][1] == current && vst[friend1] == false) {
//					q.add(friend1);
//					vst[friend1] = true;
//					invited++;
//				}
//			}
//			level++;  // 상근이의 친구를 다 돌면 level == 1, 친구의 친구까지 다 돌면 level == 2
//			if(level == 2) break;
//		}
		
		System.out.println(invited);
	}
}
