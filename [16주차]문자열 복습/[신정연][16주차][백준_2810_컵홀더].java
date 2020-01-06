package week16;

import java.util.*;

/*
 * 백준_2810_컵홀더
 */
public class Problem_2810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String seats = sc.next();
		int cnt = 0;
		for(int i=0; i<N; i++) {
			char c = seats.charAt(i);
			if(c == 'S') {
				cnt++;
			} else {
				cnt++;
				i++;
			}
		}
		if(cnt + 1 > N) {  // 최종 사람 수를 구하는 것이기 때문에 좌석수보다 많으면 안쓰는 컵홀더가 있을 것.
			System.out.println(N);
		} else {
			System.out.println(cnt + 1);			
		}
	}
}
