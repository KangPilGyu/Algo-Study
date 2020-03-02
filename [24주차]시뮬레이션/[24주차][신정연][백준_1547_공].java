import java.util.*;

public class Main {
	static int[] cup;
	public static int findIdx(int x) {
		for(int i=1; i<4; i++) {
			if(cup[i] == x) return i;
		}
		return x;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cup = new int[4];
		for(int i=1; i<4; i++) cup[i] = i;
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == b) continue;
			int aIdx = findIdx(a);
			int bIdx = findIdx(b);
			cup[aIdx] = b;
			cup[bIdx] = a;
		}
		System.out.println(cup[1]);
	}
}
