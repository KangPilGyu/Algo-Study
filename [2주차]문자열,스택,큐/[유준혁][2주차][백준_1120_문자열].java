package workspace;
import java.util.*;
public class baekjoon_1120 {
	public static int count(String a , String b) {
		int cnt=0;
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a=sc.next(), b=sc.next();
		int aLen=a.length(), bLen=b.length(), cnt=0;
		cnt = count(a, b.substring(bLen - aLen));
		for (int i=0; i<bLen-aLen; i++) {
			int func = count(a, b.substring(i, aLen + i));
			if (cnt > func) cnt = func;
		}
		System.out.println(cnt);
	}
}
