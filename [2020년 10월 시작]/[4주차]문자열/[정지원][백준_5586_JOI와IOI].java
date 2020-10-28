package string;

import java.io.*;

public class _5586 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] arr = s.toCharArray();
		int joi = 0;
		int ioi = 0;
		
		s = "";
		for (int i = 0; i < arr.length; i++) {
			s += arr[i];
			if (s.contains("JOI") || s.contains("IOI")) {
				if (s.contains("JOI")) 
					joi++;		
				else
					ioi++;
				i--;
				s = "";
			}	
		}
		System.out.println(joi);
		System.out.println(ioi);
	}
}