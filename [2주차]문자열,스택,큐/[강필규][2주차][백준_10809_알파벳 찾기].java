package week_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjoon_10809 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		int[] ary = new int[26];
		for (int i = 0; i < ary.length; i++) {
			ary[i]= -1;
		}

		int idx;
		int cnt = 0;

		while (true) {
			try {
				idx = bf.read() - (int)'a';
				if (ary[idx] == -1) {
					ary[idx] = cnt;
				}
				cnt++;
			} catch (Exception e){
				break;
			}
		}

		for (int i = 0; i < ary.length-1; i++) {
			System.out.print(ary[i]+" ");
		}
		System.out.println(ary[ary.length-1]);

	}
}
