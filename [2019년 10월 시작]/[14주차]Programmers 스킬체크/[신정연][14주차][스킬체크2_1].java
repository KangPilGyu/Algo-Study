package week14;

/*
 * H-Index
 * 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의 H-Index.
 */
public class Programmers_lv2_1 {
	static int[] cit;
	static int len;

	public static boolean hIndex(int h) {
		int more = 0;
		for (int i = 0; i < len; i++) {
			if (cit[i] >= h)
				more++;
		}
		if (more >= h)
			return true;
		return false;
	}

	public static int solution(int[] citations) {
		int answer = 0;
		cit = citations;
		len = citations.length;
		int max = 0;
		for (int i = 0; i < len; i++) {
			max = Math.max(citations[i], max);
		}
		for (int i = 0; i <= max; i++) {
			if (hIndex(i)) {
				answer = Math.max(i, answer);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
	}
}
