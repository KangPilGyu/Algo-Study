package week3;

import java.util.*;

/*
 * 백준_1712_손익분기점
 * 
 * A : 고정 비용
 * B : 가변 비용
 * C : 노트북 한 대 가격
 * 
 * 총 비용 = A + B*(노트북 대수)
 * 총 수입 = C*(노트북 대수)
 * 
 * 1000 70 170 > 11
 */
public class Problem_1712 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		
		// 준혁학생꺼 참고하기 전. bep가 존재하지 않는 경우(무한루프)를 처리하지 못함. A, B, C, bep 를 가지고 왔다갔다 해 봤더니 bep가 존재할 조건이 나옴. 그렇군요..
//		int bep = 0;  // 손익분기점 저장 변수
//		
//		while(true) {  // 이러면 반복을 얼마나 하게 될지... 아무도 몰라.. 시간복잡도 어마무시하게 커질수도있...
//			bep++;
//			if((A + B*bep) < (C*bep)) {  // 총 비용 < 총 수입
//				// A + (B-C)*bep = 0
//				// bep = -A/(B-C)  -> bep 존재 하려면 B-C < 0 이어야함(bep도 자연수일테니까..?)
//				System.out.println(bep);
//				break;
//			}
//		}
		
		if(B-C < 0) {
			System.out.println(-A/(B-C)+1);
		} else {
			System.out.println(-1);
		}
		
	}
}