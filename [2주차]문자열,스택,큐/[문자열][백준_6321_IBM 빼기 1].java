package baekjoon_basic;
// https://www.acmicpc.net/problem/6321
// IBM »©±â 1
import java.util.*;
public class baekjoon_6321 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			sb.append("String #" + (i + 1) + "\n");
			for(byte b : s.getBytes()) sb.append((char)(b == 'Z' ? 'A' : b + 1));
			if(i < n - 1) sb.append("\n\n");
		}
		System.out.print(sb.toString());
	}
}
