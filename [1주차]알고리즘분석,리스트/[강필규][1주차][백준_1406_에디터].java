package week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_1406 {
	public static void main(String[] args) throws IOException {
		//Scanner scanner = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

		String str = bf.readLine();
		int k = Integer.parseInt(bf.readLine());

		StringBuffer text = new StringBuffer(str);
		int cursor = text.length();
		for (int i = 0; i < k; i++) {
			String temp = bf.readLine();
			char ch = temp.charAt(0);

			switch(ch) {
			case 'P':
				text.insert(cursor++, temp.charAt(2));
				break;
			case 'L':
				if (cursor-1 >= 0) {
					cursor--;
				}
				break;
			case 'D':
				if (cursor+1 <= text.length()) {
					cursor++;
				}
				break;
			case 'B':
				if (cursor-1 >= 0) {
					text.replace(cursor-1, cursor, "");
					cursor--;
				}
				break;
			}
		}
		System.out.println(text);
	}
}
