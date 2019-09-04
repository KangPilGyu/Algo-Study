package workspace;
import java.util.*;
public class baekjoon_1919 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Byte> list1 = new ArrayList<>();
		List<Byte> list2 = new ArrayList<>();
		for(byte b : sc.next().getBytes())list1.add(b);
		for(byte b : sc.next().getBytes())list2.add(b);
		list1.sort(null); list2.sort(null);
		for(int i=0; i<list1.size(); i++) {
			if( list2.indexOf(list1.get(i)) != -1 ) {
				list2.remove(list2.indexOf(list1.get(i)));
				list1.remove(i);
				i--;
			}
		}
		System.out.println(list1.size() + list2.size());
	}
}
