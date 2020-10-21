package recursive;

import java.io.*;

class _10870 {
	static int fibonacci(int n) {
		if (n > 1)
			return fibonacci(n-1)+fibonacci(n-2);
		else if (n == 1)
			return 1;
		else
			return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibonacci(n));
	}
}