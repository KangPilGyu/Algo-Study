package baekjoon_queue;

public class baekjoon_2164_1 {
	public static void main(String[] args) {
		int n = new java.util.Scanner(System.in).nextInt(), t = 1;
		while(t < n) t *= 2;
		System.out.println(t - (t - n) * 2);
	}
}
