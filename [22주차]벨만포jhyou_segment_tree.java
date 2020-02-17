import java.util.*;
import java.io.*;
class Main{
	static long[] seg;
	static int n, m, level, len, a, b;
	static int level(int a){
		if(a == 0) return 1;
		return 1 + level(a / 2);
	}
	public static void main(String[] ar) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		level = level(n);
		len = 1 << level;
		seg = new long[len + 1];
		int cnt = 0;
		for(int i = (1 << (level - 1)) + 1; cnt < n; cnt++, i++){
			seg[i] = Long.parseLong(br.readLine());
		}
		init();
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1){
				update(b, c);
			}else{
				System.out.println(sum(b, (int)c, 1, 1, len / 2));
			}
		}
		
	}
	
	static void init(){
		int i = (seg.length / 2);
		while(i > 0){
			for(int x = i; x < i * 2; x++){
				seg[x] = seg[x * 2] + seg[x * 2 + 1];
			}
			i /= 2;
		}
	}
	
	static void update(int b, long c){
		seg[b] = c;
		while(b > 0){
			b /= 2;
			seg[b] += c;
		}
	}
	
	static long sum(int b, int c, int idx, int s, int e){
		int half = (s + e) / 2;
		if(b <= s && e <= c) return seg[idx];
		else if(b <= half){
			if(c <= half){
				return sum(b, c, idx * 2, s, half);
			}else{
				return sum(b, c, idx * 2, s, half) + sum(b, c, idx * 2 + 1, half + 1, e);
			}
		}else if(half <= b){
			if(half <= c){
				return sum(b, c, idx * 2 + 1, half + 1, e);
			}else{
				return sum(b, c, idx * 2 + 1, half + 1, e) + sum(b, c, idx * 2, s, half);
			}
		}
		return 0;
	}
}
