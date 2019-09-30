package week5;

import java.util.*;

/*
 * 백준_2798_블랙잭
 * 
 * 카드 3장을 더했을 때 주어진 숫자를 넘지 않으면서 가장 가까운 수 구하기
 * 
 * 5 21			: 카드수 숫자
 * 5 6 7 8 9	: 카드
 * ----------
 * 21
 */
public class Problem_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cards = new int[sc.nextInt()];
		int num = sc.nextInt();
		int len = cards.length;
		
		for(int i=0; i<len; i++) {
			cards[i] = sc.nextInt();
		}
		
		int min = num;
		int sum = 0;
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(i==j) continue;
				for(int k=0; k<len; k++) {
					if(i==k || j==k) continue;
					sum = cards[i]+cards[j]+cards[k];
					if(sum <= num) {						
						min = Math.min(min, num-sum);
					}
				}
			}
		}
		System.out.println(num-min);
	}
}
