package week14;

import java.util.*;

/*
 * 나누어 떨어지는 숫자 배열
 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환.
 */
public class Programmers_lv1_2 {
	public static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0)
				list.add(arr[i]);
		}
		if (list.size() == 0)
			list.add(-1);
		list.sort(null);
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] rst = solution(new int[] { 1, 2, 5, 6, 8, 7, 12, 16 }, 4);
		for (int r : rst)
			System.out.println(r);
	}
}
