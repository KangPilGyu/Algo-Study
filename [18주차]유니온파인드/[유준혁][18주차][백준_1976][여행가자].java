package baekjoon_unionfind;
import java.util.*;
// https://www.acmicpc.net/problem/1976
// 여행가자
/*
 * 문제
동혁이는 친구들과 함께 여행을 가려고 한다. 한국에는 도시가 N개 있고 임의의 두 도시 사이에 길이 있을 수도, 없을 수도 있다. 
동혁이의 여행 일정이 주어졌을 때, 이 여행 경로가 가능한 것인지 알아보자. 물론 중간에 다른 도시를 경유해서 여행을 할 수도 있다.
예를 들어 도시가 5개 있고, A-B, B-C, A-D, B-D, E-A의 길이 있고, 동혁이의 여행 계획이 E C B C D 라면
E-A-B-C-B-C-B-D라는 여행경로를 통해 목적을 달성할 수 있다.

도시들의 개수와 도시들 간의 연결 여부가 주어져 있고, 동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때(중복 가능) 가능한지 여부를 판별하는 프로그램을 작성하시오.

입력
첫 줄에 도시의 수 N이 주어진다. N은 200이하이다. 둘째 줄에 여행 계획에 속한 도시들의 수 M이 주어진다. 
M은 1000이하이다. 다음 N * N 행렬을 통해 임의의 두 도시가 연결되었는지에 관한 정보가 주어진다. 
1이면 연결된 것이고 0이면 연결이 되지 않은 것이다. A와 B가 연결되었으면 B와 A도 연결되어 있다. 
마지막 줄에는 여행 계획이 주어진다.

출력
첫 줄에 가능하면 YES 불가능하면 NO를 출력한다.
 */

/*
 * 문제 풀기 전 생각
 * ------------
 * 2020.01.16
 * 문제 보조타이틀에도 나와있듯이 그냥 DFS 나 BFS로 풀까 생각했다가 UnionFind로 풀어보기로 했다.
 * 특정 정점끼리 연결되어있는지 확인하기 위해서 UnionFind를 쓰는 것 같다.
 * 그 확인에서 매번 D/BFS를 돌리는 것 보단 연결되어있다는 것을 저장하기 위해 쓰는 게 아닐까싶다.
 * 현재 든 생각은 DFS처럼 배열의 모든 값을 확인하면서 1이라면 Union, 마지막으로 Find 해주면 되겠다는 생각이다.
 * 
 * 문제 풀고 난 후 생각
 * -----------
 * 그냥 생각한대로 푸니 맞았다. 근데 뭔가 좀 아쉬운 느낌?
 * 제일 마지막 입력값들이 서로 연결되어있는지 확인하는 코드가 어쩐지 엉성한 느낌이 든다.
 * union할때도 배열 모든 값을 확인하지 않고도 가능한 방법이 없을지 생각해봐야겠다.
 */
public class baekjoon_1976 {
	static int n, m;
	static int[][] map;
	static int[] uf;
	static void union(int a, int b) {
		uf[a] = uf[b] = Math.min(uf[a], uf[b]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		sc.nextLine();
		map = new int[n][];
		uf = new int[n]; 
		for(int i = 0; i < n; i++) {
			map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
			uf[i] = i;
		}
		for(int i = 0; i < n * n; i++)
			if(map[i/n][i%n] == 1) union(i/n, i%n);
		
		int x = uf[sc.nextInt() - 1];
		for(int i = 1; i < m; i++) {
			if(x != uf[sc.nextInt() - 1]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
