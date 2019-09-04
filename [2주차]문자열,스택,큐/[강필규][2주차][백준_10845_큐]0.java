package week_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class backjoon_10845 {
	public static void main(String[] a) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		ArrayList<Integer> plist = new ArrayList<Integer>();
		ArrayDeque<Integer> list = new ArrayDeque<Integer>();
		for (int i = 0; i < n; i++) {
			String order = scanner.next();

			int pV = 0;
			switch(order) {
			case "push":
				int value = scanner.nextInt();
				list.push(value);
				break;
			case "pop":
				pV = list.isEmpty() ? -1 : list.pollLast();
				plist.add(pV);
				break;
			case "size":
				plist.add(list.size());
				break;
			case "empty":
				pV = list.isEmpty() ? 1 : 0;
				plist.add(pV);
				break;
			case "front":
				pV = list.isEmpty() ? -1 : list.peekLast();
				plist.add(pV);
				break;
			case "back":
				pV = list.isEmpty() ? -1 : list.peekFirst();
				plist.add(pV);
				break;
			}
		}
		for (Integer p : plist) {
			System.out.println(p);
		}
	}
}
