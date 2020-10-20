package ¿Ã¡÷¬˜;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class baekJoon_5622 {
	public static void main(String[] args) {
		int result = 0;
		Map<String, Integer> Dial = new HashMap<String, Integer>();
		Dial.put("ABC",2);Dial.put("DEF",3);Dial.put("GHI",4);Dial.put("JKL",5);
		Dial.put("MNO",6);Dial.put("PQRS",7);Dial.put("TUV",8);Dial.put("WXYZ",9);
		
		String input = new Scanner(System.in).next();

		for (int i = 0; i < input.length(); i++) {
			for (String key : Dial.keySet()) {
				if (key.contains(input.charAt(i) + "")) {
					result += Dial.get(key);
					break;
				}
			}
		}
		result += input.length();
		System.out.println(result);
	}
}
