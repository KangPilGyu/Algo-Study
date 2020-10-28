import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class jh9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		
		for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack<>();
			char[] arr = br.readLine().toCharArray();			
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '(') {
					stack.push(arr[j]);
				} else {
					if (!stack.isEmpty() && stack.peek() =='(') {
						stack.pop();
					}else {
						stack.push(arr[j]);
					}
				}
			} // for¹® j
			
			if (stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}//for¹® i

	}
}
