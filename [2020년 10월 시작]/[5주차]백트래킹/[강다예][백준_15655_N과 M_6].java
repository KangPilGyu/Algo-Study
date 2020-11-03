package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*4 2
9 8 7 1

1 7
1 8
1 9
7 8
7 9
8 9

*/
public class j15655 {
	static int n, m;
	static int [] num;
	static boolean [] vst;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		vst = new boolean[n];
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		func(0,"",0);
		System.out.println(sb);
		
	}
	 static void func(int cnt, String str,int start) {
		if(cnt==m) {
			sb.append(str+"\n");
			return;
		}
		
		for (int i = start; i < num.length; i++) {
			if (!vst[i]) {
				vst[i]= true;
				func(cnt+1,str+num[i]+" ",i);
				vst[i]= false;
			}
		}
		
	}
}
