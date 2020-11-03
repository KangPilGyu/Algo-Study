package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/*4 2
9 7 9 1

1 7
1 9
7 1
7 9
9 1
9 7
9 9
*/
public class j15663 {
	static int n, m;
	static int[] num;
	static boolean[] vst;
	static Set<String> set;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		vst = new boolean[n];
		set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		func(0, "", 1);
		System.out.print(sb);
	}

	static void func(int cnt, String str, int start) {
		if (cnt == m) {
			if(set.contains(str) == false) sb.append(str + "\n");
			set.add(str);
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (!vst[i]) {
				vst[i] = true;
				func(cnt + 1, str + num[i] + " ", start + 1);
				vst[i] = false;
			}

		}

	}
}
