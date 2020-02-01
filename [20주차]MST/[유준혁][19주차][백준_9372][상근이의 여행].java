package baekjoon_MST;
// https://www.acmicpc.net/problem/9372
// 상근이의 여행
/*
 * 문제
상근이는 겨울방학을 맞아 N개국을 여행하면서 자아를 찾기로 마음먹었다. 

하지만 상근이는 새로운 비행기를 무서워하기 때문에, 최대한 적은 종류의 비행기를 타고 국가들을 이동하려고 한다.

이번 방학 동안의 비행 스케줄이 주어졌을 때, 상근이가 가장 적은 종류의 비행기를 타고 모든 도시들을 여행할 수 있도록 도와주자.

상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.

입력
첫 번째 줄에는 테스트 케이스의 수 T(T ≤ 100)가 주어지고,

각 테스트 케이스마다 다음과 같은 정보가 주어진다.

첫 번째 줄에는 국가의 수 N(2 ≤ N ≤ 1 000)과 비행기의 종류 M(1 ≤ M ≤ 10 000) 가 주어진다.
이후 M개의 줄에 a와 b 쌍들이 입력된다. a와 b를 왕복하는 비행기가 있다는 것을 의미한다. (1 ≤ a, b ≤ n; a ≠ b) 
주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.
출력
테스트 케이스마다 한 줄을 출력한다.

상근이가 모든 도시를 여행하기 위해 타야 하는 비행기 종류의 최소 개수를 출력한다.
 */

/*
 * 문제 풀기 전 생각 2020.01.28 21:55
 * ----------------
 * 문제를 봤을 땐 MST 보다 BFS가 먼저 떠올랐다.
 * 입력 받는 대로 트리를 구현해두고 BFS 돌리다가 모든 점들을 연결했을때를 기점으로 중단하고 카운트를 출력하면 되는 거 아닌가..?
 * 이 문제가 왜 MST이지... 비용이 없는데 MST를 왜 돌려...? 
 * 
 * 문제 풀고 난 후 생각 2020.01.28 22:03
 * ----------------
 * 생각보다 더 어처구니가 없는 문제였다.
 * 어차피 연결됨을 보증한다면 간선의 갯수는 정점 - 1이 자명하니까 노드의 갯수 - 1 을 출력했더니 맞았다.
 * 차라리 티켓값도 주어지고, 일정 이하 금액으로만 모든 정점을 방문하는 루트를 출력하라 했으면 재밌었을텐데.. 아쉽
 * 
 * ps.
 * 근데 빡머가리라서 한 번 틀림 엌ㅋㅋㅋ k만큼 다음 줄 읽어야 되는데 m만큼 읽음
 */
import java.io.*;
public class baekjoon_9372 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int m = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
			bw.write((m - 1) + "\n");
			for(int j = 0; j < k; j++) br.readLine();
		}
		bw.flush();
	}
}
