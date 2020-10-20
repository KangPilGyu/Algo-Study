package week14;

/*
 * 최대공약수와 최소공배수
 */
public class Programmers_lv1_1 {
	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		answer[0] = gcd(n, m);
		answer[1] = lcm(n, m);
		return answer;
	}

	public static void main(String[] args) {
		int[] rst = solution(3, 8);
		for(int r : rst) System.out.println(r);
	}
}
