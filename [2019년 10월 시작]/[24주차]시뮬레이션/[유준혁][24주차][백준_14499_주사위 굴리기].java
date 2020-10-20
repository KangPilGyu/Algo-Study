import java.util.*;
class Main{
	static int n, m, x, y, k;
	static int[][] map;
	static int[][] D = new int[][]{{1, -1, 0, 0}, {0, 0, -1, 1}};
	static int[] dice = new int[6];
	public static void main(String[] ar){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		k = sc.nextInt();
		
		map = new int[n][m];
		for(int i = 0; i < n * m; i++) map[i / m][i % m] = sc.nextInt();
		for(int i = 0; i < k; i++) rollDice(sc.nextInt() - 1);
	}
	static void rollDice(int d){
		int X = x + D[1][d];
		int Y = y + D[0][d];
		if(0 <= X && 0 <= Y && X < n && Y < m){
			x = X;
			y = Y;
			spinDice(d);
			if(map[X][Y] == 0) map[X][Y] = dice[5];
			else{
				dice[5] = map[X][Y];
				map[X][Y] = 0;
			}
			System.out.println(dice[0]);
		}
	}
	static void spinDice(int w){
		if(w == 0){
			int a = dice[0], b = dice[2], c = dice[3], d = dice[5];
			dice[0] = c;
			dice[2] = a;
			dice[3] = d;
			dice[5] = b;
		}
		if(w == 1){
			int a = dice[0], b = dice[2], c = dice[3], d = dice[5];
			dice[0] = b;
			dice[2] = d;
			dice[3] = a;
			dice[5] = c;
		}
		if(w == 2){
			int a = dice[0], b = dice[1], c = dice[4], d = dice[5];
			dice[0] = c;
			dice[1] = a;
			dice[4] = d;
			dice[5] = b;
		}
		if(w == 3){
			int a = dice[0], b = dice[1], c = dice[4], d = dice[5];
			dice[0] = b;
			dice[1] = d;
			dice[4] = a;
			dice[5] = c;
		}
	}
}
