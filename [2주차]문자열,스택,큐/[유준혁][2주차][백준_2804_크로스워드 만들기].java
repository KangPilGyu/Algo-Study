package workspace;
import java.util.*;
public class baekjoon_2804 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int idx1=0, idx2=0;
		for(int i=0; i<s1.length(); i++) {
			if(s2.indexOf(s1.charAt(i)+"") != -1 ) {
				idx2=i;
				idx1=s2.indexOf(s1.charAt(i)+"");
				break;
			}
		}
		for(int i=0; i<s2.length(); i++) {
			if(idx1==i) {
				System.out.println(s1);
				continue;
			}
			for(int j=0; j<s1.length(); j++) {
				if(j==idx2) System.out.print(s2.charAt(i));
				else System.out.print(".");
			}
			System.out.println();
		}
	}
}
