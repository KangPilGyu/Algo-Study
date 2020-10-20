import java.util.*;

public class Main {
	static char[][] star;

	static void func(int xs, int xe, int ys, int ye) {
		int m = (xe - xs) / 3;
		for (int i = xs + m; i < xe - m; i++) {
			for (int j = ys + m; j < ye - m; j++) {
				star[i][j] = ' ';
			}
		}
		if (m > 1) {
			func(xs, xs + m, ys, ys + m);
			func(xs + m, xe - m, ys, ys + m);
			func(xe - m, xe, ys, ys + m);

			func(xs, xs + m, ys + m, ye - m);
			func(xs + m, xe - m, ys + m, ye - m);
			func(xe - m, xe, ys + m, ye - m);

			func(xs, xs + m, ye - m, ye);
			func(xs + m, xe - m, ye - m, ye);
			func(xe - m, xe, ye - m, ye);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		star = new char[n][n];
		for(char[] arr : star) Arrays.fill(arr, '*');
		func(0, n, 0, n);
		
		StringBuffer sb = new StringBuffer();
		for(char[] arr : star) {
			for (char c : arr)
				sb.append(c);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}