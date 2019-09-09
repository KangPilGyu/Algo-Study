package ÀÌÁÖÂ÷;

import java.util.Scanner;

public class Num2941 {
	public static void main(String[] args) {
		String[] change = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String input = new Scanner(System.in).next();

		for (String s : change) {
			if (input.contains(s))
				input = input.replace(s, " ");
		}
		System.out.println(input.length());
	}
}
