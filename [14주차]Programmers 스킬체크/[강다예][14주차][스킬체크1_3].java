import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pg80007 {
	/*
	 * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면
	 * False를 리턴하고 1234라면 True를 리턴하면 됩니다.
	 * 
	 * s는 길이 1 이상, 길이 8 이하인 문자열입니다. 입력 a234 출력 false 입력 1234 출력 true
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(solution(s));

	}

	public static boolean solution(String s) {
		boolean answer = true;
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(s);

		if ((s.length() == 4 || s.length() == 6) && m.find()) {
			return answer;
		}
		return false;

	}
	
	

}
