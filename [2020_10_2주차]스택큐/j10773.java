package stackdeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class j10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a!=0) {
				stack.push(a);
			}else {
				stack.pop();
			}
		}
		
		int sum = 0;
		int len = stack.size();
		for (int i = 0; i < len; i++) {			
			int num = stack.peek();
			sum = sum+num;
			stack.pop();
		}
		System.out.println(sum);
	}
}
