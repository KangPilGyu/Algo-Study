import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 1.지민이가 가지고 있는 막대의 길이를 모두 더한다. 처음에는 64cm 막대 하나만 가지고 있다. 이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
	1)가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
	2)만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
2.이제, 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.
X가 주어졌을 때, 위의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 구하는 프로그램을 작성하시오. 
입력 23 출력 4
*/
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int length = 64; int cnt = 0; int sum = 0;

		while (x != sum) {
			if (x < length) {
				length /= 2;
			} else {
				cnt++;
				sum += length;
				if (sum > x) {
					sum -= length;
					cnt--;
				}
				length /= 2;
			}
		}

		System.out.println(cnt);
	}
}
