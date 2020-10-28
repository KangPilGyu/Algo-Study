package string;

import java.io.*;

public class _1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		
		for (int i = 0; i < 8; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				if (i % 2 != 0) 
					j++;
				if (String.valueOf(s.charAt(j)).contains("F"))
						answer++;
				if (i % 2 == 0)
					j++;
			}
		}
		System.out.println(answer);
	}
}