package baekjoon_binary_search;
// https://www.acmicpc.net/problem/3079
// 입국심사
import java.util.*;
public class baekjoon_3079 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) arr[i] = sc.nextLong();
		long left = 1, right = 1000000000l * 1000000000l, answer = right;
        while(left <= right){
            long mid = (left + right) / 2, cnt = 0;
            for(long i : arr) cnt += mid / i;
            if(cnt < m) left = mid + 1;
            else {
            	answer = Math.min(answer, mid);
            	right = mid - 1;
            }
        }
		System.out.println(answer);
	}
}
