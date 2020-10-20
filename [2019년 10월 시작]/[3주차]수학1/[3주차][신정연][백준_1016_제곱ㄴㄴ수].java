package week3;

import java.util.*;

/*
 * 백준_1016_제곱ㄴㄴ수 > 시간초과
 * 
 * X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때 제곱ㄴㄴ수라 함.
 * 제곱수는 정수의 제곱 : 1^2 = 1, 2^2 = 4, 3^2 = 9
 * [min, max] 구간에서 제곱ㄴㄴ수의 갯수 구하기.
 * 1 2 3 4 5 6 7 8 9 10
 * 1 10 > 7 (2, 3, 5, 6, 7, 8, 10)
 */
public class Problem_1016 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int min = scan.nextInt();
		int max = scan.nextInt();
		int cnt = 0;
		
		for(int i=min; i<=max; i++) {
			for(int j=2; j*j<max; j++) {
				if(i%(j*j) == 0) {
					cnt++;
					break;
				}
			}
		}
		System.out.println((max-min+1)-cnt);
	}
}
