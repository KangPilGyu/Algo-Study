package week2;

import java.io.*;

public class Problem_10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int cnt = 0;
		int temp = cnt;
		
		for(int i=(int)'a'; i<=(int)'z'; i++) {
			for(int j=0; j<word.length(); j++) {
				if(word.charAt(j) == (char)i) {
					System.out.print(j + " ");
					cnt++;
					break;
				}
			}
			if(cnt == temp) {
				System.out.print("-1 ");
			} else {
				temp = cnt;
			}	
		}
	}
}
