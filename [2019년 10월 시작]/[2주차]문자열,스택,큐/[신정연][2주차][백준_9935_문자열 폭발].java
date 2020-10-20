package week2;

import java.io.*;

/*
 * 백준_9935_문자열_폭발
 * 
 * mirkovC4nizCC44
 * C4
 * ----------------
 * mirkovniz
 * 
 * 
 * 12ab112ab2ab
 * 12ab
 * ----------------
 * FRULA
 */
public class Problem_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String bomb = br.readLine();
		
		while(input.contains(bomb)) {
			String[] split = input.split(bomb);
			input = "";
			for(String s : split) {
				input += s;
			}
			if(input.isBlank()) {
				input = "FRULA";
			}
		}
		System.out.println(input);
	}
}
