package baekjoon_brute_force;
// https://www.acmicpc.net/problem/1051
// 숫자 정사각형
/*
 * 문제 풀기 전 생각 2020.03.03 21:07
 * 브루트 포스 문제
 */
import java.util.*;
import java.io.*;
public class baekjoon_1051 {
	static int Int(String s) {return new Integer(s);}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Int(st.nextToken()), m = Int(st.nextToken());
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0; j < m; j++) map[i][j] = Int(input[j]);
		}
		int max = 1;
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < m - 1; j++) {
				for(int k = 1; k > 0; k++) {
					int x = i + k, y = j + k;
					if(x >= n || y >= m) break;
					if(map[i][j] == map[i][y] && map[x][j] == map[x][y] && map[i][j] == map[x][y]) {
						max = Math.max(max, (k + 1) * (k + 1));
					}
				}
			}
		}
		System.out.println(max);
	}
}
