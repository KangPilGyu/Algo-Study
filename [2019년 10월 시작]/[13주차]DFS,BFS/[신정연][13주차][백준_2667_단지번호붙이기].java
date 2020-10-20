package week13;

import java.util.*;
import java.io.*;

/*
 * DFS : 재귀
 * BFS : Queue
 * 
 * 백준_2667_단지번호붙이기
 * 첫 번째 줄에는 총 단지수를 출력. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력.
 * 
 * 7		지도의 크기
 * 0110100	1은 집이 있는 곳, 0은 없는 곳
 * 0110101
 * 1110101
 * 0000111
 * 0100000
 * 0111110
 * 0111000
 * --------
 * 3		총 단지수
 * 7		단지내 집의 수 오름차순
 * 8
 * 9
 */
public class Problem_2667 {
	static int[] x = {1, 0, -1, 0};
	static int[] y = {0, 1, 0, -1};
	static int N;
	
	static boolean chkidx(int ix, int jy) {  // OutOfBounds 검사.
		if(ix<0 || jy<0 || ix>=N || jy>=N) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			byte[] arr = br.readLine().getBytes();
			for(int j=0; j<arr.length; j++) {
				map[i][j] = arr[j] - '0';
			}
		}
		
		boolean[][] vst = new boolean[N][N];  // 방문 여부 저장.
		Queue<int[]> q = new LinkedList<>();  // 다음 방문 예정 인덱스 저장.
		List<Integer> list = new ArrayList<>();  // 단지 내 집의 수 저장.
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !vst[i][j]) {
					q.add(new int[] {i, j});
					vst[i][j] = true;
					while(!q.isEmpty()) {
						int[] current = q.poll();
						cnt++;
						// vst[current[0]][current[1]] = true;  // ?????
						for(int k=0; k<x.length; k++) {
							int ix = current[0] + x[k];
							int jy = current[1] + y[k];
							if(chkidx(ix, jy)) {
								if(map[ix][jy] == 1 && !vst[ix][jy]) {
									q.add(new int[] {ix, jy});
									vst[ix][jy] = true;
								}
							}
						}
					}
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int l : list) System.out.println(l);
	}
}
