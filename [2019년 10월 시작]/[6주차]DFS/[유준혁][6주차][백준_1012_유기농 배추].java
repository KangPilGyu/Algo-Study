package baekjoon_DFS_BFS;
import java.util.*;
public class baekjoon_1012 {
	static int[] W = new int [] {1, 0, -1, 0};
	static int[] H = new int [] {0, 1, 0, -1};
	public static int[][] find(int[][] farm, int i, int j){
		Queue<int[]> que = new LinkedList<>();
		farm[i][j] = 0;
		que.add(new int[] {i, j});
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			for(int k=0; k<4; k++) {
				int ii = tmp[0] + W[k];
				int jj = tmp[1] + H[k];
				if(0 <= ii && ii < farm.length && 0 <= jj && jj < farm[0].length) {
					if(farm[ii][jj] == 1) {
						que.add(new int [] {ii, jj});
						farm[ii][jj] = 0;
					}					
				}
			}
		}
		return farm;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int cnt = 0;
			int [][] farm = new int [n][m];
			while(k-->0) farm[sc.nextInt()][sc.nextInt()] = 1;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(farm[i][j] == 1) {
						cnt++;
						farm = find(farm, i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
