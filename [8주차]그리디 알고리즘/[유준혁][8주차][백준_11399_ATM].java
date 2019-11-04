package baekjoon_greedy;
import java.util.*;
public class baekjoon_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wait = new int [n];
		int sum = 0;
		int tmp = 0;
		for(int i=0; i<n; i++) wait[i] = sc.nextInt();
		Arrays.sort(wait);
		for(int i : wait) {
			tmp += i;
			sum += tmp;
		}
		System.out.println(sum);

	}

}
