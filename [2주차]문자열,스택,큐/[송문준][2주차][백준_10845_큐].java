package week2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_10845 {
	public static void main(String[] args) {
		Queue<Integer> qu = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		String input = "";
		int count = sc.nextInt();
		int num = 0;

		for (int i = 0; i <= count; i++) {
			input = sc.nextLine();

			switch (input.split(" ")[0]) {
			case "push":
				num = splitNum(input);
				qu.add(num);
				break;
			case "pop":
				num = (qu.isEmpty()) ? -1 : qu.poll();
				System.out.println(num);
				break;
			case "size":
				System.out.println(qu.size());
				break;
			case "empty":
				num = (qu.isEmpty()) ? 1 : 0;
				System.out.println(num);
				break;
			case "front":
				num = (qu.isEmpty()) ? -1 : qu.peek();
				System.out.println(num);
				break;
			case "back":
				if (!qu.isEmpty()) {
					Iterator<Integer> itr = qu.iterator();
					while (itr.hasNext()) {
						num = itr.next();
					}
				} else {
					num = -1;
				}
				System.out.println(num);
				break;
			}
		}
	}

	private static int splitNum(String input) {
		return Integer.parseInt(input.split(" ")[1]);
	}
}
