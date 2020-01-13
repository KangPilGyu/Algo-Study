package week17;

import java.util.*;

/*
 * 백준_9237_이장님 초대
 * 묘목 하나를 심는데 걸리는 시간은 1일.
 * 나무를 심는 순서를 신중하게 골라 이장님을 최대한 빨리 초대.
 * 
 * 4
 * 2 3 4 3
 * --------
 * 7
 * 
 * 6
 * 39 38 9 35 39 20
 * -----------------
 * 42
 */
public class Problem_9237 {
	public static void rev(List<Integer> list) {
		list.sort(null);
		Collections.reverse(list);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> times = new ArrayList<>();
		for(int i=0; i<N; i++) {
			times.add(sc.nextInt());
		}
		rev(times);
		List<Integer> days = new ArrayList<>();
		for(int i=1; i<=times.size(); i++) {
			days.add(i + times.get(i-1));
		}
		rev(days);
		System.out.println(days.get(0)+1);
	}
}
