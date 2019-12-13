package week13;

import java.util.*;

/*
 * 백준_2667_단지번호붙이기
 * 첫 번째 줄에는 총 단지수를 출력. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력.
 * 
 * 7		지도의 크기
 * 0110100	1은 집이 있는 곳, 0은 없는 곳
 * 0110101
 * 1110101
 * 0000111
 * 0100000
 * 0111110
 * 0111000
 * --------
 * 3
 * 7
 * 8
 * 9
 */
public class Problem_2667 {
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
