package baekjoon_string;
import java.util.*;
public class baekjoon_3613 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuffer sb = new StringBuffer();
		if(s.matches("^[a-z][a-zA-Z]*")) {
			for(byte b : s.getBytes()) {
				if('A' <= b && b <= 'Z') sb.append("_" + (char)(b + 32));
				else sb.append((char)b);
			}
		}else if(s.matches("^[a-z][a-z_]*[a-z]$")) {
			boolean us = false;
			for(byte b : s.getBytes()) {
				if(b == '_') {
					if(us) {
						sb = new StringBuffer("Error!");
						break;
					}
					us = true;
				}
				else {
					sb.append(us ? (char)(b - 32) : (char)b);
					us = false;
				}
			}
		}else {
			sb.append("Error!");
		}
		System.out.println(sb.toString());
	}
}
