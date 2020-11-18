package baekjoon_binary_search;
// https://www.acmicpc.net/problem/1072
// 게임

import java.util.*;
class baekjoon_1072{
	public static void main(String[] ar){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), r = (int)((double)m * 100 / n), left = 1, right = 1 << 30, rst = 1 << 30;
		if(r < 99){
			while(left <= right){
				int mid = (left / 2) + (right / 2);
				//left랑 right 값 미리 2를 나눠주고 시작
				int R = (int)((double)(m + mid) * 100 / (n + mid));
				if(r < R){
					rst = Math.min(rst, mid);
					right = mid - 1;
				}else left = mid + 1;
			}
			System.out.print(rst);
		}else System.out.print(-1);
	}
}
