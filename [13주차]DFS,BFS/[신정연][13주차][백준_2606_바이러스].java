package week13;

import java.util.*;

/*
 * 백준_2606_바이러스
 * 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력.
 * 
 * 7	전체 컴퓨터 수.
 * 6	네트워크 상에서 직접 연결되어 있는 쌍의 수.
 * 1 2
 * 2 3
 * 1 5
 * 5 2
 * 5 6
 * 4 7
 * ----
 * 4
 */
public class Problem_2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int com = sc.nextInt();
		int net = sc.nextInt();
		int[][] network = new int[net][2];
		
		for(int i=0; i<net; i++) {
			network[i][0] = sc.nextInt();
			network[i][1] = sc.nextInt();
		}
		
		Queue<Integer> next = new LinkedList<>();
		next.add(1);
		boolean[] vst = new boolean[com+1];
		int cnt = 0;
//		List<Integer> vst = new ArrayList<>();
		
		while(!next.isEmpty()) {
			int current = next.poll();
			if(!vst[current]) {
				vst[current] = true;
				cnt++;
			}
			for(int i=0; i<net; i++) {
				if(network[i][0] == current || network[i][1] == current) {
					if(!vst[network[i][1]]) {
						next.add(network[i][1]);
					} else if(!vst[network[i][0]]) {
						next.add(network[i][0]);
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
