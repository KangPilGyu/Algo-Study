package week16;

import java.util.*;

/*
 * 백준_1316_그룹 단어 체커
 */
public class Problem_1316 {
	public static boolean groupCheck(String S) {
		int len = S.length();
		if(len == 1) {
			return true;
		}
		Set<Character> alpha = new HashSet<>();  // 중복 x
		alpha.add(S.charAt(0));
		int groupCnt = 1;
		for(int i=1; i<len; i++) {
			alpha.add(S.charAt(i));
			if(S.charAt(i-1) != S.charAt(i)) {  // 바뀌는 구간에서 그룹갯수 올려줌.
				groupCnt++;
			}
		}
		if(groupCnt == alpha.size()) {  // 그룹 갯수랑 저장된 알파벳의 갯수가 같으면 그룹 단어임.
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for(int i=0; i<N; i++) {
			String S = sc.next();
			if(groupCheck(S) == true) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
