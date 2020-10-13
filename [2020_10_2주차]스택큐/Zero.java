package stack;

import java.util.*;

public class Zero {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int answer = 0;
		Stack<Integer> stk = new Stack();
		
		for (int i = 0; i < n; i++) {
			int account = in.nextInt();
			if (stk.size() > 0 && account == 0)
				stk.pop();
			else
				stk.push(account);
		}
		
        for (int j = 0; j < stk.size(); j++) {
        	answer += stk.get(j);
        }
        
        System.out.println(answer);
	}
}
