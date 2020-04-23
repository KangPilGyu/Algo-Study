package baekjoon_binary_search;
// https://www.acmicpc.net/problem/2512
// ¿¹»ê

import java.util.*;
public class baekjoon_2512 {
	static long sum(int[] arr, int limit){
		long result = 0;
        for(int i : arr) result += i > limit ? limit : i;
        return result;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), rst = 0;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
		int m = sc.nextInt();
		long sum = sum(arr, m);
		if(sum <= m) rst = Arrays.stream(arr).max().getAsInt();
		else {
			int answer = 0, left = 1, right = 1 << 30;
			while(left <= right){
				int mid = (left / 2) + (right / 2);
				sum = sum(arr, mid);
				if(sum <= m){
					left = mid + 1;
					answer = Math.max(answer, mid);
				}else right = mid - 1;
	        }
	        rst = answer;
		}
		System.out.println(rst);
	}
}
