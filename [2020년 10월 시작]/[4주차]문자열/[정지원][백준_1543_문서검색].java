package string;

import java.io.*;

public class _1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String str2 = br.readLine();
		int cnt = 0;
		String s = "";
		
		for (int i = 0; i < str.length()-str2.length()+1; i++) {
			s = str.substring(i, i+str2.length());
			if (s.contains(str2)) {
				cnt++;
				i += str2.length()-1;
			}
		}
		
		System.out.println(cnt);
	}
}