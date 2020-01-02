package week15;

import java.util.*;

/*
 * 백준_Samsung_2048(Easy) 변형 1단계
 * 4 2
 * 2 0 2 0
 * 2 2 4 4
 * 2 2 4 4
 * 2 4 8 8
 * --------
 * 0 0 0 0 
 * 0 0 0 0 
 * 0 0 2 0 
 * 8 8 16 16 
 */
public class SamsungSWTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();  // 배열 크기
		int M = sc.nextInt();  // 아래 이동 횟수
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] rst = arr;  // 결과 담을 배열.
		Deque<int[]> dq = new LinkedList<>();  // {num, 0 | 1}  0 : 합쳐지지 않음, 1 : 합쳐짐.
		
		while(M > 0) {
			for(int j=0; j<N; j++) {
				for(int i=N-1; i>=0; i--) {
					if(rst[i][j] == 0) continue;
					if(!dq.isEmpty()) {
						if(dq.peekLast()[0] == rst[i][j] && dq.peekLast()[1] == 0) {
							dq.pollLast();
							dq.offerLast(new int[] {rst[i][j]*2, 1});
						} else {
							dq.offerLast(new int[] {rst[i][j], 0});
						}
					} else {
						dq.offerLast(new int[] {rst[i][j], 0});
					}
				}
				for(int i=N-1; i>=0; i--) {
					if(!dq.isEmpty()) {
						rst[i][j] = dq.pollFirst()[0];
					} else {
						rst[i][j] = 0;
					}				
				}
			}
			M--;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
