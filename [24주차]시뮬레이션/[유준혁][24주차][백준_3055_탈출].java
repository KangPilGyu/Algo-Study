package baekjoon_simulation;
// https://www.acmicpc.net/problem/3055
// 탈출
/*
 * 문제
사악한 암흑의 군주 이민혁은 드디어 마법 구슬을 손에 넣었고, 
그 능력을 실험해보기 위해 근처의 티떱숲에 홍수를 일으키려고 한다. 
이 숲에는 고슴도치가 한 마리 살고 있다. 
고슴도치는 제일 친한 친구인 비버의 굴로 가능한 빨리 도망가 홍수를 피하려고 한다.

티떱숲의 지도는 R행 C열로 이루어져 있다. 
비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 
비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.

매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다. (위, 아래, 오른쪽, 왼쪽) 
물도 매 분마다 비어있는 칸으로 확장한다. 
물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 
물과 고슴도치는 돌을 통과할 수 없다. 
또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.

티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 
필요한 최소 시간을 구하는 프로그램을 작성하시오.

고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 
즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 
이동할 수 있으면 고슴도치가 물에 빠지기 때문이다. 

입력
첫째 줄에 50보다 작거나 같은 자연수 R과 C가 주어진다.

다음 R개 줄에는 티떱숲의 지도가 주어지며, 문제에서 설명한 문자만 주어진다. 
'D'와 'S'는 하나씩만 주어진다.

출력
첫째 줄에 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간을 출력한다. 
만약, 안전하게 비버의 굴로 이동할 수 없다면, "KAKTUS"를 출력한다.
 */
/*
 * 문제 풀기 전 생각 2020.02.29 17:15
 * -----------------------------
 * BFS를 두 개 동시에 돌리는 문제인듯
 */
import java.util.*;
public class baekjoon_3055 {
	static int[][] WH = new int[][] {{1, 0, -1, 0}, {0, 1, 0, -1}};
	static boolean[][] W, A;
	static boolean range(int n, int m, int x, int y) {
		return 0 <= x && 0 <= y && x < n && y < m;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		Queue<int[]> water = new LinkedList<>();
		Queue<int[]> animal = new LinkedList<>();
		W = new boolean[n][m];
		A = new boolean[n][m];
		char[][] map = new char[n][];
		for(int i = 0; i < n; i++) map[i] = sc.next().toCharArray();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 'S') {
					animal.add(new int[] {i, j, 0});
					A[i][j] = true;
				}
				if(map[i][j] == '*') {
					water.add(new int[] {i, j, 0});
					W[i][j] = true;
				}
			}
		}
		int cnt = 0;
		while(true) {
			while(true) {
				if(water.size() == 0) break;
				if(water.peek()[2] != cnt) break;
				int[] wtr = water.poll();
				for(int i = 0; i < 4; i++) {
					int x = wtr[0] + WH[0][i];
					int y = wtr[1] + WH[1][i];
					if(range(n, m, x, y)) {
						if(map[x][y] == '.' && !W[x][y]) {
							water.add(new int[] {x, y, cnt + 1});
							map[x][y] = '*';
							W[x][y] = true;
						}
					}
				}
			}
			while(true) {
				if(animal.size() == 0) {
					System.out.println("KAKTUS");
					return;
				}
				if(animal.peek()[2] != cnt) break;
				int[] aml = animal.poll();
				for(int i = 0; i < 4; i++) {
					int x = aml[0] + WH[0][i];
					int y = aml[1] + WH[1][i];
					if(range(n, m, x, y)) {
						if(map[x][y] == '.' && !A[x][y]) {
							animal.add(new int[] {x, y, cnt + 1});
							A[x][y] = true;
						}
						if(map[x][y] == 'D') {
							System.out.println(cnt + 1);
							return;
						}
					}
				}
			}
			cnt++;
		}
	}
}
