package baekjoon_basic;

// https://www.acmicpc.net/problem/4641
// Doubles
import java.util.*;
import java.io.*;
public class baekjoon_4641 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while((st = new StringTokenizer(br.readLine())).countTokens() > 1) {
			int[] arr = new int[st.countTokens() - 1];
			for(int i = 0; i < arr.length; i++) arr[i] = new Integer(st.nextToken());
			int cnt = 0;
			Arrays.sort(arr);
			for(int i = 0; i < arr.length - 1; i++) {
				for(int j = i + 1; j < arr.length; j++) {
					if(arr[i] * 2 == arr[j]) {
						cnt++;
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
