package week8;

import java.util.*;

/*
 * 백준_11399_ATM
 * 
 * ATM은 한 대, 사람은 N명. 사람마다 돈을 뽑는데 걸리는 시간이 다름.
 * 각 사람이 기다리는 시간의 합 중 최솟값 출력.
 * 
 * 5
 * 3 1 4 3 2
 * ----------
 * 32	(1) + (1+2) + (1+2+3) + (1+2+3+3) + (1+2+3+3+4)
 */
public class Problem_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> minutes = new ArrayList<>();;
		for(int i=0; i<N; i++) {
			minutes.add(sc.nextInt());
		}
		
		Collections.sort(minutes);  // 정렬.
		int sum = 0; // 기다리는 시간의 누적 합
		int minTime = 0;  // 누적 합의 누적 합.
		for(int i=0; i<N; i++) {
			sum += minutes.get(i);
			minTime += sum;
		}
		System.out.println(minTime);
	}
}
