package week16;

import java.util.*;

/*
 * 백준_3613_Java vs C++
 */
public class Problem_3613_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		StringBuffer output = new StringBuffer();
		int len = input.length();
		char c;
		String cToString = "";
		
		if(input.matches("^[a-z][a-z_]*[a-z]$")) {
			for(int i=0; i<len; i++) {
				c = input.charAt(i);
				if(c == '_') {
					if(input.charAt(i+1) == '_') {  // _가 연속적으로 나오면 Error
						output = new StringBuffer("Error!");
						break;
					}
					cToString = input.charAt(++i) + "";
					output.append(cToString.toUpperCase());
				} else {
					output.append(c);
				}
			}
		} else if(input.matches("^[a-z][a-zA-Z]*")) {
			for(int i=0; i<len; i++) {
				c = input.charAt(i);
				if(c >= 'A' && c <= 'Z') {
					cToString = "_" + c;
					output.append(cToString.toLowerCase());
				} else {
					output.append(c);
				}
			}
		} else {
			output.append("Error!");
		}
		System.out.println(output);
	}
}
