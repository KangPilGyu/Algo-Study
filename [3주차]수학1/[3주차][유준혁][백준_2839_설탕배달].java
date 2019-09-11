package baekjoon_math;
import java.util.*;
public class baekjoon_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n%5 == 0) System.out.println(n/5); //5로 나누어 떨어지면 5로 나눈 몫이 정답
		else {
			int cnt = 0;
			while(n > 0) { // n이 0보다 클 동안 3씩 뺴가면서 5로 나누어지는 지 확인
				n -= 3;
				cnt ++;
				if( n%5 == 0) {
					cnt += n/5; // 5로 나눈 몫을 cnt에 합치고 break;
					break;
				}
			}
			System.out.println(n<0?-1:cnt); // n이 1보다 작다면 3과 5로 나누어떨어지지 않는 수 이므로 -1
		}
		
		/*
		 * ================
		 * 파이썬으로 푼 코드
		 * ================
		 *  n=int(input())
			if n%5==0:
			    print(n//5)
			else:
			    cnt=0
			    while n>0:
			        n -= 3
			        cnt += 1
			        if(n%5 == 0):
			            cnt += n//5
			            break
			    print(-1 if n<0 else cnt)
		 */
	}
}
