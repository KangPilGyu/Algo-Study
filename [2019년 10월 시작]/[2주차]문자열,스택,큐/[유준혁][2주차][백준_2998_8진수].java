package workspace;
import java.util.*;
public class baekjoon_2998 {
	public static void main(String[] args) {
		//첫번째 시도. 숏코딩을 노렸지만 자릿수 덕분에 런타임에러 발생. 
//		System.out.println( Long.toOctalString( Long.parseLong( new Scanner(System.in).next(),2 )));
		
		//두번째 시도. 문제에 나온대로의 정석 풀이. 111과 같이 3자리로 끊어져서 들어오는 경우 맨 앞에 0이 붙길래 마지막에 조건 추가함.
		String input = new Scanner(System.in).next();
		String s = "0".repeat( 3 - input.length()%3 ) + input;
		String result = "";
		byte [] bArr = s.getBytes();
		for(int i=0; i<bArr.length/3; i++) {
			String oct = "";
			for(int j=i*3; j<i*3+3; j++) oct +=(char)bArr[j];
			result += Integer.toOctalString( Integer.parseInt(oct, 2));
		}
		if (result.charAt(0)=='0') System.out.println(result.substring(1));
		else System.out.println(result);
	}
}
