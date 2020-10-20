package workspace;
import java.util.*;
public class baekjoon_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String [] arr = new String[] {"c=","c-","dz=","d-","lj","nj","s=","z="};
		int cnt = 0;
		for(String str : arr) {
			while(s.contains(str)) {
				cnt++;
				s=s.replaceFirst(str," ");
			}
		}
		for(byte b : s.getBytes())if((char)b!=' ')cnt++;
		System.out.println(cnt);

	}

}
