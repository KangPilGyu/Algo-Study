import java.util.*;
class Main{
	static int[][] house;
	static int[][] RC = new int[][]{{-1, 0, 1, 0}, {0, 1, 0, -1}};
	static int cnt = 0;
	static void clear(int r, int c, int d){
		if(house[r][c] == 0) cnt++;
		house[r][c] = -1;
		for(int i = 0; i < 4; i++){
			int D = d - i - 1;
			D += D < 0 ? 4 : 0;
			int R = r + RC[0][D];
			int C = c + RC[1][D];
			if(house[R][C] == 0){
				clear(R, C, D);
				return;
			}
		}
		if(house[r - RC[0][d]][c - RC[1][d]] == 1) return;
		clear(r - RC[0][d], c - RC[1][d], d);
	}
	public static void main(String[] ar){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), r = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
		sc.nextLine();
		house = new int[n][];
		for(int i = 0; i < n; i++) 
			house[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
		clear(r, c, d);
		System.out.println(cnt);
	}
}
