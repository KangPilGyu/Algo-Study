package baekjoon_DFS_BFS;
// https://www.acmicpc.net/submit/10429/18342681
// QUENTO
import java.util.*;
public class baekjoon_10429 {
	static boolean flag = false;
	static int m, n;
	static int[][] WH = new int[][] {{1, 0, -1, 0}, {0, 1, 0, -1}};
	static char[][] arr = new char[3][];
	static boolean[][] vst = new boolean[3][3];
	static Deque<int[]> q = new LinkedList<>();
	static void dfs(int x, int y, String expre, int cnt) {
		if(flag) return;
		if(cnt == m) {
			byte[] bt = expre.getBytes();
			int sum = bt[0] - '0';
			for(int k = 1; k < m; k += 2)
				sum += (bt[k+1] - '0') * (bt[k] == '+' ? 1 : -1);
			if(sum == n) find();
			return;
		}
		if(flag) return;
		for(int i = 0; i < 4; i++) {
			int X = x + WH[0][i];
			int Y = y + WH[1][i];
			if(0 <= X && 0 <= Y && X < 3 && Y < 3 && !vst[X][Y]) {
				vst[X][Y] = true;
				q.addLast(new int[] {X, Y});
				dfs(X, Y, expre + arr[X][Y], cnt + 1);
				vst[X][Y] = false;
				q.pollLast();
			}
		}
	}
	static void find() {
		flag = true;
		System.out.println(1);
		while(!q.isEmpty()) {
			int[] poll = q.pollFirst();
			System.out.println(poll[0] + " " + poll[1]);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = (sc.nextInt() - 1) * 2;
		for(int i = 0; i < 3; i++) arr[i] = sc.next().toCharArray();
		for(int i = 0; i < 9; i += 2) {
			int x = i/3, y = i%3;
			vst[x][y] = true;
			q.addLast(new int[] {i/3, i%3});
			dfs(x, y, "" + arr[x][y], 0);
			vst[x][y] = false;
			q.pollLast();
		}
		if(!flag) System.out.println(0);
	}
}
