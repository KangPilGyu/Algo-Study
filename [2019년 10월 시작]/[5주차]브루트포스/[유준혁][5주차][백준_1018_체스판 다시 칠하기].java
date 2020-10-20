package baekjoon_brute_force;
import java.io.*;
import java.util.*;
public class baekjoon_1018 {
	static String [] pattern = new String[] {"BWBWBWBW" , "WBWBWBWB"}; //번갈아서 나오는 패턴
	
	static int compare(String s1, int line) {
		int cnt = 0;
		for(int i=0; i<8; i++) {
			// 각 줄이 chess판과 몇개나 동일한 게 있는지 셈
			if(s1.charAt(i) == pattern[line].charAt(i)) cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 한줄씩 읽어들이는 br.readLine()
		// Arrays.stream을 사용해 스트림화 시키고
		// mapToInt로 각 원소들을 람다를 이용해 정수화
		// toArray()로 다시 배열화.
		// 주절주절 길게썼지만 그냥 맨 처음 입력값 배열로 바꾸는 과정....python쓸까 현타오네
		int [] inputArr = Arrays.stream(br.readLine().split(" "))
								.mapToInt(s->Integer.valueOf(s))
								.toArray();
		// String 배열 선언과 초기화 과정
		String[] board = new String[inputArr[0]];
		for(int i=0; i<inputArr[0]; i++) 
			board[i] = br.readLine();
		// min은 아무리 커봐야 32
		int min=33;
		
		// 8 * 8 로 자를 수 있는 모든 경우의 수를 찾아봄.
		// i의 최대값은 n-8, j의 최대값은 m-8
		for(int i=0; i<inputArr[0]-7; i++) {
			for(int j=0; j<inputArr[1]-7; j++) {
				// board[i][j] 부터 8 * 8 칸의 부분 board가 chess판과 얼마나 다른지 확인해줄 sum 변수
				int sum=0;
				for(int k=0; k<8; k++) {
					sum += compare(board[i+k].substring(j, j+8), k%2);
				}
				// sum이 32보다 크다면 패턴을 "BWBWBWBW" , "WBWBWBWB" 가 아니라
				//					   "WBWBWBWB" , "BWBWBWBW" 로 채우는 게 더 나음 
				sum = sum > 32 ? 64 - sum : sum;
				min = Math.min(min, sum);
			}
		}
		System.out.println(min);
	}
}
