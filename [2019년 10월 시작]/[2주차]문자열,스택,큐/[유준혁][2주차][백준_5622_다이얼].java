package workspace;
import java.util.*;
public class baekjoon_5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [] {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
		String input = sc.next();
		int sum=0;
		for (byte b : input.getBytes()) sum += arr[(char)b-'A'];
		System.out.println(sum);

	}

}
