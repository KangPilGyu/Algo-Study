package binary_search;

import java.util.*;
import java.io.*;

public class _1072 {
	static double x, y;
	static int z;
	
	static long func(){
		long left = 1, right = Integer.MAX_VALUE, mid = 0;
		while (left <= right){
			mid = (left + right) / 2;
			if (z < (int) ((y+mid)*100/(x+mid)))
				right = mid - 1;
			else
				left = mid + 1;
		}
		return mid;
     }

	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
      
		 x = Double.parseDouble(st.nextToken());
		 y = Double.parseDouble(st.nextToken());
		 z = (int) (y*100/x);
      
		 if (z >= 99)
			 System.out.println(-1);
		 else
			 System.out.println(func());  
	  }
}