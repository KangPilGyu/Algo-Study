package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class j10870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		System.out.println(recursion(n));
	}

	private static int recursion(int a) {
		
		if (a == 0) {
			return 0;
		}else if(a==1){
			return 1;
		}else {			
		return	recursion(a-2)+recursion(a-1);		
		}
		
	}
	
}
