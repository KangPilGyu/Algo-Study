package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
4
1
2
100
1000000*/

public class j11561 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			long n = Long.parseLong(br.readLine());
			
			long left = 1; long right= Integer.MAX_VALUE;
			long mid =0;
			while (left<=right) {
				 mid = (left+right)/2;				
				long a = (mid*(mid+1))/2;
				long b = ((mid+1)*(mid+2))/2;
				
				if (n<a) {
					right = mid-1;
				}else if( n>=b) {
					left = mid +1;
				}else {
					left = mid;
					break;
				}
			}
			
			System.out.println(left);
			
			
		}
		
		
	}
}
