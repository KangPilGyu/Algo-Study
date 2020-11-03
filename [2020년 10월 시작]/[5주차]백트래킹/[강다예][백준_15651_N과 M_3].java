package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j15651_1 {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		func(0,"");
		System.out.println(sb);
	}
	 static void func(int cnt, String str) {
		if(cnt==m) {
			sb.append(str+"\n");
			return;
		}
		for (int i = 1; i <=n; i++) {
			func(cnt+1,str+i+" ");
		}
		
	}
}
