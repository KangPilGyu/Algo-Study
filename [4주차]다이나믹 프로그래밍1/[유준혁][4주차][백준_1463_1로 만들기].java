package baekjoon_DP;

import java.util.Scanner;

public class baekjoon_1463 {
	static int [] arr = new int [1000001];
    static int func(int i){
        if (arr[i] != 0) return arr[i];
        int min = 100000;
        if (i % 2 == 0) min = Math.min(min, func(i / 2));
        if (i % 3 == 0) min = Math.min(min, func(i / 3));
        min = Math.min(min, func(i - 1));
        return arr[i] = min + 1;
    }
    public static void main(String[]x){
        int n = new Scanner(System.in).nextInt();
        arr[0] = -1; arr[2] = 1; arr[3] = 1;
        System.out.println(func(n));
    }
}
