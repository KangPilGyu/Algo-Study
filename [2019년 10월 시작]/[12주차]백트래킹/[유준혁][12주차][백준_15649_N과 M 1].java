package baekjoon_backtracking;
import java.util.*;
public class baekjoon_15649 {
	static int[] arr;
	static int n, m;
	static void func(String s, int x, boolean[] vst) {
		if(x == m) {
			System.out.println(s);
			return;
		}
		for(int i=0; i<n; i++) {
			if(!vst[i]) {
				String tmp = s;
				tmp += arr[i] + " ";
				vst[i] = true;
				func(tmp, x + 1, vst);
				vst[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		arr = new int [n];
		for(int i=0; i<n; i++) arr[i] = i + 1;
		func("", 0, new boolean[n]);
	}
}
