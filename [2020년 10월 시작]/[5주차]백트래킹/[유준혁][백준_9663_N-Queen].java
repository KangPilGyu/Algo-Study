
import java.util.*;
public class Main {
	static int n, cnt = 0;
	static int[][] arr;
	static void func(int m) {
		if(n == m) cnt++;
		else {
			for(int i = 0; i < n; i++) {
				if(check(m, i)) {
					arr[m][i] = 1;
					func(m + 1);
					arr[m][i] = 0;
				}
			}
		}
	}
	static boolean check(int a, int b) {
		for(int i = a, j = 0; i >= 0; i--, j++) {
			if(arr[i][b] == 1) return false;
			if(b + j < n && arr[i][b+j] == 1) return false;
			if(b - j >= 0 && arr[i][b-j] == 1) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		func(0);
		System.out.println(cnt);
	}
}
