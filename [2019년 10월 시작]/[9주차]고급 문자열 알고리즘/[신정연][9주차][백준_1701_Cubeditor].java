package week9;

import java.io.*;

/*
 * 백준_1701_Cubeditor
 * 
 * failure function
 * 어떤 문자열에서 두 번 이상 나오는 부분 문자열 중에서 가장 길이가 긴 것을 구하는 프로그램을 작성.
 * 
 * abcabcabc
 * ----------
 * 6
 * 
 * abc는 세 번.
 * abcabc도 두 번.
 * 두 번 이상 나오는 부분 문자열 중에서 가장 긴 것은 abcabc.
 * 
 * abcdabcabb
 * ----------
 * 3
 * 
 * abcdeffgbbcbba		이런 경우는 어떻게 하지... 하나씩 뒤로 밀어서 다 실행해 봐야하나요...?
 * ---------------
 * 2
 */
public class Problem_1701 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
//		int max = 0;
//		int cnt = 0;
//		StringBuilder sub = new StringBuilder();
//		
//		for(int i=0; i<s.length(); i++) {
//			sub.append(s.substring(i, i+1));
//			for(int j=0; j<s.length(); j++) {
//				if(s.substring(j, j+sub.length()).equals(sub.toString())) cnt++;
//				if(j+sub.length() == s.length()) break;
//			}
//			if(cnt > 1) {
//				max = Math.max(max, sub.length());		
//			}
//			cnt = 0;
//		}
//		System.out.println(max);
		
		StringBuilder sub = new StringBuilder();
		int[] pattern = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			sub.append(s.charAt(i));
			int k = 0;
			for(int j=1; j<sub.length(); j++) {
				if(sub.charAt(k) == sub.charAt(j)) {
					pattern[i] += 1;
					k++;
				}
			}
		}
		
		int max = 0;
		for(int p : pattern) {
			max = Math.max(max, p);
		}
		System.out.println(max);
	}
}
