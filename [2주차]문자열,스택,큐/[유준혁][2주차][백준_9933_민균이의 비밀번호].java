package workspace;
import java.util.*;
public class baekjoon_9933 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rnd = sc.nextInt();
		List<String> list = new ArrayList<>();
		for(int i=0; i<rnd; i++) {
			String s = sc.next();
			list.add(s); list.add(new StringBuffer(s).reverse().toString());
		}
		list.sort(null);
		for(int i=0; i<list.size(); i++) {
			String s = list.get(i);
			if(s.equals(list.get(i+1))) {
				System.out.println(s.length()+" "+s.charAt(s.length()/2));
				break;
			}
		}
	}
}
