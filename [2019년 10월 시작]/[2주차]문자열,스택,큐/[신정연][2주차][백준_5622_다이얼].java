package week2;

import java.io.*;

/*
 * 백준_5622_다이얼
 * 
 * UNUCIC = 868242
 * 
 * 1			2초
 * 2 : ABC		3초
 * 3 : DEF		4초
 * 4 : GHI		.
 * 5 : JKL		.
 * 6 : MNO		.
 * 7 : PQRS
 * 8 : TUV
 * 9 : WXYZ
 * 0
 */
public class Problem_5622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] strArr = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		int[] timeArr = {3, 4, 5, 6, 7, 8, 9, 10};
		int time = 0;

		for(int i=0; i<input.length(); i++) {
			for(int j=0; j<strArr.length; j++) {
				if(strArr[j].contains(input.subSequence(i, i+1))) {
					time += timeArr[j];
				}
			}
		}

		// 처음 풀었던 구구절절 방식		
//		for(int i=0; i<input.length(); i++) {
//			if(input.charAt(i)>='A' && input.charAt(i)<='C') {
//				time += 3;
//			} else if(input.charAt(i)>='D' && input.charAt(i)<='F') {
//				time += 4;
//			} else if(input.charAt(i)>='G' && input.charAt(i)<='I') {
//				time += 5;
//			} else if(input.charAt(i)>='J' && input.charAt(i)<='L') {
//				time += 6;
//			} else if(input.charAt(i)>='M' && input.charAt(i)<='O') {
//				time += 7;
//			} else if(input.charAt(i)>='P' && input.charAt(i)<='S') {
//				time += 8;
//			} else if(input.charAt(i)>='T' && input.charAt(i)<='V') {
//				time += 9;
//			} else if(input.charAt(i)>='W' && input.charAt(i)<='Z') {
//				time += 10;
//			} else {
//				time += 2;
//			}
//		}
		
		System.out.println(time);
	}
}
