package baekjoon_lis;
// https://www.acmicpc.net/problem/11054
// 가장 긴 바이토닉 부분 수열
/*
 * 문제 풀기 전 생각 2020.04.08 21:25
 * -----------------------------
 * 오랜만에 디스크립션도 작성하면서 문제를 풀어보려고 한다.
 * 그 동안 쉬엄쉬엄 실버 문제만 풀었더니 의욕이 떨어지는 것 같아서..
 * 하튼 문제 풀기 전에 드는 생각으로는 LIS LDS 두 개를 만들어서 구해지는 max값을 비교해주면 되지 않을까 하는 생각이다.
 * 입력이 작아서 맞는 풀이일지는 확실하지 않지만.. 해보고 다시 와야징
 * 
 * 문제 풀고 난 후 생각 2020.04.08 21:45
 * -----------------------------
 * 맞긴 맞았는데 뭔가 좀 찜찜..
 * 양방향 LIS 만들어서 푸는게 정석인건지 편법인건지 찾아봐야겠다.
 */
import java.util.*;
public class baekjoon_11054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), max = 0;
		int[] left = new int[n], right = new int[n], LIS = new int[n+1], LDS = new int[n + 1];
		for(int i = 0; i < n; i++) right[n - i - 1] = left[i] = sc.nextInt();
		for(int i = 0; i < n; i++) {
			LIS[i] = 1; LDS[i] = 1;
			for(int j = 0; j < i; j++) {
				if(left[i] > left[j]) LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				if(right[i] > right[j]) LDS[i] = Math.max(LDS[i], LDS[j] + 1);
			}
		}
		for(int i = 0; i < n; i++) max = Math.max(max, LIS[i] + LDS[n - i - 1] - 1);
		System.out.println(max);
	}
}
