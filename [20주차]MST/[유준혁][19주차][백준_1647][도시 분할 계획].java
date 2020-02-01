package baekjoon_MST;
// https://www.acmicpc.net/problem/1647
// 도시 분할 계획
/*
 * 문제
동물원에서 막 탈출한 원숭이 한 마리가 세상구경을 하고 있다. 
그러다가 평화로운 마을에 가게 되었는데, 그곳에서는 알 수 없는 일이 벌어지고 있었다.

마을은 N개의 집과 그 집들을 연결하는 M개의 길로 이루어져 있다. 
길은 어느 방향으로든지 다닐 수 있는 편리한 길이다. 
그리고 각 길마다 길을 유지하는데 드는 유지비가 있다.

마을의 이장은 마을을 두 개의 분리된 마을로 분할할 계획을 가지고 있다. 
마을이 너무 커서 혼자서는 관리할 수 없기 때문이다. 
마을을 분할할 때는 각 분리된 마을 안에 집들이 서로 연결되도록 분할해야 한다. 
각 분리된 마을 안에 있는 임의의 두 집 사이에 경로가 항상 존재해야 한다는 뜻이다. 
마을에는 집이 하나 이상 있어야 한다.

그렇게 마을의 이장은 계획을 세우다가 마을 안에 길이 너무 많다는 생각을 하게 되었다. 
일단 분리된 두 마을 사이에 있는 길들은 필요가 없으므로 없앨 수 있다. 
그리고 각 분리된 마을 안에서도 임의의 두 집 사이에 경로가 항상 존재하게 하면서 길을 더 없앨 수 있다. 
마을의 이장은 위 조건을 만족하도록 길들을 모두 없애고 나머지 길의 유지비의 합을 최소로 하고 싶다. 
이것을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 개수N, 길의 개수M이 주어진다. 
N은 2이상 100,000이하인 정수이고, M은 1이상 1,000,000이하인 정수이다. 
그 다음 줄부터 M줄에 걸쳐 길의 정보가 A B C 세 개의 정수로 주어지는데 A번 집과 B번 집을 연결하는 길의 유지비가 C (1 ≤ C ≤ 1,000)라는 뜻이다.

출력
첫째 줄에 없애고 남은 길 유지비의 합의 최솟값을 출력한다.
 */

/*
 * 문제 풀기 전 생각 2020.02.01 22:47
 * -----------------
 * 흐으으믛음흥므
 * 어떻게 풀어야될까... 컴포넌트 하나를 두개로 분리시키는게 가장 난해할 것 같다. 아직 한 번도 안해봤던거라..
 * 우선은 컴포넌트 안에 연결되어있는 길들을 최소비용의 길들로 연결시키는 게 먼저일까 생각해봐야겠다.
 * 최소비용으로 맞추고 두 개의 컴포넌트로 분리시키는 게 맞겠지..?
 * 아마도 분리시키는 조건은 가장 비싼길을 두 개의 컴포넌트로 분리될 때 까지 없애야겠다는 생각이 든다.
 * 맞을지는 모르겠다.. 별 자신이 없네..
 * 문제에 별 다른 조건이 없으니 입력에는 한 개의 컴포넌트가 완성되어서 들어온다는 가정을 해야겠다. 아마 이렇게 들어올듯?
 * 
 * 문제 풀고 난 후 든 생각 2020.02.01 22:58
 * -----------------
 * 풀기전에는 두 개의 컴포넌트로 분리 될 때 까지 계속해서 가장 비싼길을 없앨 생각이였는데
 * 생각해보니 MST로 하나의 컴포넌트를 완성시킨다면 그 중 하나의 길만 끊어도 두 개의 컴포넌트로 나뉜다는 걸 발견.
 * 그래서 연결시키는 동안 계속해서 더해주다가, 그 중 가장 비싼 길만 끊는 것으로 풀었다.
 */

import java.util.*;
import java.io.*;
public class baekjoon_1647 {
	static int[] uf;
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
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int sum = 0, max = 0;
		uf = new int[n + 1];
		for(int i = 0; i <= n; i++) uf[i] = i;
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>((arr1, arr2) -> {return arr1[2] - arr2[2];});
		for(int i = 0; i < m; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(s-> Integer.parseInt(s)).toArray();
			queue.add(input);
		}
		while(!(allSame() || queue.isEmpty())) {
			int[] edge = queue.poll();
			int a = edge[0], b = edge[1], cost = edge[2];
			if(find(a) != find(b)) {
				union(a, b);
				sum += cost;
				max = Math.max(max, cost);
			}
		}
		System.out.println(sum - max);
	}
}
