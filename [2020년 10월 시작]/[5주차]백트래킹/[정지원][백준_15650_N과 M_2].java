package backtracking;

import java.io.*;
import java.util.*;

public class _15650 {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	
	static void func(int cnt, String str, int start) {
		// 종료조건
		if (cnt == m) {
			sb.append(str + "\n");
			return;
		}
		
		for (int i = start; i <= n; i++) 
			func(cnt+1, str+i+" ", i+1);			
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		func(0, "", 1);
		System.out.println(sb);
	}
}