package baekjoon_string;
import java.util.*;
public class baekjoon_2897 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt(), c = sc.nextInt();
		byte[][] arr = new byte[r][];
		for(int i = 0; i < r; i++) arr[i] = sc.next().getBytes();
		int[] rst = new int[5];
		for(int i = 0; i < r - 1; i++) {
			for(int j = 0; j < c - 1; j++) {
				if(arr[i][j] == '#' || arr[i+1][j] == '#' || arr[i][j+1] == '#' || arr[i+1][j+1] == '#') continue;
				int cnt = 0;
				if(arr[i][j] == 'X') cnt++;
				if(arr[i+1][j] == 'X') cnt++;
				if(arr[i][j+1] == 'X') cnt++;
				if(arr[i+1][j+1] == 'X') cnt++;
				rst[cnt]++;
			}
		}
		for(int i : rst)System.out.println(i);
	}
}
