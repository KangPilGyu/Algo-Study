package week5;

import java.util.*;

/* 
 * 백준_1436_영화감독 숌
 * 
 * 6이 적어도 3개 이상 들어간 수 중 n번째 수 구하기
 * 
 * 2
 * -----
 * 1666
 */
public class Problem_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String six = "666";
		String number = six;
		int cnt = 0;
		while(true) {
			if(number.contains(six)) {
				cnt++;
			}
			if(cnt==n) {
				System.out.println(number);
				break;
			}
			number = Integer.toString(Integer.parseInt(number)+1);
		}
	}
}
