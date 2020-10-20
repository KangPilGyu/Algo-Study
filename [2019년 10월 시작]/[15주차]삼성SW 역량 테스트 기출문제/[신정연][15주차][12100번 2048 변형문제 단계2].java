package week15;

import java.util.*;

/*
 * 백준_Samsung_2048(Easy) 변형 2단계
 * 4 2
 * 2 0 2 0
 * 2 2 4 4
 * 2 2 4 4
 * 2 4 8 8
 * R D		(R L U D)
 */
class CellCheck {
	int value;
	boolean merged;

	CellCheck(int value, boolean merged) {
		this.value = value;
		this.merged = merged;
	}
}

public class SamsungSWTest2 {
	static int[][] rst;
	static int N;

	public static void moveUD(String inst) {  // 행을 고정하고 열을 움직임.
		Deque<CellCheck> dq = new LinkedList<>();
		// U : 0 -> N
		int js = 0;
		int je = N;
		String direction = "zton";
		
		if(inst.equals("D")) {  // D : N -> 0.
			js = N - 1;
			je = 0;
			direction = "ntoz";
		}
		
		switch (direction) {
		case "ntoz":
			for (int i = 0; i < N; i++) {
				for (int j = js; j >= je; j--) {  // N -> 0
					if (rst[j][i] == 0)
						continue;
					if (!dq.isEmpty()) {
						if (dq.peekLast().value == rst[j][i] && !dq.peekLast().merged) {
							dq.pollLast();
							dq.offerLast(new CellCheck(rst[j][i] * 2, true));
						} else {
							dq.offerLast(new CellCheck(rst[j][i], false));
						}
					} else {
						dq.offerLast(new CellCheck(rst[j][i], false));
					}
				}
				for (int j = js; j >= je; j--) {
					if (!dq.isEmpty()) {
						rst[j][i] = dq.pollFirst().value;
					} else {
						rst[j][i] = 0;
					}
				}
			}
			break;

		case "zton":
			for (int i = 0; i < N; i++) {
				for (int j = js; j < je; j++) {  // 0 -> N
					if (rst[j][i] == 0)
						continue;
					if (!dq.isEmpty()) {
						if (dq.peekLast().value == rst[j][i] && !dq.peekLast().merged) {
							dq.pollLast();
							dq.offerLast(new CellCheck(rst[j][i] * 2, true));
						} else {
							dq.offerLast(new CellCheck(rst[j][i], false));
						}
					} else {
						dq.offerLast(new CellCheck(rst[j][i], false));
					}
				}
				for (int j = js; j < je; j++) {
					if (!dq.isEmpty()) {
						rst[j][i] = dq.pollFirst().value;
					} else {
						rst[j][i] = 0;
					}
				}
			}
			break;
		}
	}

	public static void moveRL(String inst) {  // 열을 고정하고 행을 움직임.
		Deque<CellCheck> dq = new LinkedList<>();
		// L : 0 -> N
		int js = 0;
		int je = N;
		String direction = "zton";
		
		if(inst.equals("R")) {  // R : N -> 0
			js = (N - 1);
			je = 0;
			direction = "ntoz";
		}
		
		switch (direction) {
		case "ntoz":
			for (int i = 0; i < N; i++) {
				for (int j = js; j >= je; j--) {
					if (rst[i][j] == 0)
						continue;
					if (!dq.isEmpty()) {
						if (dq.peekLast().value == rst[i][j] && !dq.peekLast().merged) {
							dq.pollLast();
							dq.offerLast(new CellCheck(rst[i][j] * 2, true));
						} else {
							dq.offerLast(new CellCheck(rst[i][j], false));
						}
					} else {
						dq.offerLast(new CellCheck(rst[i][j], false));
					}
				}
				for (int j = js; j >= je; j--) {
					if (!dq.isEmpty()) {
						rst[i][j] = dq.pollFirst().value;
					} else {
						rst[i][j] = 0;
					}
				}
			}
			break;

		case "zton":
			for (int i = 0; i < N; i++) {
				for (int j = js; j < je; j++) {
					if (rst[i][j] == 0)
						continue;
					if (!dq.isEmpty()) {
						if (dq.peekLast().value == rst[i][j] && !dq.peekLast().merged) {
							dq.pollLast();
							dq.offerLast(new CellCheck(rst[i][j] * 2, true));
						} else {
							dq.offerLast(new CellCheck(rst[i][j], false));
						}
					} else {
						dq.offerLast(new CellCheck(rst[i][j], false));
					}
				}
				for (int j = js; j < je; j++) {
					if (!dq.isEmpty()) {
						rst[i][j] = dq.pollFirst().value;
					} else {
						rst[i][j] = 0;
					}
				}
			}
			break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 배열 크기
		int M = sc.nextInt(); // 명령어 횟수

		// 초기상태 입력
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 명령어 입력
		String[] inst = new String[M];
		for (int i = 0; i < M; i++) {
			inst[i] = sc.next();
		}

		rst = arr; // 결과 담을 배열.

		// 명령어 실행
		for (int i = 0; i < inst.length; i++) {
			if (inst[i].equals("R") || inst[i].equals("L")) {
				moveRL(inst[i]);
			} else {
				moveUD(inst[i]);
			}
		}

		// 결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(rst[i][j] + " ");
			}
			System.out.println();
		}
	}
}
