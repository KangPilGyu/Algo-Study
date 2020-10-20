package d0217_SegmentTree_P2357;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 0;
	static final int MIN = 1;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] data = new int[N+1];
			for (int i = 1; i <= N; i++) {
				data[i] = Integer.parseInt(br.readLine());
			}
			
			int m = 1;
			for (int i = 0; i <= 17; i++) {
				if(N <= m) break;
				else m *= 2;
			}
			
			int[][] tree = new int[m*2][2];
			
			tree[1] = init(data, tree, 1, 1, N);
			
			int[][] input = new int[M][2];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < M; i++) {
				int[] findData = find(tree, 1, 1, N, input[i][0], input[i][1]);
				System.out.println(findData[MIN] + " " + findData[MAX]);
			}
			
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static int[] init(int[] data, int[][] tree, int node, int start, int end) {
		if(start == end) {
			tree[node][MAX] = tree[node][MIN] = data[start];
			
			return tree[node];
		}
		
		int[] left = init(data, tree, node*2, start, (start+end)/2);
		int[] right = init(data, tree, node*2 + 1, (start+end)/2 + 1, end);
		tree[node][MAX] = Math.max(left[MAX], right[MAX]);
		tree[node][MIN] = Math.min(left[MIN], right[MIN]);
		
		return tree[node];
	}
	
	static int[] find(int[][] tree, int node, int start, int end, int left, int right) {
		if(left <= start && end <= right) {
			return tree[node];
		}else if (right <= (start+end)/2) {
			return find(tree, node*2, start, (start+end)/2, left, right);
		}else if((start+end)/2 < left) {
			return find(tree, node*2 + 1, (start+end)/2 + 1, end, left, right);
		}else {
			int[] leftChild = find(tree, node*2, start, (start+end)/2, left, right);
			int[] rightChild = find(tree, node*2 + 1, (start+end)/2 + 1, end, left, right);
			int[] ret = new int[2];
			ret[MAX] = Math.max(leftChild[MAX], rightChild[MAX]);
			ret[MIN] = Math.min(leftChild[MIN], rightChild[MIN]);
			return ret;
		}
	}

}
