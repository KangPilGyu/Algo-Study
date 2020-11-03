package backtracking;

import java.io.*;
import java.util.*;

public class _15666 {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static Set<String> set = new HashSet<>();

	static void func(int cnt, String str, int start) {
		// 종료조건
		if (cnt == m) {
			if (set.contains(str) == false)
				sb.append(str.trim()+"\n");
			set.add(str);
			return;
		}			
		
		for (int i = start; i < n; i++) 		
			func(cnt+1, str+arr[i]+" ", i);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		func(0, "", 0);
		
		System.out.print(sb);
	}
}