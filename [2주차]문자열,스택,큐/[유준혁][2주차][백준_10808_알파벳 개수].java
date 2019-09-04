package workspace;
import java.util.*;
public class baekjoon_10808 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int [] arr = new int [26];
		for(byte b : input.getBytes()) {
			int i = b-97;
			arr[i]+=1;
		}
		for(int i : arr) System.out.print(i+" ");
	}
}
