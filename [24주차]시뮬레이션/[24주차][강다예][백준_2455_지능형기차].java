import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*기차는 역 번호 순서대로 운행한다.
1.출발역에서 내린 사람 수와 종착역에서 탄 사람 수는 0이다.
2.각 역에서 현재 기차에 있는 사람보다 더 많은 사람이 내리는 경우는 없다.
3.기차의 정원은 최대 10,000명이고, 정원을 초과하여 타는 경우는 없다.
4.4개의 역에 대해 기차에서 내린 사람 수와 탄 사람 수가 주어졌을 때, 기차에 사람이 가장 많을 때의 사람 수를 계산하는 프로그램을 작성하시오.

0 32
3 13
28 25
39 0
*/
public class Main {
	static int off, on, max, cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			off = Integer.parseInt(st.nextToken());
			on = Integer.parseInt(st.nextToken());
			cnt += -off + on;

			max = Math.max(cnt, max);
		}
		if (max > 10000) {
			return;
		} else {
			System.out.println(max);
		}
	}
}
