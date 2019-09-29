package baekjoon_brute_force;
import java.util.*;
public class baekjoon_2231 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int r = sc.nextInt();
        for(int i=1; i<r; i++) {
        	int temp = i;
        	int sum = i;
        	// 각 자릿수 더해주기
        	while(temp > 0) {
        		sum += temp % 10;
        		temp /= 10;
        	}
        	// 같으면 출력 후 종료
        	if(sum==r) {
        		System.out.println(i);
        		return;
        	}
        }
        //for문을 무사히 빠져나왔다면 생성자가 없다는 뜻이니 0출력.
        System.out.println(0);

	}

}
