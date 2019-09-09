package ÀÌÁÖÂ÷;

import java.util.Scanner;

public class BaekJoon_10809 {
	public static void main(String[] args) {
		String input = new Scanner(System.in).next();
		String result = "";

		for (int i = 97; i < 123; i++) {
			if (input.indexOf((char) i) > -1) {
				result += input.indexOf((char) i) + " ";
			} else {
				result += (i != 122) ? "-1 " : "-1";
			}
		}
		System.out.println(result);
	}
}
