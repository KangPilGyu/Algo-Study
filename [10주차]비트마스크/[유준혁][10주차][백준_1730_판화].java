package baekjoon_bitmask;
import java.io.*;
public class baekjoon_1730 {
	static int[][] rst;
	static int[][] wh = new int [][] {{0,1,0,-1}, {1,0,-1,0}};
	static char[] ascii = new char[] {46, 124, 45, 43};
	static boolean isRange(int i, int j) {
		return (0 <= i && i < rst.length) && (0 <= j && j <rst.length);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = new Integer(br.readLine());
		rst = new int [n][n];
		String command = br.readLine();
		int i = 0, j = 0;
		for(byte b : command.getBytes()) {
			int iplus = 0, jplus = 0, shift = 0;
			switch(b) {
			case 'R' : iplus = wh[0][0]; jplus = wh[1][0]; shift++; break;
			case 'D' : iplus = wh[0][1]; jplus = wh[1][1]; break;
			case 'L' : iplus = wh[0][2]; jplus = wh[1][2]; shift++; break;
			case 'U' : iplus = wh[0][3]; jplus = wh[1][3]; break;
			}
			int ip = i + iplus, jp = j + jplus;
			if(isRange(ip, jp)) {
				rst[i][j] = rst[i][j] | (1 << shift);
				rst[ip][jp] = rst[ip][jp] | (1 << shift);
				i = ip; j = jp;
			}
		}
		
		for(int [] arr : rst) {
			for(int a : arr) {
				System.out.print(ascii[a]);
			}
			System.out.println();
		}
	}
}
