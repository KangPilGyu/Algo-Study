package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class P7576 {

    static int N;
    static int M;
    static Queue<Integer> queue = new LinkedList<>();
    static int[][] box;
    static int[][] visitBox;
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};
    static int day = 0;
    static int cnt = 0;

    static void bfs() {
        int cnt1 = 0;
        while (!queue.isEmpty()) {
            if(queue.peek() == -1) {
                queue.poll();
                if(queue.size() == 0){
                    continue;
                }
                day++;
                queue.add(-1);
            }
            int x1 = queue.poll();
            int y1 = queue.poll();
            for (int i = 0; i < x.length; i++) {
                int x2 = x1 + x[i];
                int y2 = y1 + y[i];
                if (x2<0 || y2<0 || x2>N-1 || y2>M-1 || box[x2][y2] == -1) {
                    continue;
                } else if (box[x2][y2] == 0 && visitBox[x2][y2] == 0) {
                    box[x2][y2] = 1;
                    visitBox[x2][y2] = 1;
                    queue.add(x2);
                    queue.add(y2);
                    cnt1++;
                }                
            }
        }
        if(cnt != cnt1) {
            day = -1;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            box = new int[N][M];
            visitBox = new int[N][M];
    
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[i][j] = Integer.parseInt(st.nextToken());
                    if (box[i][j] == 1) {
                        visitBox[i][j] = 1;
                        queue.add(i);
                        queue.add(j);
                    } else if(box[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            queue.add(-1);
            bfs();
            System.out.println(day);
            br.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
}
/* 
방법2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static int N, M;
	static int[][] box;
	static boolean[][] visited;
	static Queue<Point> q = new LinkedList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int count = -1;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		box = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					q.add(new Point(i, j));
				}
			}
		}
		/*
		 * for (int i = 0; i < M; i++) { for (int j = 0; j < N; j++) { if (box[i][j] ==
		 * 1 && !visited[i][j]) { visited[i][j] = true; bfs(i, j); } } }
		 */
/*		bfs(0, 0);

		boolean chk = false;
		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++) {
				if(box[x][y]==0) {
					chk=true;
				}

			}
		}
		
		if(!chk) {
			System.out.println(count);
		}else {
			System.out.println("-1");
		}
		
	}// main

	// bfs
	private static void bfs(int i, int j) {
		// Point p = new Point(i, j);
		// Queue<Point> q = new LinkedList<>();

		// q.add(new Point(i, j));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				for (int n = 0; n < 4; n++) {

					int nx = x + dx[n];
					int ny = y + dy[n];

					if (nx < 0 || nx >= M || ny < 0 || ny >= N)
						continue;

					if (box[nx][ny] == 0 && !visited[nx][ny]) {
						box[nx][ny] = 1;
						visited[nx][ny] = true;
						q.add(new Point(nx, ny));
					}

				}
			}
//			print();
//			System.out.println(q.size());

			count++;
		}

	}// bfs

	private static void print() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(box[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}// class
 */