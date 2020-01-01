package baekjoon_string;
import java.util.*;
public class baekjoon_9536 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine());
		while(tc--> 0) {
			String[] input = sc.nextLine().split(" ");
			String s = "";
			Map<String, String> map = new HashMap<>();
			while(!(s = sc.nextLine()).equals("what does the fox say?")) {
				String[] record = s.split(" ");
				map.put(record[2], record[0]);
			}
			for(String str : input) {
				if(map.getOrDefault(str, "").equals("")) System.out.print(str+" ");
			}
			System.out.println();
		}
	}
}
