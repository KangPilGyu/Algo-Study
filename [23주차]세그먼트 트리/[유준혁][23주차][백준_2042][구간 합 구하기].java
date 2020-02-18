import java.util.*;
import java.io.*;
class Main{
	static BufferedReader br;
	static BufferedWriter bw;
	static long[] seg;
	static int n, m, level, len, a, b;
	static int level(int a){
		if(a == 0) return 1;
		return 1 + level(a / 2);
	}
	public static void main(String[] ar) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		level = level(n);
		len = 1 << level;
		seg = new long[len + 1];
		int cnt = 0;
		for(int i = (1 << (level - 1)); cnt < n; cnt++, i++){
			seg[i] = Long.parseLong(br.readLine());
		}
		init();
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1){
				update((1 << (level - 1)) + b - 1, c);
			}else{
				bw.write((sum(b, (int)c, 1, 1, len / 2)) + "\n");
			}
		}
		bw.flush();
	}
	
	static void init(){
		int i = ((len + 1) / 4);
		while(i > 0){
			for(int x = i; x < i * 2; x++){
				seg[x] = seg[x * 2] + seg[x * 2 + 1];
			}
			i /= 2;
		}
	}
	
	static void update(int b, long c) {
		long cha = c - seg[b];
		seg[b] = c;
		while(b > 0){
			b /= 2;
			seg[b] += cha;
		}
	}
	
	static long sum(int b, int c, int idx, int s, int e){
		int half = (s + e) / 2;
        long sum = 0;
		if(b <= s && e <= c) return seg[idx];
		else if(b <= half){
            sum = sum(b, c, idx * 2, s, half);
			if(c > half) sum += sum(b, c, idx * 2 + 1, half + 1, e);
		}else if(half <= b){
            sum = sum(b, c, idx * 2 + 1, half + 1, e);
			if(half > c) sum += sum(b, c, idx * 2, s, half);
		}
		return sum;
	}
}
