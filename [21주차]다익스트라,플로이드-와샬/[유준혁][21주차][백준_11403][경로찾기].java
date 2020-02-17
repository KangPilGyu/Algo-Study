import java.util.*;
public class baekjoon_11403 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n*n; i++) arr[i/n][i%n] = sc.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(arr[j][i] == 1 && arr[i][k] == 1) arr[j][k] = 1;
				}
			}
		}
		for(int[] a : arr) {
			for(int i : a) sb.append(i + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
