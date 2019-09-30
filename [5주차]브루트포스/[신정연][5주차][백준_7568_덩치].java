package week5;

import java.util.*;

/*
 * 백준_7568_덩치
 * 
 * 나보다 덩치가 큰 사람이 k명이면 등수는 k+1일 때 등수 구하기
 * 
 * 5
 * 55 185
 * 58 183
 * 88 186
 * 60 175
 * 46 155
 * -------
 * 2 2 1 2 5
 */
public class Problem_7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] wehe = new int[2][num];
		int[] rank = new int[num];
		
		for(int i=0; i<num; i++) {
			wehe[0][i] = sc.nextInt();
			wehe[1][i] = sc.nextInt();
		}
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(i==j) continue;
				if((wehe[0][i] < wehe[0][j]) && (wehe[1][i] < wehe[1][j])) {
					rank[i] += 1;
				}
			}
			System.out.print((i!=num-1)?((rank[i]+1) + " "):(rank[i]+1));
		}
	}
}
