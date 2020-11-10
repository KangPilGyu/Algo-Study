package binary_search;

import java.util.*;
import java.io.*;

public class _11561 {
	static long func(long n){
		long left = 1, right = Integer.MAX_VALUE;
		while(left <= right){
			long mid = (left + right) / 2;
			// a = 1부터 mid까지의 합
			long a = (mid*(mid+1))/2;
			// b = 1부터 mid + 1 까지의 합
			long b = ((mid+1)*(mid+2))/2;
			// 나올 수 있는 조건은 3가지
			// n이 a 보다 작은 경우
			if (n < a) 
				right = mid - 1;
	          
			// n이 b 보다 같거나 큰 경우
			else if (n >= b) 
				left = mid + 1;
	          
          	// 그 외
			else
				return mid;
   		}
		return left;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			System.out.println(func(x));
		}
	}
}