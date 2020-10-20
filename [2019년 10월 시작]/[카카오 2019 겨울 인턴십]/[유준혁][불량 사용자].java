package programmers;
// https://programmers.co.kr/learn/courses/30/lessons/64064
// 불량 사용자
import java.util.*;
public class prgmers_64064 {
	static int limit;
	static Set<Integer> set = new HashSet<>();
	static boolean check(String user, String ban, int len) {
		for(int i = 0; i < len; i++) {
			if(ban.charAt(i) == '*') continue;
			if(user.charAt(i) != ban.charAt(i)) return false;
		}
		return true;
	}
	static void match(String[] users, String[] banned, int bit, int idx) {
		if(idx == banned.length) set.add(bit);
		else {
			int blen = banned[idx].length();
			for(int i = 0; i < users.length; i++) {
				if((bit & (1 << i)) == 0) {
					int ulen = users[i].length();
					if(ulen == blen && check(users[i], banned[idx], ulen)) {
						match(users, banned, bit | (1 << i), idx + 1);
					}
				}
			}
		}
	}
	static int solution(String[] user_id, String[] banned_id) {
        limit = (1 << user_id.length) - 1;
        match(user_id, banned_id, 0, 0);
        
        return set.size();
    }
	public static void main(String[] args) {
		System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));

	}

}
