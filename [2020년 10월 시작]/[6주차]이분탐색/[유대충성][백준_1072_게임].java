package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
100 80
6
*/

public class j1072 {
	static long x;
	static long y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());
		long z = (y*100)/x;
		
		
		if (z>=99) {
			System.out.println(-1);
		}else {
			long left = 1; long right = Integer.MAX_VALUE;	
			long rst = 0;
			
			while (left<=right) {
				long mid = (left+right)/2;	
				long newx = x+mid;
				long newy = y+mid;
				
				long newz = (newy*100)/newx;
				
				if (z<newz) {
					right = mid-1;
					rst = mid;
				}else {
					left = mid +1;
				}			
			}
			
			System.out.println(rst);
			
			
			
			
		}

	}
}
