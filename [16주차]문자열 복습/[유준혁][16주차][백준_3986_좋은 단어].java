import java.util.*;
class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rnd = sc.nextInt();
		int cnt = 0;
		while(rnd-->0) {
			String s = sc.next();
            Stack<Character> stack = new Stack<>();
            char[] arr = s.toCharArray();
            for(char c : arr){
                if(stack.isEmpty()) stack.add(c);
                else{
                    if(stack.peek() == c) stack.pop();
                    else stack.add(c);
                }
            }
			if (stack.isEmpty()) cnt++;
		}
		System.out.println(cnt);
	}
}
