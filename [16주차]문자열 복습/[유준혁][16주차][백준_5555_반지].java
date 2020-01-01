package baekjoon_string;
import java.util.*;
public class baekjoon_5555 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String patt = sc.next();
		int n = sc.nextInt(), cnt = 0;
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			s += s;
			if(s.indexOf(patt) != -1) cnt++;
		}
		System.out.println(cnt);
	}
}
