package workspace;

import java.util.Arrays;
import java.util.stream.Stream;

/*
이상한 문자 만들기
문제 설명
문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

제한 사항
문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
입출력 예
s	return
try hello world	TrY HeLlO WoRlD
입출력 예 설명
try hello world는 세 단어 try, hello, world로 구성되어 있습니다. 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다. 따라서 TrY HeLlO WoRlD 를 리턴합니다.
 */
public class find_prime {
	public static String solution(String s) {
		String answer = "";
	      for(String str : s.split(" ")) {
	          int n=1;
	          for(byte b : str.getBytes()) {
	              if(n%2==1)answer += ((char)b+"").toUpperCase();
	              else answer += ((char)b+"").toLowerCase();
	              n++;
	          }
	          answer+=" ";
	      }
	      return answer.substring(0,answer.length()-1);
	  }
	public static void main(String[] args) {
		System.out.println(solution(""));
	}

}
