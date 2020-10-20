package week22;

import java.io.*;

/*
 * 플로이드 와샬 알고리즘
 * 
 * 백준_11404_경로 찾기
 */
public class Problem_11403 {
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				int a = Integer.parseInt(input[j]);
				arr[i][j] = a;
			}
		}
		
		for(int i=0; i<n; i++) {  // 경유
			for(int j=0; j<n; j++) {  // 출발
				for(int k=0; k<n; k++) {  // 도착
					if(arr[j][i] + arr[i][k] == 2) arr[j][k] = 1;  // 어딘가를 거쳐서 도착이 가능한 경우
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
