package week20;

import java.util.*;

/*
 * 최소 신장 트리 - 프림 알고리즘?
 * 백준_2887_행성 터널
 */
public class Problem_2887_2 {
	public static int minCost(int[] a, int[] b) {
		int minX = Math.abs(a[0] - b[0]);
		int minY = Math.abs(a[1] - b[1]);
		int minZ = Math.abs(a[2] - b[2]);
		int min = Math.min(minX, Math.min(minY, minZ));
		return min;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();  // 행성 갯수
		List<int[]> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() });
		}
		
		Queue<int[]> q = new LinkedList<>();
		boolean[] vst = new boolean[N];
		q.add(list.get(0));
		vst[0] = true;
		
		int[] minCosts = new int[N];
		Arrays.fill(minCosts, 2147483647);

		int currentIdx = 0;
		int sum = 0;
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int nextIdx = 0;
			for(int i=0; i<N; i++) {
				if(vst[i]) continue;  // 나 자신이랑은 비교 ㄴㄴ, 이미 방문한 행성도 비교 ㄴㄴ
				int min = minCost(current, list.get(i));  // 두 행성 연결 최소 비용
				minCosts[currentIdx] = Math.min(min, minCosts[currentIdx]);  // 여러 행성들과 비교 후 최소 비용 저장.
				if(min == minCosts[currentIdx]) nextIdx = i;
			}
			if(vst[nextIdx] == false) {
				q.add(list.get(nextIdx));
				vst[nextIdx] = true;
			}
			if(minCosts[currentIdx] < 2147483647) {
				sum += minCosts[currentIdx];				
			}
			currentIdx = nextIdx;
		}
		System.out.println(sum);
	}
}
