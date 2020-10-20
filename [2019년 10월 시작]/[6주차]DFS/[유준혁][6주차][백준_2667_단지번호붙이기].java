package baekjoon_DFS_BFS;
import java.util.*;
public class baekjoon_2667 {
	static int [][]map;
	static int cnt;
	static int [] W = new int [] {1, 0, -1, 0};
	static int [] H = new int [] {0, 1, 0, -1};
	
	public static void checksize(int i, int j) {
		map[i][j] = 0;
		cnt++;
		for(int k=0; k<4; k++) {
			int ii=i+W[k], jj=j+H[k];
			if(0 <= ii && ii < map.length && 0 <= jj && jj < map.length) {
				if(map[ii][jj] == 1) checksize(ii, jj);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int [n][n];
		for(int i=0; i<n; i++) {
			byte [] arr = sc.next().getBytes();
			for(int j=0; j<n; j++) map[i][j] = arr[j]-'0';
		}
		int allcnt=0;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					allcnt++;
					cnt=0;
					checksize(i, j);
					list.add(cnt);
				}
			}
		}
		System.out.println(allcnt);
		list.sort(null);
		for(int i : list)System.out.println(i);
	}
}
