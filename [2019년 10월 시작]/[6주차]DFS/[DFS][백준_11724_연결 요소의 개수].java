package baekjoon_DFS_BFS;
import java.util.*;
// https://www.acmicpc.net/problem/11724
// 연결 요소의 개수
public class baekjoon_11724 {
	static int[][] arr;
	static int[] vst;
	static void dfs(int x) {
		vst[x] = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[x][i] == 1 && vst[i] == 0) {
				arr[x][i] = 0;
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() + 1, m = sc.nextInt(), cnt = 0;
		arr = new int[n][n];
		vst = new int[n];
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		for(int i = 1; i < n; i++) {
			if(vst[i] == 0) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
