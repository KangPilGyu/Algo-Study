package baekjoon_simulation;
// https://www.acmicpc.net/problem/1057
// 토너먼트
/*
 * 문제 풀기 전 생각 2020.02.27 20:38
 * -----------------------------
 * 뭐징..그냥 드는 생각으론 홀수면 + 1 짝수면 그대로 두고 2로 나누고
 * 둘을 - 1 시켜서 2로 나눈게 같으면 다음라운드에 만나는거 아닌가..?
 * 
 * 문제 풀고 난 후 생각 2020.02.27 20:45
 * -----------------------------
 * 맞네..? 뭐지
 */
import java.util.*;
public class baekjoon_1057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		int a = sc.nextInt(), b = sc.nextInt(), cnt = 1;
		while((a - 1) / 2 != (b - 1) / 2) {
			a = (a + (a % 2 == 1 ? 1 : 0)) / 2;
			b = (b + (b % 2 == 1 ? 1 : 0)) / 2;
			cnt++;
		}
		System.out.println(cnt);
	}
}
