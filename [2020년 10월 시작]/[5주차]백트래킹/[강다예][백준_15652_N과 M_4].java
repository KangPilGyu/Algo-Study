package backtracking;

/*
1 1
1 2
1 3
1 4
2 2
2 3
2 4
3 3
3 4
4 4
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j15652_1 {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	static boolean[] vst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		vst = new boolean[n + 1];
		func(0, "", 1);
		System.out.println(sb);
	}

	static void func(int cnt, String str, int start) {
		if (cnt == m) {
			sb.append(str + "\n");
			return;
		}

		for (int i = start; i <= n; i++) {
			func(cnt + 1, str + i + " ", i);

		}
	}
}
