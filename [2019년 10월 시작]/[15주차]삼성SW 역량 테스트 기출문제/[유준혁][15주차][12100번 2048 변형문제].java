import java.util.*;
class Cell{
	int val;
	boolean merge;
	public Cell(int val, boolean merge) {
		this.val = val;
		this.merge = merge;
	}
}
class Main {
	static int[][] board;
	static int n;
	static void move() {
		for(int j = 0; j < n; j++) { // 게임판의 모든 열에 대하여
			// 병합과정
			Deque<Cell> dq = new LinkedList<>(); // 병합과 재배치를 해줄 Deque 자료구조 선택 ( 입출력이 양쪽 모두 가능, 양방향 Queue )
			for(int i = n - 1; i >= 0; i--) { // 게임판의 맨 아래 행부터 거꾸로 올라감. ( 아래 이동 시 합쳐지는 과정 )
				if(board[i][j] == 0) continue; // 0이면 무시하고 다음 칸 확인
				if(dq.size() > 0) { // 사이즈가 1보다 크다면 추가조건 확인
					Cell lastCell = dq.peekLast(); // 제일 마지막에 Deque에 들어간 Cell
					if(lastCell.val == board[i][j] && lastCell.merge == false) { // 값이 같고 아직 합쳐지지 않은 Cell이라면 병합
						dq.pollLast(); // 빼기 ( 스택 )
						dq.addLast(new Cell(board[i][j] * 2, true)); // 두 셀이 합쳐졌으므로 값은 2배, merge는 true로 넣어줌.
						continue;
					}
				}
				
				dq.addLast(new Cell(board[i][j], false)); // 합쳐지지 않은 셀이므로 merge는 false
			}
//			// 현재 dq 출력
//			System.out.print(j+" :");
//			for(Cell cell : dq) System.out.print(cell.val+" ");
//			System.out.println();
			
			// 재배치과정
			int i = n - 1; // 제일 마지막 칸 부터 채우기 위함
			while(i >= 0) { // 재배치 이후 남는 칸은 0으로 만들기 위해
				// 삼항 연산자 사용 시 한 줄로 클리어
				board[i--][j] = dq.size() > 0 ? dq.pollFirst().val : 0; // dq에 남아있는 게 있다면 맨 앞 Cell의 값을, 아니면 0. i는 1 빼줌.
			}
		}		
	}
	
	static void Print() {
		System.out.println("\n\n=====================");
		for(int[] arr : board) { // 출력
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = sc.nextInt();
		board = new int[n][n];
		for(int i = 0; i < n * n; i++) {
			board[i/n][i%n] = sc.nextInt(); // 입력저장
		}
		for(int i = 0; i < k; i++) { // 아래로 k번 이동
			Print();
			move();
		}
		Print();
	}
}