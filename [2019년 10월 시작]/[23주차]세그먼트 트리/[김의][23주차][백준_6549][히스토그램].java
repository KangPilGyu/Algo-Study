package d0217_SegmentTree_P6549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main{
	
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
				
				int[] histogram = new int[n+1];
				for (int i = 1; i <= n; i++) {
					histogram[i] = Integer.parseInt(st.nextToken());
				}
				
				int m = 1;
				while(true) {
					if(n <= m) {
						break;
					}
					
					m *= 2;
				}
				
				int[] tree = new int[m*2];
				
				init(histogram, tree, 1, 1, n);
				
				long max = maxArea(histogram, tree, 1, n, 1, n);
				
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
	
	static int init(int[] histogram, int[] tree, int node, int start, int end) {
		if(start == end) {
			return tree[node] = start;
		}
		
		int leftChild = init(histogram, tree, node*2, start, (start+end)/2);
		int rightChild = init(histogram, tree, node*2 + 1, (start+end)/2 + 1, end);
		
		return tree[node] = histogram[leftChild] < histogram[rightChild] ? leftChild : rightChild;
	}
	
	static int min(int[] histogram, int[] tree, int node, int start, int end, int left, int right) {
		if(left <= start && end <= right) {
			return tree[node];
		}else if(right <= (start+end)/2) {
			return min(histogram, tree, node*2, start, (start+end)/2, left, right);
		}else if((start+end)/2 < left) {
			return min(histogram, tree, node*2 + 1, (start+end)/2 + 1, end, left, right);
		}else {
			int leftChild = min(histogram, tree, node*2, start, (start+end)/2, left, right);
			int rightChild = min(histogram, tree, node*2 + 1, (start+end)/2 + 1, end, left, right);
			
			return histogram[leftChild] < histogram[rightChild] ? leftChild : rightChild;
		}
	}
	
	static long maxArea(int[] histogram, int[] tree, int start, int end, int left, int right) {
		if(left > right) {
			return 0;
		}
		
		if(left == right) {
			return (long)histogram[left];
		}
		
		int minIndex = min(histogram, tree, 1, start, end, left, right);
		
		long max = (long)(right - left + 1) * (long)histogram[minIndex];
		long leftMaxArea = maxArea(histogram, tree, start, end, left, minIndex - 1);
		long rightMaxArea = maxArea(histogram, tree, start, end, minIndex + 1, right);
		
		if(leftMaxArea > max) max = leftMaxArea;
		if(rightMaxArea > max) max = rightMaxArea;
		
		return max;
	}
	
	
}

