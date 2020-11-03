package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*4 2

1 2
1 3
1 4
2 3
2 4
3 4
 * */

public class j15650_1 {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		func(0, "",1);

	}

	static void func(int cnt, String str,int start) {
		if(cnt==m) {
			System.out.println(str);
			return;
		}
		for (int i = start; i <=n; i++) {
			
			func(cnt+1,str+i+" ", i + 1);
			
		}

	}
}
