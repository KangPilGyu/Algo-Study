package baekjoon_DP;
import java.util.*;
public class baekjoon_2748 {
	public static void main(String[] args) {
		long [] arr = new long [91];
        Scanner sc = new Scanner(System.in);
        int rnd = sc.nextInt();
        arr[0]=0; arr[1]=1;
        for (int i = 2; i<rnd+1; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[rnd]);
	}
}
