package baekjoon_DP;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_1520 {
	static int [][] arr = new int [500][500];
	static int [][] map = new int [500][500];
	public static int solution(int [][] map, int x, int y, int i, int j) {
		if(x == 0 && y == 0) return 1;
		if(arr[x][y] == -1) {
			arr[x][y] = 0;
			if (x+1 <= i && map[x][y] < map[x + 1][y])
				arr[x][y] += solution(map, x + 1, y, i, j);
			if (y+1 <= j && map[x][y] < map[x][y + 1])
				arr[x][y] += solution(map, x, y + 1, i, j);
			if (x-1 > -1 && map[x][y] < map[x - 1][y]) 
				arr[x][y] += solution(map, x - 1, y, i, j);
			if (y-1 > -1 && map[x][y] < map[x][y - 1]) 
				arr[x][y] += solution(map, x, y - 1, i, j);
		}
		return arr[x][y];
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
				arr[i][j] = -1;
			}
		}
		System.out.println(solution(map, n-1, m-1, n-1, m-1));
	}
	
	/*
	 * 첫번째 시도. 시간초과가 뜸.
	 * static int cnt = 0;
	public static void solution(int [][] map, int x, int y, int i, int j) {
		if(x == i && y == j) cnt++;
		
		try{
			if(map[x][y] > map[x+1][y]) 
				solution(map, x+1, y, i, j);
		}catch(Exception e){}
		try{
			if(map[x][y] > map[x][y+1]) solution(map, x, y+1, i, j);
		}catch(Exception e){}
		try{
			if(map[x][y] > map[x-1][y]) solution(map, x-1, y, i, j);
		}catch(Exception e){}
		try{
			if(map[x][y] > map[x][y-1]) solution(map, x, y-1, i, j);
		}catch(Exception e){}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][] map = new int [sc.nextInt()][sc.nextInt()];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int x=0, y=0;
		solution(map, x, y, map.length-1, map[0].length-1);
		System.out.println(cnt);
	}
	 */
}
