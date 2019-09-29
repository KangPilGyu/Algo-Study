package baekjoon_brute_force;
import java.util.*;
public class baekjoon_1436 {
	static boolean func(int i){
		// 맨 끝 3자리가 666인지 확인
		// 아니라면 1의 자리를 버리고 다시 재확인
        while(i > 0){
            if(i % 1000 == 666) return true;
            i /= 10;
        }
        return false;
    }
    public static void main(String[]args){
        int cnt = 0;
        int movie = 666;
        int n = new Scanner(System.in).nextInt();
        while(cnt < n){
            if (func(movie)) cnt++;
            movie++;
        }
        // 마지막 while문을 끝날때 movie가 1 증가되어있어서 그냥 빼고 출력했음.
        System.out.println(movie - 1);
    }
}
