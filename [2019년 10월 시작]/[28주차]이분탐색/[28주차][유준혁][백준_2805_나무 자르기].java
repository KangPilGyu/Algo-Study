package baekjoon_binary_search;
// https://www.acmicpc.net/problem/2805
// ³ª¹« ÀÚ¸£±â
import java.util.*;
import java.io.*;
public class baekjoon_2805 {
	static int Int(String s) {return Integer.parseInt(s);}
	public static void main(String[] ar) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Int(st.nextToken()), m = Int(st.nextToken());
		int[] trees = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) trees[i] = Int(st.nextToken());
		
		int left = 1, right = 1 << 30, max = 0;
		while(left <= right) {
			int mid = (left / 2) + (right / 2);
			long sum = 0;
			for(int i : trees) sum += i > mid ? i - mid : 0;
			if(sum < m) right = mid - 1;
			else {
				max = Math.max(max, mid);
				left = mid + 1;
			}
		}
		System.out.print(max);
	}
}
