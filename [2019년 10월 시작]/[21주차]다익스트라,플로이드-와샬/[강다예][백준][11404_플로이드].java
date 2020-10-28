import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int INF = 100000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = (i == j) ? 0 : INF;
			}
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[start][end] = Math.min(map[start][end], cost);
		}

		for (int k = 1; k <= n; k++) {// 거쳐가는 노드
			for (int i = 1; i <= n; i++) {// 출발
				for (int j = 1; j <= n; j++) {// 도착
					if (i == j || i==k || j==k) {
						continue;
					}

					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		} // for문

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] >= INF) map[i][j] = 0;
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
