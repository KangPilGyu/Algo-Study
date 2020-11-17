package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2

*/
public class j2583 {
	static int n, m, k;
	static int[][] map;
	static int wh[][] = { { -1, 0, 1, 0 }, { 0, 1, 0, -1 } };
	static int cnt , area = 0 ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int x1, x2, y1, y2 = 0;
		int i1, j1, i2, j2 = 0;
		map = new int[n][m];

		for (int a = 0; a < k; a++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			i1 = y1;
			j1 = x1; // 색칠 시작 좌표

			// 색칠 마지막 좌표
			i2 = i1 + (y2 - y1) - 1;
			j2 = j1 + (x2 - x1) - 1;

			// 원래의 좌표로 변경 (왜냐면 나는 바닥을 기준으로 (0,0)으로 계산했기때문에... 찐 (0,0)으로 바꿔줌..ㅋ 먼말인지 아시겠어요?ㅋ
			i1 = Math.abs(i1 - 4);
			i2 = Math.abs(i2 - 4);

			for (int i = i2; i <= i1; i++) {
				for (int j = j1; j <= j2; j++) {
					map[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (map[i][0] == 0) {
				dfs(i, 0);
			}
		}

	}

	static void dfs(int x, int y) {
		if (  x == n-1 ) {
			
		}
		for (int i = 0; i < 4; i++) {
			int newx = x+wh[0][i];
			int newy = y+wh[1][i];
			
			if (newx >0 && newy >0 && newx <=n && newy <=m) {
				if (map[newx][newy] == 0) {
					area = area+1;
					dfs(newx,newy);
				}
			}
		}
	}
}
