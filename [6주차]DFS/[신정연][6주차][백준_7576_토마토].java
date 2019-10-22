package week6;

import java.util.*;

/*
 * 백준_7576_토마토
 * 
 * BFS로 토마토 익히는 문제. 큐...........
 * 
 * 1	익은 토마토
 * 0	안 익은 토마토
 * -1	비어있음
 * 
 * 6 4
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 * ------------
 * 8				다 익는 데 걸리는 최소 일 수
 * 
 * 6 4
 * 0 -1 0 0 0 0
 * -1 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 * -------------
 * -1				다 익지 못함
 */
class box {
	int x;
	int y;
	public box(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Problem_7576_2 {
	static int[][] arr;
	static Queue<box> q = new LinkedList<>();
	static List<box> visited;
	static int days;
	static int m;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new int[n+2][m+2];
		visited = new ArrayList<>();;
	
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(arr[i][j] == 1) {
					box b = new box(i, j);
					q.offer(b);  // 익은 토마토가 있는 위치 전부 저장.
					visited.add(b);  // 방문한 위치에도 저장.
				}
			}
		}
		
		
		bfs(arr);
		boolean possiblity = true;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(!visited.contains(new box(i, j)) && arr[i][j] == 0) {  // 방문도 못했는데 0이면 얘는 익을 수 없는 토마토임.
					possiblity = false;
				}
			}
		}
		
		if(possiblity) {
			System.out.println(days-1);			
		} else {
			System.out.println(-1);
		}
	}
	
	public static void bfs(int[][] arr) {
		box b;
		int x;
		int y;
		int size = q.size();  // bfs() 호출됐을 때 q의 사이즈.
		
//		Queue<box> temp = new LinkedList<>();  // 이렇게 하면 q를 같이 참조하는거잖아..!
//		
//		while(!q.isEmpty()) {
//			b = q.poll();
//			temp.poll();
//			x = b.x;
//			y = b.y;
//			int[] xs = {x, x, (x-1), (x+1)};
//			int[] ys = {(y-1), (y+1), y, y};
//			
//			for(int j=0; j<xs.length; j++) {
//				if(x>0 && y>0 && x<m+1 && y<n+1) {
//					box bb = new box(xs[j], ys[j]);
//					if(arr[xs[j]][ys[j]] == 0) {					
//						arr[xs[j]][ys[j]] = 1;							
//						q.offer(bb);
//						visited.add(bb);
//					}
//				}
//			}
//		}
		
		for(int i=0; i<size; i++) {  // while 쓰고 싶은데.. q가 자꾸 추가되면... 곤란해..
			b = q.poll();
			x = b.x;
			y = b.y;
			int[] xs = {x, x, (x-1), (x+1)};
			int[] ys = {(y-1), (y+1), y, y};
			
			for(int j=0; j<xs.length; j++) {
				if(x>0 && y>0 && x<m+1 && y<n+1) {
					box bb = new box(xs[j], ys[j]);
					if(arr[xs[j]][ys[j]] == 0) {					
						arr[xs[j]][ys[j]] = 1;							
						q.offer(bb);
						visited.add(bb);
					}
				}
			}
		}
		if(!q.isEmpty()) {
			days++;
			bfs(arr);
		}
	}
}

