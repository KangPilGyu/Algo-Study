package programmers;
// https://programmers.co.kr/learn/courses/30/lessons/64065
// Æ©ÇÃ
import java.util.*;
public class prgmers_64065 {
	static int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
        	for(String s2 : s1.split(",")) {
        		if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
		System.out.println(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
//		System.out.println(solution("{{20,111},{111}}"));
//		System.out.println(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
	}
}
