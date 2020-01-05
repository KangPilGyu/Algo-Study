package baekjoon_string;
import java.util.*;
public class baekjoon_10546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> list = new ArrayList<>();
		for(int i = 0; i < n * 2 - 1; i++) list.add(sc.next());
		list.sort(null);
		for(int i = 0; i < list.size() - 1; i += 2) {
			if(!list.get(i).equals(list.get(i + 1))) {
				System.out.println(list.get(i));
				return;
			}
		}
		System.out.println(list.get(list.size() - 1));
	}
}
