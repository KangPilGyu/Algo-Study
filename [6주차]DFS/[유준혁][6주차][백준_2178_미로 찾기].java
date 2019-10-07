package dFS_BFS;
import java.util.*;
public class baekjoon_2178 {
	static int x,y;
	static int [] dx = {1,0,-1,0}; // 오른쪽부터 시계방향으로 확인
	static int [] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x=sc.nextInt(); y=sc.nextInt();
		int [][] map = new int [x][y]; // 지도를 그려줄 이차원배열
		boolean [][] visit = new boolean [x][y]; // 방문 여부를 확인해줄 이차원 boolean 배열
		for(int i=0; i<x; i++) {
			byte[] arr = sc.next().getBytes(); //아니 평소엔 공백으로 구분지어서 주더니 왜 이번엔 다 붙여서준대요?
			for(int j=0; j<y; j++) {
				map[i][j] = arr[j]-'0';
			}
		}
		Queue<int[]> que = new LinkedList<int[]>(); // BFS를 담당해줄 queue 선언. 전 그냥 배열을 원소로 삼기로 했음
		que.add(new int [] {0,0}); // 기본값 넣어주고
		while(!que.isEmpty()) { // que 에 무언가 있다면 계속 돌림.
			int [] idx = que.poll();
			int a = idx[0], b = idx[1]; // 큐의 맨 앞에 있는 배열 꺼내서 좌표값 빼옴.
			visit[a][b] = true; // 방문여부를 true로 만들어줌.
//			System.out.println(a+","+b);
			for(int i=0; i<4; i++) {
				int nx = a+dx[i], ny = b+dy[i];
				if(nx == x-1 && ny == y-1) { // 끝 점에 도달했다면 출력하고 끝냄
					System.out.println(map[a][b] + 1);
					return;
				}
				if(0<=nx && nx<x && 0<=ny && ny<y) { //지도를 벗어나는 지 확인
					if(!visit[nx][ny] && map[nx][ny] == 1) {// 방문한적이 없고, map에서 갈 수 있는 경로인 경우
						map[nx][ny] = map[a][b] + 1; // 해당 경로의 값을 현재 경로의 값 + 1 해줌 
						que.add(new int [] {nx,ny}); // 큐에 경로를 집어넣어서 다시 탐색할 수 있도록 해줌.
					}
				}
			}
		}
		/* 확인을 위한 출력문
		System.out.println(que.size());
		for(int [] ar : map) {
			for(int i : ar) System.out.print(i);
			System.out.println();
		}
		System.out.println("--------------------");
		for(boolean [] bool : visit) {
			for(boolean b : bool) {
				System.out.print(b?1:0);
			}
			System.out.println();
		}
		*/
	}
}
