package backtracking;
/*
4 2

1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J15649_1 {
	static int n, m;
	static boolean[] vst;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		vst = new boolean[n + 1];
		func(0, "");

	}

	static void func(int cnt, String str) {
		if (m == cnt) { //m
			System.out.println(str);
			return;
		}

		for (int i = 1; i <= n; i++) { //n
			if (!vst[i]) {
				vst[i] = true;
				func(cnt + 1, str + i + " ");
				vst[i] = false;
			}
		}
		
	}
	
}
