package baekjoon_DP;
import java.util.*;
public class baekjoon_1003 {
	public static void main(String[] args) {
		long [] arr = new long [41];
        Scanner sc = new Scanner(System.in);
        int rnd = sc.nextInt();
        arr[0]=0; arr[1]=1;
        for (int i = 2; i<41; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        for(int i = 0; i < rnd; i ++){
            int input=sc.nextInt();
            if (input==0) System.out.println("1 0");
            else System.out.println(arr[input-1]+" "+arr[input]);
        }
	}
}
