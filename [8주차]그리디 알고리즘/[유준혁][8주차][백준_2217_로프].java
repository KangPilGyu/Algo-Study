package baekjoon_greedy;
import java.util.*;
public class baekjoon_2217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) list.add(sc.nextInt());
		list.sort((i1, i2)->{return i2-i1;});
		
		int cnt = 1;
		int result = list.get(0);
		
		for(int x=1; x<list.size(); x++) {
			int i = list.get(x);
			cnt++;
			result = Math.max(result, i * cnt);
		}
		System.out.println(result);
	}
}
