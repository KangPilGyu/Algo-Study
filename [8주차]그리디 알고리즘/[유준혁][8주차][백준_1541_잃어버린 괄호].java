package baekjoon_greedy;
import java.util.*;
public class baekjoon_1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] arr = input.split("-");
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			int tmp = 0;
			for(String s : arr[i].split("[+]")) {
				tmp += Integer.parseInt(s);
			}
			if(i==0) sum += tmp;
			else sum -= tmp;
		}
		System.out.println(sum);
	}
}
