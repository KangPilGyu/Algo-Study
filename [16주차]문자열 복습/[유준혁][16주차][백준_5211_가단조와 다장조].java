package baekjoon_string;
import java.util.*;
public class baekjoon_5211 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String scale = sc.next();
		int major = 0, minor = 0;
		for(String s : scale.split("[|]")) { // 정규식때문에 4번 틀림 ㅡㅡ
			char c = s.charAt(0);
			if(c == 'C' || c == 'F' || c == 'G') major++;
			if(c == 'A' || c == 'D' || c == 'E') minor++;
		}
		if(major == minor) {
			char c = scale.charAt(scale.length() - 1);
			if(c == 'C' || c == 'F' || c == 'G') major++;
			if(c == 'A' || c == 'D' || c == 'E') minor++;
		}
		System.out.println(major > minor ? "C-major" : "A-minor");
	}
}
