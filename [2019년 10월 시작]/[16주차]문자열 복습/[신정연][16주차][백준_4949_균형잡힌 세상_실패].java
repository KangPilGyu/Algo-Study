package week16;

import java.util.*;
import java.io.*;

/*
 * 백준_4949_균형잡힌 세상
 * ( 40
 * ) 41
 * [ 91
 * ] 93
 */
public class Problem_4949 {
	public static boolean isBalanced(String S) {
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();
		int len = S.length();
		for(int i=0; i<len; i++) {
			char c = S.charAt(i);
			if(c == '(' || c == ')' || c == '[' || c == ']') {
				queue.add(c);  // 괄호만 저장.
			}
		}
		
		while(!queue.isEmpty()) {
			if(queue.peek() == '(' || queue.peek() == '[') {  // 열리는 괄호는 queue에서 꺼내서 stack에 저장.
				stack.push(queue.poll());
			} else if(!stack.isEmpty()) {  // 닫히는 괄호인데 stack에 열리는 괄호가 있는 경우.
				if(queue.peek() - stack.peek() <= 2) {  // 올바른 짝이면 둘 다 빼버려
					queue.poll();
					stack.pop();
				} else {  // 올바르지 않은 짝 -> 균형 x
					return false;
				}
			} else {  // 닫히는 괄호인데 stack이 비어있다는 것은 열리는 것 없이 닫혔다는 것 -> 균형 x
				return false;
			}
		}
		
		if(stack.size() > 0) {  // 열리는 괄호만 남은 경우 짝이 맞지 않는 것 -> 균형 x
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		do {
			if(isBalanced(S) == true) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			S = br.readLine();
		} while(!S.equals("."));
	}
}
