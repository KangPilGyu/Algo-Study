package baekjoon_binary_search;
// https://www.acmicpc.net/problem/2343
// ±‚≈∏ ∑πΩº
import java.util.*;
import java.io.*;
public class baekjoon_2343 {
	static int Int(String s) {
		return Integer.parseInt(s);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Int(st.nextToken()), m = Int(st.nextToken()), left = 0, right = 0;
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Int(st.nextToken());
			right += arr[i];
			left = Math.max(left, arr[i]);
		}
		while(left <= right) {
			int mid = (left + right) / 2, sum = 0, cnt = 0;
			for(int i = 0; i < n; i++) {
				if(sum + arr[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += arr[i];
			}
			if(sum != 0) cnt++;
			if(cnt <= m) right = mid - 1;
			else left = mid + 1;
		}
		System.out.println(left);
	}
}
