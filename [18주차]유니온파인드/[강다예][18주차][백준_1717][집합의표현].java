import java.util.Scanner;

public class Main {
	static int[] arr;
	static int a, b, x;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();

			if (x == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		} // for
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			arr[y] = x;
		}

	}

	static int find(int x) {
		if (x == arr[x]) {
			return x;
		} else {
			return arr[x] = find(arr[x]);
		}
	}

}
