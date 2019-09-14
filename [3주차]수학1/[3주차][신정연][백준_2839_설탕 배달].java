package week3;

import java.util.*;

/*
 * 백준_2839_설탕 배달
 * 
 * 정확하게 N kg 배달
 * 3 kg 봉지, 5 kg 봉지
 * 배달에 필요한 봉지의 최소 개수
 * 정확하게 N kg이 되지 않으면 -1 출력
 * 
 * 18 >  4
 * 4  > -1
 * 6  >  2
 * 9  >  3
 * 11 >  3
 */
public class Problem_2839 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int kg = scan.nextInt();
		int originKg = kg;
		int cnt = 0;
		
		while(true) {
			if(kg%5 == 0) {  // 5 kg으로만 이루어짐.
				System.out.println(kg/5);
				break;
			} else if(kg > 0) {  // 3을 계속 빼다가 멈추지 않고 0아래로 떨어지면
				kg -= 3;
				cnt++;  // 3 kg 봉지의 갯수
				if(kg%5 == 0) {  // 3kg 뺀 나머지가 5로 나눠 떨어지면 3kg은 (cnt)개, 5kg은 (kg/5)개 가 전체 갯수.
					System.out.println(kg/5 + cnt);
					break;
				}
			} else {  // 3을 계속 빼다가 멈추지 않고 0아래로 떨어지면 3kg과 5kg의 혼합으로는 안됨.
				if(originKg%3 == 0) {  // 3 kg으로만 이루어짐.
					System.out.println(originKg/3);
					break;
				} else {
					System.out.println(-1);
					break;					
				}
			}		
		}
		
	}
}
