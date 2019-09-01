package week_1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class backjoon_1158 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n= scanner.nextInt();
		int k = scanner.nextInt();

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		Iterator<Integer> iter = list.iterator();
		Integer temp = null;
		System.out.print("<");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				if (!iter.hasNext()) {
					iter = list.iterator();
				}
				temp = iter.next();
			}
			iter.remove();
			System.out.print(temp);
			if (list.size() != 0) System.out.print(", ");
		}
		System.out.println(">");

	}
}
