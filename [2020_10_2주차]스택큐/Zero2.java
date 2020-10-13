package stack;

import java.util.*;

public class Zero2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int answer = 0;
		Stack<Integer> stk = new Stack();
        
		int i = 0;
		while (i < n) {
			int account = in.nextInt();
			if (stk.size() > 0 && account == 0)
				stk.pop();
			else
				stk.push(account);
			i++;
		}
		
        for (int j = 0; j < stk.size(); j++) {
        	answer += stk.get(j);
        }
        
        System.out.println(answer);
	}
}
