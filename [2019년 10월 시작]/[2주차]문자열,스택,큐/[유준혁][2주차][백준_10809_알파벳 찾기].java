package workspace;
import java.util.*;

public class baekjoon_10809 {
	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		List<Character> list = new ArrayList<>();
		for(byte b : sc.next().getBytes()) {
			list.add((char)b);
		}
		for(char c='a'; c<='z'; c++) {
			System.out.print(list.indexOf(c)+" ");
		}
	}
}
