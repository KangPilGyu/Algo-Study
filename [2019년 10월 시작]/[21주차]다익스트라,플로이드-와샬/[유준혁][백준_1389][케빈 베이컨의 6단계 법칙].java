package baekjoon_floydwarshall;
// https://www.acmicpc.net/problem/1389
// 케빈 베이컨의 6단계 법칙
import java.util.*;
public class baekjoon_1389 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), min = 1 << 30, idx = min;
		int[][] map = new int[n][n];
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
			map[a][b] = map[b][a] = 1;
		}
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(i == j || j == k || i == k) continue;
					if(map[i][k] == 0 || map[k][j] == 0) continue;
					if(map[i][j] == 0) map[i][j] = map[i][k] + map[k][j];
					else map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		for(int i = 0; i < n; i++) {
			int sum = Arrays.stream(map[i]).sum() - map[i][i];
			if(min < sum) {
				min = sum;
				idx = i + 1;
			}
		}
		System.out.println(min);
	}
}
