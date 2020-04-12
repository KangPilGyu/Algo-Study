package baekjoon_DP;
// https://www.acmicpc.net/problem/1915
// 가장 큰 정사각형
/*
 * 문제 풀기 전 생각 2020.04.12 21:16
 * ----------------------------
 * 조건이 별로 안커서 브루트포스로도 해결 가능한거 아닌가..? 시간초과 나려나
 * 일단 해봄 ㅇㅅㅇ
 * 
 * 문제 풀고 난 후 생각 2020.04.12 22:04
 * ----------------------------
 * 브루트 포스는 귀찮아서 포기하고 DP로 갈아탔는데
 * 테케는 다 잘나오는데 통과가 안돼서 애먹었음.
 * 알고보니 max 기본 값을 1로 설정해두어서, 가장 큰 정사각형의 넓이가 0 일 경우를 체크하지 못한 것.
 * 입력 중 1이 존재할 경우만 max를 1로 설정해두었더니 통과했음..
 */
import java.util.*;
public class baekjoon_1915 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), max = 0;
		int[][] dp = new int[n][m];
		for(int i = 0; i < n; i++) {
			byte[] bytes = sc.next().getBytes();
			for(int j = 0; j < m; j++) {
				dp[i][j] = bytes[j] - '0';
				if(dp[i][j] == 1) max = 1;
			}
		}
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				if(dp[i][j] != 0) {
					dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		for(int[] d : dp) System.out.println(Arrays.toString(d));
		System.out.println(max * max);
	}
}
