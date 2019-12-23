package week14;

import java.util.*;

/*
 * 짝지어 제거하기.
 * "baabaa"
 * "bbaa"
 * "aa"
 * ""
 * ---------
 * 1
 */
public class Programmers_lv2_2 {
	
	public static int solution(String s) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for(int i=1; i<s.length(); i++) {
			if(!stack.isEmpty()) {
				if(stack.peek() == s.charAt(i)) {
					stack.pop();
				}
			} else {
				stack.push(s.charAt(i));				
			}
		}
		if(stack.size() == 0) {
			answer = 1;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
	}
}
