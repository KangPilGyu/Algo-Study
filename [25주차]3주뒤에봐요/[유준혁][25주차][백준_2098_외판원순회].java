import java.util.*;
import java.io.*;
class Main{
	static int check, min = 1 << 30, n, start, arrive, cnt = 0;
	static int[][] map;
	static void dfs(int x, int bit, int sum){
		cnt++;
		if(bit == check){
			min = Math.min(min, sum);
			return;
		}
		for(int i = 0; i < n; i++){
			if(bit != arrive && i == start) continue;
			int and = (1 << i) & bit;
			if(map[x][i] != 0 && and == 0){
				dfs(i, (1 << i) | bit, sum + map[x][i]);
			}
		}
	}
	public static void main(String[] ar) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		check = (1 << n) - 1;
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < n; i++){
			start = i;
			arrive = check ^ (1 << i);
			dfs(i, 0, 0);
		}
		System.out.println(min + ", " + cnt);
	}
}
