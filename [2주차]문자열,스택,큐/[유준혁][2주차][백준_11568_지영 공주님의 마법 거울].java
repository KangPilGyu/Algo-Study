package workspace;
import java.util.*;
public class baekjoon_11568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rnd = sc.nextInt();
		String [] arr = new String [rnd];
		for(int i=0; i<rnd; i++) arr[i]=sc.next(); //지영 공주님 입력
		int K = sc.nextInt(); //마법거울의 심리상태
		int i=0, n=1; //증감연산에 사용 될 변수
		if (K==3) { //상하 반전되어 출력하는 경우
			i += rnd-1; //예제 입력의 경우 7부터 시작
			n *= -1;    //K가 1이라면 ++ 3이라면 -- 연산의 의미를 갖게 됨
		}
		for(; 0<=i && i<rnd; i += n) { // i가 범위 내에 있는 경우 반복.
			if(K==2) System.out.println(new StringBuffer(arr[i]).reverse()); //K가 2라면 좌우 반전을 해주어야 함.
			else System.out.println(arr[i]); // 아니라면 그냥 출력.
		}
	}
}
