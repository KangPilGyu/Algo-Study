import java.util.*;
class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), ball = 1, a, b;
		for(int i = 0; i < n; i++) {
			a = sc.nextInt(); b = sc.nextInt();
			ball = a == ball ? b : b == ball ? a : ball;
		}
		System.out.println(ball);
	}
}
