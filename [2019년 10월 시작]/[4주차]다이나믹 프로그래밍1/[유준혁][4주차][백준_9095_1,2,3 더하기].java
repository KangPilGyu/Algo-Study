package baekjoon_DP;
import java.util.*;
public class baekjoon_9095 {
	static int func(int ori, int num){
        if (num == ori) return 1;
        int sum = 0;
        for (int i = 1; i < 4; i++){
            if (num + i > ori) break;
            sum += func(ori, num + i);
        }
        return sum;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int rnd = sc.nextInt();
        while(rnd-->0){
            System.out.println(func(sc.nextInt(), 0));
        }
    }
}
