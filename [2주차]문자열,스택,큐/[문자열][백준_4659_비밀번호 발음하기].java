package baekjoon_basic;
// https://www.acmicpc.net/problem/4659
// 비밀번호 발음하기
import java.util.*;
public class baekjoon_4659 {
	static boolean aeiou(byte b) {
		return b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u';
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		while(!(s = sc.next()).equals("end")) {
			boolean accept = false;
			byte[] arr = s.getBytes();
			int len = arr.length;
			for(int i = 0; i < len; i++) {
				if(aeiou(arr[i])) accept = true;
				if(i + 1 < len && arr[i] == arr[i + 1] && arr[i] != 'e' && arr[i] != 'o') {
					accept = false; break;
				}
				if(i + 2 < len && (aeiou(arr[i]) == aeiou(arr[i + 1]) && aeiou(arr[i]) == aeiou(arr[i + 2]))) {
					accept = false; break;
				}
			}
			System.out.println("<" + s +"> is " + (accept ? "" : "not ") + "acceptable.");
		}
	}
}
