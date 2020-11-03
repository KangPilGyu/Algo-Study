package backtracking;

import java.io.*;
import java.util.*;

public class _15664 {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	
	static void func(int cnt, String str, int start) {
		// 종료조건
		if (cnt == m) {
			sb.append(str+"\n");
			return;
		}			
		
		for (int i = start; i < n; i++) 		
			func(cnt+1, str+arr[i]+" ", i+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> set = new HashSet<>();
	    ArrayList<String> al = new ArrayList<>();
		
	    n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		func(0, "", 0);
		
		String[] s = sb.toString().split(" \n");
		   
	      for (int i = 0; i < s.length; i++)
	         set.add(s[i]);
	      
	      al.addAll(set);
	      
	      al.sort((a, b)->{
	    	  int rst = 0;
	    	  String[] a1 = a.split(" ");
	    	  String[] b1 = b.split(" ");
	    	  for(int i = 0; i < m; i++) {
	    		  rst = Integer.parseInt(a1[i]) - Integer.parseInt(b1[i]);
	    		  if(rst != 0) break;
	    	  }
	    	  return rst;
	      });
	      
	      for (int i = 0; i < al.size(); i++)
	         System.out.println(al.get(i));	
	}
}