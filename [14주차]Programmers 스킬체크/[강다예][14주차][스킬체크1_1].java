import java.util.Scanner;

public class pgdfdafad {
//길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
//예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
	}
	
	 public static String solution(int n) {
	      String answer = "";
	      String s = "";
	      for (int i = 0; i < n; i++) {
	    	  s += i%2==0 ? "수" : "박";		      
		}
	      answer = s.substring(0,n);
	      
	      return answer;
	  }

}
