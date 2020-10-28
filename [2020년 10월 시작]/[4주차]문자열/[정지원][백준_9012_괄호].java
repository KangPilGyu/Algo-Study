package string;

import java.io.*;

public class _9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			String s = br.readLine();			
			if (s.startsWith(")"))
				System.out.println("NO");
		
			else {
				for (int j = 0; j < s.length(); j++) {
					if (String.valueOf(s.charAt(j)).contains(")"))
						cnt--;		
					else
						cnt++;
					if (cnt < 0) {
						System.out.println("NO");
						break;
					}
				}
			
				if (cnt == 0)
					System.out.println("YES");
				else if (cnt > 0)
					System.out.println("NO");		
			}
		}
	}
}