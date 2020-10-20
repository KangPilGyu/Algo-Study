package week8;

import java.util.*;

/*
 * 백준_2217_로프
 * 
 * 로프당 들 수 있는 물체의 최대 중량이 주어질 때 들 수 있는 물체의 최대 중량 출력.
 * 모든 로프를 사용할 필요는 없음.
 * 
 * 2	N : 로프의 갯수
 * 10	로프당 들 수 있는 물체의 최대 중량
 * 15
 * ---
 * 20	로프들을 사용하여 들 수 있는 물체의 최대 중량
 * 
 * 6
 * 15
 * 5
 * 20
 * 35
 * 40
 * 45
 * ---
 * 5*6	30
 * 15*5 75
 * 20*4 80
 * 35*3 105
 * 40*2 80
 * 45*1 45
 */
public class Problem_2217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> ropes = new ArrayList<>();
		for(int i=0; i<N; i++) {
			ropes.add(sc.nextInt());
		}
		
		Collections.sort(ropes);  // 정렬..
		int max = 0;
		for(int i=0; i<ropes.size(); i++) {
			max = Math.max(max, ropes.get(i)*N);  // 가장 작은 물체를 들 수 있는 로프를 사용하면 그 중량만큼 모두 1/N해서 들게 됨.. 작은 걸 하나씩 빼가면서...그래요..
			N--;
		}
		System.out.println(max);
		
	}
}
