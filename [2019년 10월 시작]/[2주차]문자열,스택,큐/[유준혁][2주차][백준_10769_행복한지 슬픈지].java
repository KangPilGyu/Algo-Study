package workspace;
import java.io.*;
public class baekjoon_2804 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int happy=0, sad=0;
		for(int i=0; i<input.length()-2; i++) {
			String s = input.substring(i);
			if(s.startsWith(":-)")) happy++;
			if(s.startsWith(":-(")) sad++;
		}
		if(happy==0 && sad==0) System.out.println("none");
		else if(happy > sad) System.out.println("happy");
		else if(happy < sad) System.out.println("sad");
		else System.out.println("unsure");
	}
}
