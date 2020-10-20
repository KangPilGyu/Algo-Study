package d0217_SegmentTree_P6549_UsingStack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = null;
			
			List<Long> resultList = new ArrayList<Long>();
			
			while(true) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				
				if(n == 0) 
					break;
				
				int[] histogram = new int[n];
				for (int i = 0; i < n; i++) {
					histogram[i] = Integer.parseInt(st.nextToken());
				}
				
				long max = 0;
				
				Stack<Integer> stack = new Stack<Integer>();
				for (int i = 0; i < n; i++) {
					while(!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) {
						int right = i - 1;
						int height = histogram[stack.pop()];
						int left = stack.isEmpty() ? 0 : stack.peek() + 1;
						long size = (long)(right - left + 1) * (long)height;
						
						if(max < size) max = size;
					}
					
					stack.add(i);
				}
				
				while(!stack.isEmpty()) {
					int right = n - 1;
					int height = histogram[stack.pop()];
					int left = stack.isEmpty() ? 0 : stack.peek() + 1;
					long size = (long)(right - left + 1) * (long)height;
					
					if(max < size) max = size;
				}
				
				resultList.add(max);				
			}
			
			for (Long result : resultList) {
				System.out.println(result);
			}
			
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
