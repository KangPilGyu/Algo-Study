package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class _15651 {
	static int n, m;
	static StringBuilder sb = new StringBuilder();

	static void func(int cnt, String str) {
		// 종료조건
		if (cnt == m) {
			sb.append(str+"\n");
			return;
		}			
		
		for (int i = 1; i <= n; i++)
			func(cnt+1, str+i+" ");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		func(0, "");
		System.out.println(sb);
	}
}